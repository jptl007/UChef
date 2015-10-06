package com.example.jay.uchef;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dhaval Trivedi on 02-10-2015.
 */
public class databaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="RECIPE.db";
    public static final String TABLE_NAME = "Recipe_Table";

    public static final String Recipe_ID = "Recipe ID";
    public static final String Recipe_NAME = "Name";
    public static final String Recipe_Desc = "Description";
    public static final String Recipe_Link = "Recipe_Link";

    public databaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "( Recipe ID Integer Primary Key Autoincrement, Name Text,Description Text, Recipe Link character) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME);
        onCreate(db);

    }
}
