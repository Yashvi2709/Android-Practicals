package com.example.practical15;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context c){
        super(c,"NotesDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE notes(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "note TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldV,int newV){
        db.execSQL("DROP TABLE IF EXISTS notes");
        onCreate(db);
    }

    public void insertNote(String note){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("note",note);
        db.insert("notes",null,cv);
    }

    public Cursor getNotes(){

        SQLiteDatabase db=this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM notes",null);
    }

    public void deleteNote(int id){

        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("notes","id=?",new String[]{String.valueOf(id)});
    }
}