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
        //Se carga el layout de la actividad principal
        setContentView(R.layout.activity_main);
        //Se accede a la base de datos para cargar todos los personajes de la BD en la app
        db = new DatabaseHelper(this);
        //Se declara un botón el cual, cuando es clickado, redirecciona al usuario a la actividad
        //de crear personaje
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
        //Este método abrirá la actividad que permite ver todos los datos de un usuario y le envía el personaje
        //a dicha actividad cuando el usuario toca un personaje
        charList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Personaje p = (Personaje) charList.getItemAtPosition(position);
                Intent verCharIntent = new Intent(MainActivity.this, OverviewActivity.class);
                Gson gson = new Gson();
                String s = gson.toJson(p);
                verCharIntent.putExtra("personaje", s);
                startActivity(verCharIntent);
            }
        });
    //Este método abre un mené contextual que le da al usuario la opción de editar o eliminar un personaje.
    //Cuando se seleccione una de las acciones, se llamará al método correspondiente. En el caso de editar
    //se abrirá una ventana similar a crear donde editar la información del personaje. Si se selecciona
    //eliminar, el personaje es eliminado y se muestra un mensaje de éxito.

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
    //Aquí se asigna el funcionamiento a cada elemento del menú contextual

    @Override
    public boolean onContextItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case 0: {
                // Edit
                editarPj();
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

    private void editarPj() {
        if (selected!=-1) {
            Personaje p = (Personaje) charList.getItemAtPosition(selected);
            Intent editarCharIntent = new Intent(MainActivity.this, EditorActivity.class);
            Gson gson = new Gson();
            String s = gson.toJson(p);
            editarCharIntent.putExtra("personaje", s);
            startActivity(editarCharIntent);
        }
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