package com.example.kazi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context, "mydata", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student (reg text primary key, name text, address text, date text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student");
        onCreate(db);
    }

    public boolean InsertStudent(String reg, String name, String address, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("reg", reg);
        cv.put("address", address);
        cv.put("date", date);
        long result = db.insert("student", null, cv);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getStudent(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from student";
        return db.rawQuery(query, null);
    }

}
