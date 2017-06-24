package com.topbeach.helpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.topbeach.beachmodel.BeachModel;

/**
 * Created by Alchimy on 5/3/2017.
 */

public class BeachDbHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "beachList.db";
    private static final int DATABASE_VERSION = 1;

    public BeachDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public BeachModel getBeachModel(int id){
        BeachModel beachModel = null;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from beaches where _id = " + id, null);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
//                    beachModel = new BeachModel(cursor.getString());
                    return beachModel;
                }
            } finally {
                cursor.close();
                db.close();
                return null;
            }
        }
        return null;

    }
}
