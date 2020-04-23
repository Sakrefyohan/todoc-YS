package com.cleanup.todoc.utils;

import android.content.Context;
import android.widget.Toast;

import com.cleanup.todoc.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class StorageUtils {
    private static File createOrGetFile(File destination, String fileName, String folderName){
        File folder = new File(destination,folderName);
        return new File(folder, fileName);
    }



    // ----------------------------------
    // READ & WRITE ON STORAGE
    // Details : https://openclassrooms.com/fr/courses/4568746-gerez-vos-donnees-localement-pour-avoir-une-application-100-hors-ligne/5106561-creez-un-fichier-sur-le-stockage-externe#/id/r-5123862
    // ----------------------------------

    private static String readOnFile(Context context, File file){

        String result = null;
        if (file.exists()) {
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader(file));
                try {
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();
                    while (line != null) {
                        sb.append(line);
                        sb.append("\n");
                        line = br.readLine();
                    }
                    result = sb.toString();
                }
                finally {
                    br.close();
                }
            }
            catch (IOException e) {
                Toast.makeText(context, context.getString(R.string.error_happened), Toast.LENGTH_LONG).show();
            }
        }

        return result;
    }

    // ---

    private static void writeOnFile(Context context, String text, File file){

        try {
            file.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(file);
            Writer w = new BufferedWriter(new OutputStreamWriter(fos));

            try {
                w.write(text);
                w.flush();
                fos.getFD().sync();
            } finally {
                w.close();
                Toast.makeText(context, context.getString(R.string.saved), Toast.LENGTH_LONG).show();
            }

        } catch (IOException e) {
            Toast.makeText(context, context.getString(R.string.error_happened), Toast.LENGTH_LONG).show();
        }
    }
}
