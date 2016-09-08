package com.example.aone.navigationview_01.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aone on 2016/7/28.
 */
public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(Context context) {
        super(context, "User.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE USER(_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME VARCHAR(20),PASSWORD VARCHAR(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
