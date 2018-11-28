package com.example.daan.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import java.sql.Timestamp;

public class EntryAdapter extends ResourceCursorAdapter {
    //Constructor
    public EntryAdapter(Context context, int layout, Cursor cursor){
        super(context, layout, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        int title_index = cursor.getColumnIndex("title");
        String title_txt = cursor.getString(title_index);
        TextView Entry_title = view.findViewById(R.id.Entry_title);
        Entry_title.setText(title_txt);

        int mood_index = cursor.getColumnIndex("mood");
        String mood_txt = cursor.getString(mood_index);
        TextView Entry_mood = view.findViewById(R.id.Entry_mood);
        Entry_mood.setText(mood_txt);

        int timestamp_index = cursor.getColumnIndex("timestamp");
        String timestamp_txt = cursor.getString(timestamp_index);
        TextView Entry_timestamp = view.findViewById(R.id.Entry_timestamp);
        Entry_timestamp.setText(timestamp_txt);
    }

}
