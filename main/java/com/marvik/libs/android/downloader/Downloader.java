package com.marvik.libs.android.downloader;

import android.content.Context;
import android.content.Intent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public final class Downloader {

    private static Context context;

    private Downloader() {
    }

    public static Downloader getInstance(Context context) {
        Downloader.context = context;
        return new Downloader();
    }

    public void downloadFile(final String fileUri, final String filePath) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(fileUri);
                    URLConnection urlConnection = url.openConnection();
                    InputStream inputStream = urlConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                    String filename = new File(filePath).getName();
                    int count = 0;
                    byte[] buffer = new byte[1024];

                    File fileDir = new File(filePath).getParentFile();

                    if (!fileDir.exists()) {
                        fileDir.mkdirs();
                    }

                    File downloadFile = new File(fileDir + System.getProperty("file.separator") + filename);

                    //Ensure that we do not always download existing files
                    if (downloadFile.exists()) {
                        return;
                    }

                    FileOutputStream fileOutputStream = new FileOutputStream(downloadFile);
                    while ((count = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, count);
                    }

                    context.sendBroadcast(new Intent("com.marvik.libs.android.downloader.Downloader.ACTION_FILE_DOWNLOADED"));

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
