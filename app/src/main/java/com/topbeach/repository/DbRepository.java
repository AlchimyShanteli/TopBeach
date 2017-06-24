package com.topbeach.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.topbeach.beachmodel.BeachModel;
import com.topbeach.helpers.DbHelper;
import com.topbeach.mainactivity.MainActivity;

import java.util.ArrayList;

/**
 * Created by Alchimy on 5/14/2017.
 */

public class DbRepository {
    private SQLiteDatabase db;
    private Context context;

    public DbRepository(Context context) {
        //LEGATURA CU BD
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getReadableDatabase();
        this.context = context;
    }

    public ArrayList<BeachModel> getData() {
        MainActivity.Fields field = MainActivity.Fields.COUNTRY_NAME;
        // MainActivity.Fields field1 = MainActivity.Fields.ISLAND_NAME;
        //  MainActivity.Fields field2 = MainActivity.Fields.CITY_NAME;
        //  MainActivity.Fields field3 = MainActivity.Fields.BEACH_NAME;
        //  MainActivity.Fields field4 = MainActivity.Fields.BEACH_DESCRIPTION;
        //    MainActivity.Fields field5 = MainActivity.Fields.IMAGE_URL;
        ArrayList<BeachModel> list = new ArrayList<>();
        Log.e("sad", "getData: " + db.isOpen());
        Log.e("sad", "getData: " + db.getPath());
        Cursor cursor = db.query("Beaches", null, null, null, null, null, null);
        if ((cursor != null) && (cursor.getCount() > 0)) {
            cursor.moveToFirst();
            do {
                list.add(new BeachModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)
                        , cursor.getString(4), cursor.getString(5), cursor.getString(6)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
}
