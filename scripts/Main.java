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

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static BloomFilter<String> signaturesMD5 = null;
    public static BloomFilter<String> signaturesSHA1 = null;
    public static BloomFilter<String> signaturesSHA256 = null;

    public static int amtLinesValid = 0;
    public static int amtLinesInvalid = 0;


    public static int amtSignaturesReadMD5 = 0;
    public static int amtSignaturesReadSHA1 = 0;
    public static int amtSignaturesReadSHA256 = 0;

    public static int amtSignaturesAddedMD5 = 0;
    public static int amtSignaturesAddedSHA1 = 0;
    public static int amtSignaturesAddedSHA256 = 0;

    public static int amtPreviousSignaturesMD5 = 0;
    public static int amtPreviousSignaturesSHA1 = 0;
    public static int amtPreviousSignaturesSHA256 = 0;

    public static void main(String[] args) {
        signaturesMD5 = BloomFilter.create(Funnels.stringFunnel(Charsets.US_ASCII), 5800000, 0.00001); //5.8m
        signaturesSHA1 = BloomFilter.create(Funnels.stringFunnel(Charsets.US_ASCII), 10000, 0.00001); //10k
        signaturesSHA256 = BloomFilter.create(Funnels.stringFunnel(Charsets.US_ASCII), 800000, 0.00001); //800k

        System.out.println("Processing:");
        for (File databaseLocation : new File(args[0]).listFiles()) {
            System.out.println("\t" + databaseLocation);
            amtPreviousSignaturesMD5 = amtSignaturesAddedMD5;
            amtPreviousSignaturesSHA1 = amtSignaturesAddedSHA1;
            amtPreviousSignaturesSHA256 = amtSignaturesAddedSHA256;
            try {
                BufferedReader reader;
                if (databaseLocation.getName().endsWith(".gz")) {
                    reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(databaseLocation))));
                } else {
                    reader = new BufferedReader(new FileReader(databaseLocation));
                }
                String line;
                if (databaseLocation.getName().contains(".hdb") //.hdb format: md5, size, name
                        || databaseLocation.getName().contains(".hsb")) {//.hsb format: sha256, size, name
                    while ((line = reader.readLine()) != null) {
                        if (line.length() > 0 && line.contains(":")) {
                            String[] lineS = line.trim().toLowerCase().split(":");
                            addChecked(lineS[0]);
                        }
                    }
                } else if (databaseLocation.getName().contains(".md5")
                        || databaseLocation.getName().contains(".sha1")
                        || databaseLocation.getName().contains(".sha256")) {//one signature per line
                    while ((line = reader.readLine()) != null) {
                        addChecked(line.trim().toLowerCase());
                    }
                }
                reader.close();
                System.out.println("\t\tmd5: " + (amtSignaturesAddedMD5 - amtPreviousSignaturesMD5) + ", sha1: " + (amtSignaturesAddedSHA1 - amtPreviousSignaturesSHA1) + ", sha256: " + (amtSignaturesAddedSHA256 - amtPreviousSignaturesSHA256));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Lines read: valid: " + amtLinesValid + ", invalid: " + amtLinesInvalid);
        System.out.println("Read count: md5: " + amtSignaturesReadMD5 + ", sha1: " + amtSignaturesReadSHA1 + ", sha256: " + amtSignaturesReadSHA256);
        System.out.println("Added count: md5: " + amtSignaturesAddedMD5 + ", sha1: " + amtSignaturesAddedSHA1 + ", sha256: " + amtSignaturesAddedSHA256);
        System.out.println("Approximate count: md5: " + signaturesMD5.approximateElementCount() + ", sha1: " + signaturesSHA1.approximateElementCount() + ", sha256: " + signaturesSHA256.approximateElementCount());
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Credit: https://stackoverflow.com/a/13667522
    private static final Pattern HEXADECIMAL_PATTERN = Pattern.compile("\\p{XDigit}+");

    private static boolean isHexadecimal(String input) {
        final Matcher matcher = HEXADECIMAL_PATTERN.matcher(input);
        return matcher.matches();
    }

    private static void addChecked(String potentialHash) {
        if (!potentialHash.startsWith("#") && potentialHash.length() >= 4) {
            if (isHexadecimal(potentialHash)) {
                if (potentialHash.length() == 32) {
                    if (signaturesMD5.put(potentialHash)) {
                        amtSignaturesAddedMD5++;
                    }
                    amtSignaturesReadMD5++;
                    amtLinesValid++;
                } else if (potentialHash.length() == 40) {
                    if (signaturesSHA1.put(potentialHash)) {
                        amtSignaturesAddedSHA1++;
                    }
                    amtSignaturesReadSHA1++;
                    amtLinesValid++;
                } else if (potentialHash.length() == 64) {
                    if (signaturesSHA256.put(potentialHash)) {
                        amtSignaturesAddedSHA256++;
                    }
                    amtSignaturesReadSHA256++;
                    amtLinesValid++;
                } else {
                    amtLinesInvalid++;
                    System.out.println("\t\tINVALID LENGTH: " + potentialHash);
                }
            } else {
                amtLinesInvalid++;
                System.out.println("\t\tNOT HEXADECIMAL: " + potentialHash);
            }
        }
    }
}
