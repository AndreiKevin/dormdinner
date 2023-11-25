package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "dormDiner_favoriteRecipes";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "favoriteRecipes";
    private static final String RECIPE_NAME_COL = "recipe_name";
    private static final String RECIPE_BANNER_URL = "recipe_banner_url";
    private static final int IMAGE = 0;
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + RECIPE_NAME_COL + " TEXT, " + RECIPE_BANNER_URL + " TEXT);";

        db.execSQL(query);
    }

    public void addNewFav(String recipeName, String imgUrl) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(RECIPE_NAME_COL, recipeName);
        values.put(RECIPE_BANNER_URL, imgUrl);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Boolean deleteData(String recipeName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from favoriteRecipes where recipe_name = ?", new String[]{recipeName});
        if (cursor.getCount() > 0){
            long result = db.delete("favoriteRecipes", "recipe_Name=?", new String[]{recipeName});
            if (result == -1){
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from favoriteRecipes", null);
        return cursor;
    }
}
