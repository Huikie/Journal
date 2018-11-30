package com.example.daan.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        String journal_txt = intent.getStringExtra("title_txt");
        TextView show_Title = findViewById(R.id.Show_title);
        show_Title.setText(journal_txt);

        String timestamp_txt = intent.getStringExtra("timestamp_txt");
        TextView show_Timestamp = findViewById(R.id.Show_timestamp);
        show_Timestamp.setText(timestamp_txt);

        String mood_txt = intent.getStringExtra("mood_txt");
        int mood_id = getResources().getIdentifier(mood_txt , "drawable", getPackageName());
        ImageView show_Mood = findViewById(R.id.Show_mood);
        show_Mood.setImageResource(mood_id);

        String content_txt = intent.getStringExtra("content_txt");
        TextView show_Content = findViewById(R.id.Show_content);
        show_Content.setText(content_txt);
    }
}
