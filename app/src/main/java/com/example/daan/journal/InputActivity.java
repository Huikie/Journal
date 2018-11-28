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

        TextView input_Title = findViewById(R.id.input_Title);
        String input_title_Text = input_Title.getText().toString();

        TextView input_Content = findViewById(R.id.input_Content);
        String input_content_Text = input_Content.getText().toString();

        TextView input_Mood = findViewById(R.id.input_Mood);
        String input_mood_Text = input_Mood.getText().toString();

        JournalEntry entry = new JournalEntry(input_title_Text, input_content_Text,null,0,input_mood_Text);
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        db.insert(entry);
        finish();
    }
}
