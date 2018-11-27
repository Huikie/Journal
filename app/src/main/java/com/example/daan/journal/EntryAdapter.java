package com.example.daan.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {
    //Constructor
    public EntryAdapter(Context context, int layout, Cursor cursor){
        super(context, layout, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        int Title_index = cursor.getColumnIndex("title");
        String title_txt = cursor.getString(Title_index);
        TextView Entry_title = view.findViewById(R.id.Entry_title);
        Entry_title.setText(title_txt);

        int id_index = cursor.getColumnIndex("_id");
        String id_txt = cursor.getString(id_index);
        TextView Entry_id = view.findViewById(R.id.Entry_timestamp);
        Entry_id.setText(id_txt);


//        int Timestamp_index = cursor.getColumnIndex("timestamp");
//        String timestamp_txt = cursor.getString(Timestamp_index);
//        TextView Entry_timestamp = view.findViewById(R.id.Entry_mood);
//        Entry_timestamp.setText(timestamp_txt);
        //view.findViewById(R.id.Entry_timestamp);
        //view.findViewById(R.id.Entry_mood);
    }

}
