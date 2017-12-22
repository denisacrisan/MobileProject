package com.example.denisa.bookapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Denisa on 25.11.2017.
 */

public class BookListAdapter extends ArrayAdapter<BookItem> {


        public  BookListAdapter(Context context, List<BookItem> recordsList) {
            super(context, 0, recordsList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listItemView=convertView;
            if (listItemView==null){
                listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item_view,parent,false);
            }
            BookItem record=getItem(position);
            TextView song_view=(TextView) listItemView.findViewById(R.id.title);
            TextView band_view=(TextView) listItemView.findViewById(R.id.author);
            TextView genre_view=(TextView) listItemView.findViewById(R.id.publisher);
            song_view.setText(record.getTitle());
            band_view.setText(record.getAuthor());
            genre_view.setText(record.getPublisher());
            return listItemView;
        }

}
