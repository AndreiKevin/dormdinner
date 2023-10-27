package com.mobdeve.s16.chua.andreikevin.dormdinner.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "dormDiner_favoriteRecipes";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "favoriteRecipes";
    private static final String ID_COL = "id";
    private static final String RECIPE_NAME_COL = "recipe_name";
    private static final int IMAGE = 0;
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RECIPE_NAME_COL + " TEXT)";

        db.execSQL(query);
    }

    public void addNewFav(String recipeName/*, int image*/) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(RECIPE_NAME_COL, recipeName);
        //values.put(String.valueOf(IMAGE), image);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}
