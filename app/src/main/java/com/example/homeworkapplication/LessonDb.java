package com.example.homeworkapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LessonDb extends SQLiteOpenHelper {
    public LessonDb( Context context) {
        super(context, "student.db",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Lessondetails(lessonName TEXT primary key,lessonDepartment TEXT)");
        db.execSQL("create Table Lessondetails(lessonName TEXT primary key,lessonDepartment TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        db.execSQL("drop Table if exists Lessondetails");

    }
    public boolean lessoninsertdata(String lessonName,  String lessonDepartment) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Lesson Name", lessonName);
        contentValues.put("Lesson Department", lessonDepartment);
        long result = db.insert("Lessondetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean lessonupdatedata(String lessonName,  String lessonDepartment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Lesson department", lessonDepartment);
        Cursor cursor=db.rawQuery("Select * from Lessondetails where lessonName=?",new String[]{lessonName});
        if(cursor.getCount()>0) {
            long result = db.update("Lessondetails", contentValues, "Lesson name=?", new String[]{lessonName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }
    public boolean lessondeletedata(String lessonName) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor=db.rawQuery("Select * from Lessondetails where lessonName=?",new String[]{lessonName});
        if(cursor.getCount()>0) {
            long result = db.delete("Lessondetails",  "lesson name=?", new String[]{lessonName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }
    public Cursor lessongetdata() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor=db.rawQuery("Select * from Lessondetails",null);
        return cursor;
    }
}
