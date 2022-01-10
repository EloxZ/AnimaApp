package com.example.characterapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class CreatorActivity extends AppCompatActivity {
    private Spinner classSpinner;
    private Spinner razaSpinner;
    private EditText agilidadNumber, percepNumber, volNumber, poderNumber, intNumber, constNumber, fuerzaNumber, destrezaNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator);
        setTitle("Creador de personaje");

        classSpinner = (Spinner) findViewById(R.id.classSpinner);
        razaSpinner = (Spinner) findViewById(R.id.razaSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.clases, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.razas, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        classSpinner.setAdapter(adapter);
        razaSpinner.setAdapter(adapter2);
        Personaje personaje = new Personaje("Sbeve");



        agilidadNumber = (EditText) findViewById(R.id.agilidadNumber);
        agilidadNumber.setTransformationMethod(null);
        agilidadNumber.setText(personaje.getAgilidad().toString());
        agilidadNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (agilidadNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(agilidadNumber.getText().toString());
                }
                personaje.setAgilidad(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        percepNumber = (EditText) findViewById(R.id.percepNumber);
        percepNumber.setTransformationMethod(null);
        percepNumber.setText(personaje.getPercepcion().toString());
        percepNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (percepNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(percepNumber.getText().toString());
                }
                personaje.setPercepcion(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        volNumber = (EditText) findViewById(R.id.volNumber);
        volNumber.setTransformationMethod(null);
        volNumber.setText(personaje.getVoluntad().toString());
        volNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (volNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(volNumber.getText().toString());
                }
                personaje.setVoluntad(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        poderNumber = (EditText) findViewById(R.id.poderNumber);
        poderNumber.setTransformationMethod(null);
        poderNumber.setText(personaje.getPoder().toString());
        poderNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (poderNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(poderNumber.getText().toString());
                }
                personaje.setPoder(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        intNumber = (EditText) findViewById(R.id.intNumber);
        intNumber.setTransformationMethod(null);
        intNumber.setText(personaje.getInteligencia().toString());
        intNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (agilidadNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(agilidadNumber.getText().toString());
                }
                personaje.setInteligencia(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        constNumber = (EditText) findViewById(R.id.constNumber);
        constNumber.setTransformationMethod(null);
        constNumber.setText(personaje.getConstitucion().toString());
        constNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (constNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(constNumber.getText().toString());
                }
                personaje.setConstitucion(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        fuerzaNumber = (EditText) findViewById(R.id.fuerzaNumber);
        fuerzaNumber.setTransformationMethod(null);
        fuerzaNumber.setText(personaje.getFuerza().toString());
        fuerzaNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (fuerzaNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(fuerzaNumber.getText().toString());
                }
                personaje.setFuerza(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        destrezaNumber = (EditText) findViewById(R.id.destrezaNumber);
        destrezaNumber.setTransformationMethod(null);
        destrezaNumber.setText(personaje.getDestreza().toString());
        destrezaNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (destrezaNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(destrezaNumber.getText().toString());
                }
                personaje.setDestreza(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
