/*
Copyright (c) 2023 Divested Computing Group

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class Main {

    public static BloomFilter<String> signaturesMD5 = null;
    public static BloomFilter<String> signaturesSHA1 = null;
    public static BloomFilter<String> signaturesSHA256 = null;

    public static int amtSignaturesRead = 0;

    public static int amtSignaturesMD5 = 0;
    public static int amtSignaturesSHA1 = 0;
    public static int amtSignaturesSHA256 = 0;

    public static int amtPreviousSignaturesMD5 = 0;
    public static int amtPreviousSignaturesSHA1 = 0;
    public static int amtPreviousSignaturesSHA256 = 0;

    public static void main(String[] args) {
            signaturesMD5 = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.US_ASCII), 150000, 0.00001); //150k
            signaturesSHA1 = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.US_ASCII), 4500000, 0.00001); //4.5m
            signaturesSHA256 = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.US_ASCII), 800000, 0.00001); //800k

           for (File databaseLocation : new File(args[0]).listFiles()) {
           	 System.out.println("Processing: " + databaseLocation);
                 amtPreviousSignaturesMD5 = amtSignaturesMD5;
                 amtPreviousSignaturesSHA1 = amtSignaturesSHA1;
                 amtPreviousSignaturesSHA256 = amtSignaturesSHA256;
                    try {
                            BufferedReader reader;
                            if (databaseLocation.getName().endsWith(".gz")) {
                                reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(databaseLocation))));
                            } else {
                                reader = new BufferedReader(new FileReader(databaseLocation));
                            }
                            String line;
                            if (databaseLocation.getName().contains(".hdb")) {//.hdb format: md5, size, name
                                while ((line = reader.readLine()) != null) {
                                    if (line.length() > 0) {
                                        String[] lineS = line.trim().toLowerCase().split(":");
                                        if (lineS[0].length() > 0) {
                                            if (signaturesMD5.put(lineS[0])) {
                                                amtSignaturesMD5++;
                                            }
                                            amtSignaturesRead++;
                                        }
                                    }
                                }
                            } else if (databaseLocation.getName().contains(".hsb")) {//.hsb format: sha256, size, name
                                while ((line = reader.readLine()) != null) {
                                    if (line.length() > 0) {
                                        String[] lineS = line.trim().toLowerCase().split(":");
                                        if (lineS[0].length() == 32) {
                                            if (signaturesSHA1.put(lineS[0])) {
                                                amtSignaturesSHA1++;
                                            }
                                            amtSignaturesRead++;
                                        } else if (lineS[0].length() > 0) {
                                            if (signaturesSHA256.put(lineS[0])) {
                                                amtSignaturesSHA256++;
                                            }
                                            amtSignaturesRead++;
                                        }
                                    }
                                }
                            } else if (databaseLocation.getName().contains(".md5")) {//one signature per line
                                while ((line = reader.readLine()) != null) {
                                    if (line.length() > 0) {
                                        if (signaturesMD5.put(line.trim().toLowerCase())) {
                                            amtSignaturesMD5++;
                                        }
                                        amtSignaturesRead++;
                                    }
                                }
                            } else if (databaseLocation.getName().contains(".sha1")) {//one signature per line
                                while ((line = reader.readLine()) != null) {
                                    if (line.length() > 0) {
                                        if (signaturesSHA1.put(line.trim().toLowerCase())) {
                                            amtSignaturesSHA1++;
                                        }
                                        amtSignaturesRead++;
                                    }
                                }
                            } else if (databaseLocation.getName().contains(".sha256")) {//one signature per line
                                while ((line = reader.readLine()) != null) {
                                    if (line.length() > 0) {
                                        if (signaturesSHA256.put(line.trim().toLowerCase())) {
                                            amtSignaturesSHA256++;
                                        }
                                        amtSignaturesRead++;
                                    }
                                }
                            }
                            reader.close();
                            System.out.println("\tmd5: " + (amtSignaturesMD5-amtPreviousSignaturesMD5) + ", sha1: " + (amtSignaturesSHA1-amtPreviousSignaturesSHA1) + ", sha256: " + (amtSignaturesSHA256-amtPreviousSignaturesSHA256));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
            signaturesMD5.put("44d88612fea8a8f36de82e1278abb02f"); //Eicar test file
            signaturesSHA256.put("6a0b4866f143c32e651662cebf7f380d27b0db809db3b6a34cf34c7436ab6bbf"); //Hypatia test file

            signaturesMD5.put("903616d0dbe074aa363d2d49c03f7362"); //Hypatia self-test canaries (echo -n "HypatiaHypatiaHypatia" | sum)
            signaturesSHA1.put("fc4a3e802894cc2229be77ec6f082d1aab744e54");
            signaturesSHA256.put("df44844a0e99ddd935e8419257440a2ca7ef3243435a67416fcbb6cd3ae560c3");

            System.out.println("Result: md5: " + amtSignaturesMD5 + ", sha1: " + amtSignaturesSHA1 + ", sha256: " + amtSignaturesSHA256);
            System.out.println("Total: " + amtSignaturesRead);
            System.out.println("Mismatch: " + (amtSignaturesRead-amtSignaturesMD5-amtSignaturesSHA1-amtSignaturesSHA256));
            System.out.println("Expected false postive rate: md5: " + signaturesMD5.expectedFpp() + ", sha1: " + signaturesSHA1.expectedFpp() + ", sha256: " + signaturesSHA256.expectedFpp());
            try {
                    FileOutputStream fileSignaturesMD5 = new FileOutputStream(new File(args[0]) + "/hypatia-md5-bloom.bin");
                    signaturesMD5.writeTo(fileSignaturesMD5);
                    fileSignaturesMD5.close();

                    FileOutputStream fileSignaturesSHA1 = new FileOutputStream(new File(args[0]) + "/hypatia-sha1-bloom.bin");
                    signaturesSHA1.writeTo(fileSignaturesSHA1);
                    fileSignaturesSHA1.close();

                    FileOutputStream fileSignaturesSHA256 = new FileOutputStream(new File(args[0]) + "/hypatia-sha256-bloom.bin");
                    signaturesSHA256.writeTo(fileSignaturesSHA256);
                    fileSignaturesSHA256.close();
            } catch (Exception e) { e.printStackTrace(); }
    }
}
