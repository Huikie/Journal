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

        // Define a query that creates a new table called entries.
        String query = "CREATE TABLE entries (title TEXT, content TEXT, mood INTEGER, timestamp DATETIME DEFAULT (datetime('now', 'localtime')), _id INTEGER PRIMARY KEY AUTOINCREMENT)";

        // Execute the query.
        db.execSQL(query);
    }

    @Override
    /** Code that drops the entries table (if it exists) and recreates it by calling onCreate().*/
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS entries");
        onCreate(db);
    }

    //Constructor
    private EntryDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**This method returns the value of instance if available, and otherwise calls the constructor,
     * with the right parameters, and storing that in instance.*/
    public static EntryDatabase getInstance(Context context){
        if(instance != null){
            return instance;
        }
        else{
            instance = new EntryDatabase(context, DB_NAME, null, DB_VERSION);
            return instance;
        }
    }

    /**Method that selects everything from entries and stores it in a Cursor.*/
    public Cursor selectAll(){

        // Open up connection with database.
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM entries",null);
        return cursor;
    }
    /**Method that inserts a JournalEntry to the database.*/
    public void insert(JournalEntry entry){

        // Open up connection with database.
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", entry.getTitle());
        values.put("content", entry.getContent());
        values.put("mood", entry.getMood());
        db.insert("entries", null, values);
    }
    /**Method that deletes a JournalEntry from the database.*/
    public void delete(long id){
        String id_string = Long.toString(id);

        // Open up connection with database.
        SQLiteDatabase db = getWritableDatabase();

        // Delete JournalEntry from the database that matches to the clicked id.
        db.delete("entries","_id = ?", new String[]{id_string});

    }
}
