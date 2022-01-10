package com.example.characterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton botonAddChar;
    private ListView charList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("AnimaApp");
        setContentView(R.layout.activity_main);
        DatabaseHelper db = new DatabaseHelper(this);
        botonAddChar = (FloatingActionButton) findViewById(R.id.botonAddChar);
        charList = (ListView) findViewById(R.id.charList);
        ArrayAdapter<Personaje> adapterList = new MyAdapter<Personaje>(this,android.R.layout.simple_list_item_1, db.getPersonajes());
        charList.setAdapter(adapterList);
        botonAddChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addCharIntent = new Intent(MainActivity.this, CreatorActivity.class);
                startActivity(addCharIntent);
            }
        });
        charList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Personaje p = (Personaje) charList.getItemAtPosition(position);
                Intent editCharIntent = new Intent(MainActivity.this, EditorActivity.class);
                Gson gson = new Gson();
                String s = gson.toJson(p);
                editCharIntent.putExtra("personaje", s);
                startActivity(editCharIntent);
            }
        });
        //Toast.makeText(this, c.getString(i), Toast.LENGTH_LONG).show();
    }
}