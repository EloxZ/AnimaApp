package com.example.characterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton botonAddChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("AnimaApp");
        setContentView(R.layout.activity_main);
        botonAddChar = (FloatingActionButton) findViewById(R.id.botonAddChar);
        botonAddChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addCharIntent = new Intent(MainActivity.this, CreatorActivity.class);
                startActivity(addCharIntent);
            }
        });
    }
}