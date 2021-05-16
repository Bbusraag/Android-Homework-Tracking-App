package com.example.homeworkapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {

    public Dbhelper(Context context) {
        super(context, "student.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Studentdetails(name TEXT primary key,surname TEXT,department TEXT)");
        db.execSQL("create Table Studentdetails(name TEXT primary key,surname TEXT,department TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists Studentdetails");

    }
    public boolean insertdata(String name, String surname, String department) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("surname", surname);
        contentValues.put("department", department);
        long result = db.insert("Studentdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean updatedata(String name, String surname, String department) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("name", name);
        contentValues.put("surname", surname);
        contentValues.put("department", department);
        Cursor cursor=db.rawQuery("Select * from Studentdetails where name=?",new String[]{name});
        if(cursor.getCount()>0) {
            long result = db.update("Studentdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }
    public boolean deletedata(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor=db.rawQuery("Select * from Studentdetails where name=?",new String[]{name});
        if(cursor.getCount()>0) {
            long result = db.delete("Studentdetails",  "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }
    public Cursor getdata() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor=db.rawQuery("Select * from Studentdetails",null);
        return cursor;
    }


}

