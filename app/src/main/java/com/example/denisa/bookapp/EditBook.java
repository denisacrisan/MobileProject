package com.example.denisa.bookapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditBook extends AppCompatActivity {

    EditText title_edit;
    EditText author_edit;
    EditText publisher_edit;
    Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);
        title_edit=(EditText) findViewById(R.id.title_edit);
        author_edit=(EditText) findViewById(R.id.author_edit);
        publisher_edit=(EditText) findViewById(R.id.publisher_edit);
        save_button = (Button) findViewById(R.id.edit_button);

        Intent startingIntent = getIntent();
        final int position = startingIntent.getIntExtra("position",0);
        title_edit.setText(startingIntent.getStringExtra("title"));
        author_edit.setText(startingIntent.getStringExtra("author"));
        publisher_edit.setText(startingIntent.getStringExtra("publisher"));

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("position",position);
                returnIntent.putExtra("title", title_edit.getText().toString());
                returnIntent.putExtra("author",author_edit.getText().toString());
                returnIntent.putExtra("publisher",publisher_edit.getText().toString());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}
