package us.spotco.veritas;

import android.content.Context;
import android.os.AsyncTask;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Database {

    private static Context context = null;
    private static TextView log = null;
    private static MenuItem databaseUpdateCheckOption = null;
    private static File databasePath = null;
    private static String databaseName = "clamav-main.hsb";
    private static final String databaseUpdateURL = "https://spotco.us/clamav-main.hsb";

    public Database(Context context, TextView log, MenuItem databaseUpdateCheckOption) {
        this.context = context;
        this.log = log;
        this.databaseUpdateCheckOption = databaseUpdateCheckOption;
        databasePath = new File(context.getFilesDir() + databaseName);
    }

    public static boolean doesDatabaseExist() {
        return databasePath.exists();
    }

    public static boolean shouldUpdateDatabase() {
        return databaseUpdateCheckOption.isChecked();
    }

    public static void updateDatabase() {
        new Downloader().execute(databaseUpdateURL, databasePath.toString());
    }

    public static void loadDatabase() {
        //Database format: md5, size, name, unknown
    }

    public static String checkInDatabase(String hash) {
        return null;
    }

    public static class Downloader extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];
            File out = new File(strings[1]);
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setConnectTimeout(45000);
                connection.setReadTimeout(45000);
                connection.addRequestProperty("User-Agent", "Veritas Database Updater");
                if (out.exists()) {
                    connection.setIfModifiedSince(out.lastModified());
                }
                connection.connect();
                int res = connection.getResponseCode();
                if (res != 304) {
                    if(res == 200) {
                        if (out.exists()) {
                            out.delete();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(out);

                        final byte data[] = new byte[1024];
                        int count;
                        while ((count = connection.getInputStream().read(data, 0, 1024)) != -1) {
                            fileOutputStream.write(data, 0, count);
                        }

                        fileOutputStream.close();
                        publishProgress("Successfully downloaded " + url + "\n");
                    } else {
                        publishProgress("File not downloaded " + res + "\n");
                    }
                } else {
                    publishProgress("File not changed " + url + "\n");
                }
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
                publishProgress("Failed to download file from " + url + "\n");
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... progress) {
            log.append(progress[0] + "\n");
        }

        @Override
        protected void onPostExecute(String result) {

        }
    }
}
