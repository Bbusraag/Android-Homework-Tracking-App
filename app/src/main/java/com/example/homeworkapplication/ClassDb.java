package com.example.homeworkapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClassDb extends SQLiteOpenHelper {

    public ClassDb( Context context) {

            super(context, "sInIf.db", null, 1);
        }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Classdetails(name TEXT primary key,ide TEXT)");
        db.execSQL("create Table Classdetails(name TEXT primary key,ide TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists Classdetails");
    }
    public boolean classinsertdata(String name,  String ide) {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Class Name", name);
        contentValues.put("Class Ide", ide);
        long result = db.insert("Classdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean classupdatedata(String name,  String ide) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Class Ide", ide);
        Cursor cursor=db.rawQuery("Select * from Classdetails where name=?",new String[]{name});
        if(cursor.getCount()>0) {
            long result = db.update("Classdetails", contentValues, "Class name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }
    public boolean classdeletedata(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor=db.rawQuery("Select * from Classdetails where name=?",new String[]{name});
        if(cursor.getCount()>0) {
            long result = db.delete("Classdetails",  "Class name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }
    public Cursor classgetdata() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor=db.rawQuery("Select * from Classdetails",null);
        return cursor;
    }
}

