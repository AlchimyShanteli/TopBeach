package com.topbeach.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.topbeach.beachmodel.BeachModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alchimy on 5/12/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "beachList";
    private static final String TABLE_LIST_BEACH = "beachList.db";
    private static final String KEY_ID = "_id";
    private static final String NAME_COUNTRY = "country_name";
    private static final String NAME_ISLAND = "island_name";
    private static final String NAME_CITY = "city_name";
    private static final String NAME_BEACH = "beach_name";
    private static final String DESCRIPTION_BEACH = "beach_description";
    private static final String IMAGE_BEACH = "url_id";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LISTBEACH_TABLE = "CREATE TABLE " + TABLE_LIST_BEACH + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + NAME_COUNTRY + " TEXT," + NAME_ISLAND + " TEXT," + NAME_CITY + " TEXT,"
                + NAME_BEACH + " TEXT," + DESCRIPTION_BEACH + " TEXT,"
                + IMAGE_BEACH + " TEXT" + ")";
        db.execSQL(CREATE_LISTBEACH_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_LIST_BEACH);

        onCreate(db);

    }

    public void addContact(BeachModel beachModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COUNTRY, beachModel.getNameCountry());
        values.put(NAME_ISLAND, beachModel.getNameIsland());
        values.put(NAME_CITY, beachModel.getNameCity());
        values.put(NAME_BEACH, beachModel.getNameBeach());
        values.put(DESCRIPTION_BEACH, beachModel.getDescriptionBeach());
        values.put(IMAGE_BEACH, beachModel.getImageUrl());

        db.insert(TABLE_LIST_BEACH, null, values);
        db.close();
    }

    //@Override
    public BeachModel getBeachModel(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LIST_BEACH, new String[]{KEY_ID,
                        NAME_COUNTRY, NAME_ISLAND, NAME_CITY, NAME_BEACH, DESCRIPTION_BEACH, IMAGE_BEACH}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        BeachModel beachModel = new BeachModel(Integer.parseInt(cursor.getString(0)), cursor.getColumnName(1), cursor.getColumnName(2),
                cursor.getColumnName(3), cursor.getColumnName(4), cursor.getColumnName(5), cursor.getColumnName(6));

        return beachModel;
    }

    //@Override
    public List<BeachModel> getAllBeachList() {
        List<BeachModel> beachList = new ArrayList<BeachModel>();
        String selectQuery = "SELECT  * FROM " + TABLE_LIST_BEACH;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                BeachModel beachModel = new BeachModel(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getColumnName(2),
                        cursor.getColumnName(3), cursor.getColumnName(4), cursor.getColumnName(5), cursor.getColumnName(6));
                beachModel.set_id(Integer.parseInt(cursor.getString(0)));
                beachModel.setNameCountry(cursor.getString(1));
                beachModel.setNameIsland(cursor.getString(2));
                beachModel.setNameCity(cursor.getString(3));
                beachModel.setNameBeach(cursor.getString(4));
                beachModel.setDescriptionBeach(cursor.getString(5));
                beachModel.setIdUrl(cursor.getString(6));
                beachList.add(beachModel);
            } while (cursor.moveToNext());
        }

        return beachList;
    }

    //@Override
    public int updateList(BeachModel beachModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_COUNTRY, beachModel.getNameCountry());
        values.put(NAME_ISLAND, beachModel.getNameIsland());
        values.put(NAME_CITY, beachModel.getNameCity());
        values.put(NAME_BEACH, beachModel.getNameBeach());
        values.put(DESCRIPTION_BEACH, beachModel.getDescriptionBeach());
        values.put(IMAGE_BEACH, beachModel.getImageUrl());

        return db.update(TABLE_LIST_BEACH, values, KEY_ID + " = ?",
                new String[]{String.valueOf(beachModel.get_id())});
    }

    //@Override
    public void deleteList(BeachModel beachModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LIST_BEACH, KEY_ID + " = ?", new String[]{String.valueOf(beachModel.get_id())});
        db.close();
    }

    //@Override
    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LIST_BEACH, null, null);
        db.close();
    }

    //@Override
    public int getListBeachCount() {
        String countQuery = "SELECT  * FROM " + TABLE_LIST_BEACH;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

}
