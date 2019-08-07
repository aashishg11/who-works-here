package com.aashishgodambe.whosworking.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.aashishgodambe.whosworking.model.Employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCacheManager {

    public static Bitmap getImage(Context context, Employee employee) {

        String fileName = context.getCacheDir() + "/" + employee.getFullName();
        File file = new File(fileName);
        Bitmap bitmap = null;

        try {
            bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static void putImage(Context context, Employee employee, Bitmap bitmap) {

        String fileName = context.getCacheDir() + "/" + employee.getFullName();
        File file = new File(fileName);
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
