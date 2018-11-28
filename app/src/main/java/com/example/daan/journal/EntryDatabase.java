package com.example.daan.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class EntryDatabase extends SQLiteOpenHelper {
    private static EntryDatabase instance;
    private static String DB_NAME = "myDB";
    private static int DB_VERSION = 1;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE entries (title TEXT, content TEXT, mood TEXT, timestamp DATETIME DEFAULT CURRENT_TIMESTAMP, _id INTEGER PRIMARY KEY AUTOINCREMENT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS entries");
        onCreate(db);
    }

    private EntryDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public static EntryDatabase getInstance(Context context){
        if(instance != null){
            return instance;
        }
        else{
            instance = new EntryDatabase(context, DB_NAME, null, DB_VERSION);
            return instance;
        }
    }

    public Cursor selectAll(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM entries",null);
        return cursor;
    }
    public void insert(JournalEntry entry){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", entry.getTitle());
        values.put("content", entry.getContent());
        values.put("mood", entry.getMood());
        db.insert("entries", null, values);
    }
    public void delete(long id){
        String id_string = Long.toString(id);
        SQLiteDatabase db = getWritableDatabase();
        db.delete("entries","_id = ?", new String[]{id_string});
    }
}
