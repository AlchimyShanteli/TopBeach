package com.topbeach.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static android.R.attr.id;

/**
 * Created by Alchimy on 5/8/2017.
 */

public class DataBase extends SQLiteOpenHelper{
    //String DB_PATH = null;
    private static String DB_PATH = "/data/data/com.topbeach.database/databases/";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_LIST_BEACH = "beachList.db";
    private static final String KEY_ID = "_id";
    private static final String NAME_COUNTRY = "country_name";
    private static final String NAME_ISLAND = "island_name";
    private static final String NAME_CITY = "city_name";
    private static final String NAME_BEACH = "beach_name";
    private static final String DESCRIPTION_BEACH = "beach_description";
    private static final String IMAGE_BEACH = "url_id";
    public static String DB_NAME = "beachList.db";
    public SQLiteDatabase myDataBase;
    private final Context mContext;


    public DataBase(Context context) {
        super(context, DB_NAME, null, 1);
        this.mContext = context;
       // this.DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
        Log.e("Path 1", DB_PATH);
    }

    public Cursor getAllData() {
        //aici primim datele din tabela NAME_TABLE
        return myDataBase.query("beachList.db", null, null, null, null, null, null);
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();

        if(dbExist){

        }else{

            this.getReadableDatabase();

            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }
    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch(SQLiteException e){
            //bd inca nu exista
        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException{

        InputStream myInput = mContext.getAssets().open(DB_NAME);

        String outFileName = DB_PATH + DB_NAME;

        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
    public void openDataBase() throws SQLException {

        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public synchronized void close() {
        if(myDataBase != null)
            myDataBase.close();
        super.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Cursor cursor = db.query(TABLE_LIST_BEACH, new String[] { KEY_ID,
                        NAME_COUNTRY, NAME_ISLAND, NAME_CITY, NAME_BEACH, DESCRIPTION_BEACH, IMAGE_BEACH }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Beaches " + DB_NAME);

        onCreate(db);

    }
    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return myDataBase.query("Imagesbeaches", null, null, null, null, null, null);
    }


}


