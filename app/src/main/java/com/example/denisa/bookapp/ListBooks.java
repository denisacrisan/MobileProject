package com.example.denisa.bookapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListBooks extends AppCompatActivity {

    private static final int EDIT_ACTIVITY_RESPONSE_CODE = 2;

    private List<BookItem> books;
    ListView mylist;
    BookListAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);
        books = new ArrayList<BookItem>() {{
            add(new BookItem("Title1", "Author1", "Publisher1"));
            add(new BookItem("Title2", "Author2", "Publisher2"));
            add(new BookItem("Title3", "Author3", "Publisher3"));
            add(new BookItem("Title4", "Author4", "Publisher4"));
            add(new BookItem("Title5", "Author5", "Publisher5"));
            add(new BookItem("Title6", "Author6", "Publisher6"));
        }};
        mylist = (ListView) findViewById(R.id.list);
        myadapter = new BookListAdapter(ListBooks.this, books);
        mylist.setAdapter(myadapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myintent = new Intent(ListBooks.this, EditBook.class);
                BookItem selectedItem = (BookItem) mylist.getItemAtPosition(position);
                myintent.putExtra("position", position);
                myintent.putExtra("title", selectedItem.getTitle());
                myintent.putExtra("author", selectedItem.getAuthor());
                myintent.putExtra("publisher", selectedItem.getPublisher());
                startActivityForResult(myintent, EDIT_ACTIVITY_RESPONSE_CODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == EDIT_ACTIVITY_RESPONSE_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                BookItem item = (BookItem) mylist.getItemAtPosition(data.getIntExtra("position", 0));
                item.setTtile(data.getStringExtra("title"));
                item.setAuthor(data.getStringExtra("author"));
                item.setPublisher(data.getStringExtra("publisher"));
                myadapter.notifyDataSetChanged();
            }
        }
    }
}