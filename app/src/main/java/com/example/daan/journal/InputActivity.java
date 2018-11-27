package com.example.daan.journal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.sql.Timestamp;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }
    public void addEntry(View view) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        TextView input_Title = findViewById(R.id.input_Title);
        String input_title_Text = input_Title.getText().toString();
        TextView input_Content = findViewById(R.id.input_Content);
        String input_content_Text = input_Content.getText().toString();

        JournalEntry entry = new JournalEntry(input_title_Text, input_content_Text,timestamp,0,0);
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        db.insert(entry);
        //Log.d("db", db.toString());
    }
}
