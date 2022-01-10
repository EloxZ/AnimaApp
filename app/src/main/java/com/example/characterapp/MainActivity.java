package com.example.characterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton botonAddChar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("AnimaApp");
        setContentView(R.layout.activity_main);
        DatabaseHelper db = new DatabaseHelper(this);
        botonAddChar = (FloatingActionButton) findViewById(R.id.botonAddChar);
        botonAddChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addCharIntent = new Intent(MainActivity.this, CreatorActivity.class);
                startActivity(addCharIntent);
            }
        });

        //Esto lo puse para probar que funcionaba gucci
        //Cursor c = db.getListContents();
        //c.moveToFirst();
        //int i = c.getColumnIndex("Nombre");

        //Toast.makeText(this, c.getString(i), Toast.LENGTH_LONG).show();
    }
}