package com.example.progressbar.Activities.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;


public class SQLiteHelper extends SQLiteOpenHelper {


    public SQLiteHelper( Context context, String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);


    }

    public void insertData(String name){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO FILE VALUES(NULL, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name);


        statement.executeInsert();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getWritableDatabase();

        return database.rawQuery(sql, null);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
