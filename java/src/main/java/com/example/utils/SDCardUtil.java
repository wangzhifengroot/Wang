package com.example.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.File;
@Deprecated
public class SDCardUtil {


    /**
     * 检查外部存储器是否可供读取和写入
     *
     * @return true：可用；false：不可用
     */
    public static boolean isExternalStorageWritable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }


    /**
     *
     *
     * @return SD卡存在返回正常路径；SD卡不存在返回""
     */
    public static String getSDCardPath() {
        if (isExternalStorageWritable()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
        } else {
            return "";
        }
    }


//    public static void getExternalStorageDirectory() {
//        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
//            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
//        } else {
//
//        }
//
//    }

    public static void getExternalFilesDirs(Context context) {
        File[] files;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            files = context.getExternalFilesDirs(Environment.MEDIA_MOUNTED);
            for (File file : files) {
                Log.e("TAG", file.getAbsolutePath());
            }
        }
    }


}
