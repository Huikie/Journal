package com.example.daan.journal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class InputActivity extends AppCompatActivity {
    String mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    /**Method that lets the user choose the mood that he/she is in
     * and gives the user information on their choice.*/
    public void chooseMood(View view){
        switch(view.getId()){
            case R.id.angry:
                mood = "angry";
                Toast.makeText(InputActivity.this,"You choose an angry mood", Toast.LENGTH_SHORT).show();
                break;
            case R.id.laugh:
                mood = "laugh";
                Toast.makeText(InputActivity.this,"You choose a laughing mood", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cry:
                mood = "cry";
                Toast.makeText(InputActivity.this,"You choose a crying mood", Toast.LENGTH_SHORT).show();
                break;
            case R.id.chill:
                mood = "sunglasses";
                Toast.makeText(InputActivity.this,"You choose a chill mood", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**Method that let the user add a journal entry to the database.*/
    public void addEntry(View view) {

        TextView input_Title = findViewById(R.id.input_Title);
        String input_title_Text = input_Title.getText().toString();

        TextView input_Content = findViewById(R.id.input_Content);
        String input_content_Text = input_Content.getText().toString();

        int mood_id = getResources().getIdentifier(mood , "drawable", getPackageName());

        JournalEntry entry = new JournalEntry(input_title_Text, input_content_Text,null,0,mood_id);
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        db.insert(entry);
        finish();
    }

}
