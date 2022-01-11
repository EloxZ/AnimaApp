package com.example.characterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
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
    DatabaseHelper db;
    private int selected = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("AnimaApp");
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        botonAddChar = (FloatingActionButton) findViewById(R.id.botonAddChar);
        charList = (ListView) findViewById(R.id.charList);
        cogerDatos();
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

        charList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                selected = pos;
                registerForContextMenu(charList);
                openContextMenu(charList);
                return true;
            }
        });
        //Toast.makeText(this, c.getString(i), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.add(Menu.NONE, 0, Menu.NONE, "Edit");
        menu.add(Menu.NONE, 1, Menu.NONE, "Delete");
    }

    @Override
    public boolean onContextItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case 0: {
                // Edit
            }
            break;
            case 1: {
                // Delete
                borrarPj();
            }
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        cogerDatos();
    }

    private boolean borrarPj(){
        boolean sol = false;
        if (selected!=-1) {
            sol = true;
            Personaje p = (Personaje) charList.getItemAtPosition(selected);

            try {
                boolean q = db.removePersonaje(p.getId());
                 if (q) {
                     Toast.makeText(this, "El personaje ha eliminado correctamente", Toast.LENGTH_LONG).show();
                     cogerDatos();
                 } else {
                     Toast.makeText(this, "Hubo un error al eliminar el personaje", Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                sol = false;
            }

        }
        return sol;
    }

    private void cogerDatos() {
        ArrayAdapter<Personaje> adapterList = new MyAdapter<Personaje>(this,android.R.layout.simple_list_item_1, db.getPersonajes());
        charList.setAdapter(adapterList);
    }
}