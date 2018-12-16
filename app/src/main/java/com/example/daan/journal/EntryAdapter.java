package com.example.daan.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {

    //Constructor
    public EntryAdapter(Context context, int layout, Cursor cursor){
        super(context, layout, cursor);
    }

    @Override
    /** Method that takes a View and fills the right elements with data from the cursor.*/
    public void bindView(View view, Context context, Cursor cursor) {

        // Get the title from the cursor and set the title TextView equal to it.
        int title_index = cursor.getColumnIndex("title");
        String title_txt = cursor.getString(title_index);
        TextView Entry_title = view.findViewById(R.id.Entry_title);
        Entry_title.setText(title_txt);

        // Get the mood from the cursor and set the mood ImageView equal to it.
        int mood_index = cursor.getColumnIndex("mood");
        int mood_id = cursor.getInt(mood_index);
        ImageView Entry_mood = view.findViewById(R.id.Entry_mood_image);
        Entry_mood.setImageResource(mood_id);

        // Get the timestamp from the cursor and set the timestamp TextView equal to it.
        int timestamp_index = cursor.getColumnIndex("timestamp");
        String timestamp_txt = cursor.getString(timestamp_index);
        TextView Entry_timestamp = view.findViewById(R.id.Entry_timestamp);
        Entry_timestamp.setText(timestamp_txt);

    }

}
