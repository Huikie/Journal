package com.example.daan.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Gives access to the database and the adapter.
    EntryDatabase db;
    EntryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView journalList = findViewById(R.id.Journal_list);
        db = EntryDatabase.getInstance(getApplicationContext());

        // Putting information about a clicked journal to the detail activity on click.
        journalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
                Cursor clickedJournal = (Cursor) parent.getItemAtPosition(i);

                int title_index = clickedJournal.getColumnIndex("title");
                String title_txt = clickedJournal.getString(title_index);

                int timestamp_index = clickedJournal.getColumnIndex("timestamp");
                String timestamp_txt = clickedJournal.getString(timestamp_index);

                int mood_index = clickedJournal.getColumnIndex("mood");
                String mood_txt = clickedJournal.getString(mood_index);

                int content_index = clickedJournal.getColumnIndex("content");
                String content_txt = clickedJournal.getString(content_index);

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("title_txt", title_txt);
                intent.putExtra("timestamp_txt", timestamp_txt);
                intent.putExtra("mood_txt", mood_txt);
                intent.putExtra("content_txt", content_txt);
                startActivity(intent);
            }
        });

        // Delete a clicked journal on long click.
        journalList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
                Cursor clickedJournal = (Cursor) parent.getItemAtPosition(i);
                int ID_index = clickedJournal.getColumnIndex("_id");
                long journal_ID = clickedJournal.getInt(ID_index);
                db.delete(journal_ID);
                updateData();
                return true;
            }
        });

        Cursor cursor = db.selectAll();
        adapter = new EntryAdapter(this,R.layout.entry_row,cursor);
        journalList.setAdapter(adapter);

    }

    @Override
    /**Method that updates data on resume.*/
    public void onResume(){
        super.onResume();
        updateData();
    }

    /**Function that directs the user to the activity where he/she can create a journal entry.*/
    public void create_Journal(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }

    /**Method that updates the database every time something is changed.*/
    private void updateData(){

        // Put in a new cursor for the updated data.
        adapter.swapCursor(db.selectAll());
    }

}
