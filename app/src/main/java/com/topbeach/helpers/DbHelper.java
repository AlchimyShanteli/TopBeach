package com.topbeach.helpers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.topbeach.parsers.FileParser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Alchimy on 5/3/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
//    private static String DB_PATH = "/data/data/com.topbeach/databases/";
    private static String DB_NAME = "beachList.db";
    private final Context fContext;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.fContext = context;
    }
//    public void createDataBase() throws IOException {
//        boolean dbExist = checkDataBase();
//        if (dbExist) {
//            //failul cu bd exista, (nu scriem nimic)
//        } else {
//            this.getReadableDatabase();
//            try {
//                copyDataBase();
//            } catch (IOException e) {
//                throw new Error("Error copying database");
//            }
//        }
//    }
//    private boolean checkDataBase() {
//        SQLiteDatabase checkDB = null;
//        try {
//            String myPath = DB_PATH + DB_NAME;
//            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
//        } catch (SQLiteException e) {
//            //failul cu bd nu exista
//        }
//        if (checkDB != null) {
//            checkDB.close();
//        }
//        return checkDB != null ? true : false;
//    }
//    private void copyDataBase() throws IOException {
//        InputStream input = fContext.getAssets().open(DB_NAME);
//        String outFileName = DB_PATH + DB_NAME;
//        OutputStream output = new FileOutputStream(outFileName);
//        byte[] buffer = new byte[1024];
//        int length;
//        while ((length = input.read(buffer)) > 0) {
//            output.write(buffer, 0, length);
//        }
//        output.flush();
//        output.close();
//        input.close();
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        Log.e("sfd", "onCreate: ");
//        Log.e("asd", "onCreate: " + db.toString());
//        db.execSQL(FileParser.loadFile(fContext));
//        Log.e("asd", "onCreate: " + db.getPath());
//        Log.e("asd", "onCreate: " + db.toString());
        List<String> queries = Arrays.asList(FileParser.loadFile(fContext).split(";"));
        for (String query : queries) {
            //Log.i(LOG , query+";");
            db.execSQL(query + ";");
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}

