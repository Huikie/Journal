package com.example.daan.journal;

import android.content.Intent;
import android.database.Cursor;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EntryDatabase db;
    EntryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView journalList = findViewById(R.id.Journal_list);
        db = EntryDatabase.getInstance(getApplicationContext());

        journalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        journalList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
                Cursor clickedJournal = (Cursor) parent.getItemAtPosition(i);
                int ID_index = clickedJournal.getColumnIndex("_id");
                long journal_ID = clickedJournal.getInt(ID_index);
                //EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
                db.delete(journal_ID);
                updateData();
                return true;
            }
        });

        //EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        Cursor cursor = db.selectAll();
        adapter = new EntryAdapter(this,R.layout.entry_row,cursor);
        journalList.setAdapter(adapter);

    }
    @Override
    public void onResume(){
        super.onResume();


    }
public void create_Journal(View view) {
    Intent intent = new Intent(MainActivity.this, InputActivity.class);
    startActivity(intent);
}
    private void updateData(){
        adapter.swapCursor(db.selectAll());
    }

}
