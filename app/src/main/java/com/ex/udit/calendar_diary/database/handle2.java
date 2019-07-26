package com.ex.udit.calendar_diary.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class handle2 extends SQLiteOpenHelper {

    private static final int version = 1;
    public static String name;
    public static final String Column_Name="t";
    public static String table="ww";

    private String Create_table="CREATE TABLE "+ table +" ( "+Column_Name+" TEXT )";

    public handle2(Context context) {
        super(context, name,null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db1) {

        db1.execSQL(Create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db2, int i, int i1) {
        db2.execSQL("DROP TABLE IF EXISTS " + table);
        onCreate(db2);
    }

    public void insertData(String note){
        SQLiteDatabase db3 = this.getWritableDatabase();
        String selectQuery = "INSERT INTO "+table +" VALUES ('" + note +"')";
        db3.execSQL(selectQuery);
        db3.close();
    }

    public void deleteData(){
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("DELETE FROM " + table);
        db.close();
    }

    public String getNote() {
        SQLiteDatabase db4= this.getReadableDatabase();
        String selectQuery = "SELECT "+Column_Name+" FROM " + table;
        Cursor res=db4.rawQuery(selectQuery, null);
        if (res != null)
            res.moveToFirst();

        String s;
        do {
            s = res.getString(0);
        }while (res.moveToNext());
        db4.close();
        return s;
    }
}