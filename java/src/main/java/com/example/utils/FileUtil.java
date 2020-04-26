package com.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Deprecated
public class FileUtil {

    private static final String TAG = "FileUtil";

    public interface FileCallback {
        void onSuccess(String result);

        void onFailure(String msg);
    }

    /**
     *
     * @param dest
     * @param fileName
     * @param callback
     */
    public static void readJsonFileFromSdcard(final String dest, final String fileName, final FileCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                File file = new File(dest, fileName);
                String jsonString = null;
                try {
                    FileInputStream fis = new FileInputStream(file);
                    int size = fis.available();
                    byte[] buffer = new byte[size];
                    fis.read(buffer);
                    jsonString = new String(buffer);
                    callback.onSuccess(jsonString);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    callback.onFailure(e.getLocalizedMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                    callback.onFailure(e.getLocalizedMessage());
                }
            }
        }).start();
    }

}
