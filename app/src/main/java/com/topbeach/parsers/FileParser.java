package com.topbeach.parsers;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alchimy on 4/25/2017.
 */

public class FileParser {
    //private final String TAG = getClass().getSimpleName();

   // public List<BeachModel> loadBD(Context context) {
           //  AssetManager assetManager = context.getAssets();
        //return loadBD(context);

    //}

    private static final String TAG = FileParser.class.getSimpleName();
    public static String loadFile(Context context) {
        try {
            AssetManager assetManager = context.getAssets();
            InputStreamReader istream = new InputStreamReader(assetManager.open("beachList.db.sql"));
            BufferedReader in = new BufferedReader(istream);

            StringBuilder allContentFromFile = new StringBuilder();
            String word;

            while ((word = in.readLine()) != null) {
                allContentFromFile.append(word);
            }
            in.close();
            return allContentFromFile.toString();

        } catch (FileNotFoundException e) {
            Log.e(TAG, "loadFile: ", e);
        } catch (IOException e) {
            Log.e(TAG, "loadFile: ", e);
        }
        return null;
    }
}





