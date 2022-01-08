package com.example.characterapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

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

        agilidadNumber = (EditText) findViewById(R.id.agilidadNumber);
        agilidadNumber.setTransformationMethod(null);

        percepNumber = (EditText) findViewById(R.id.percepNumber);
        percepNumber.setTransformationMethod(null);

        volNumber = (EditText) findViewById(R.id.volNumber);
        volNumber.setTransformationMethod(null);

        poderNumber = (EditText) findViewById(R.id.poderNumber);
        poderNumber.setTransformationMethod(null);

        intNumber = (EditText) findViewById(R.id.intNumber);
        intNumber.setTransformationMethod(null);

        constNumber = (EditText) findViewById(R.id.constNumber);
        constNumber.setTransformationMethod(null);

        fuerzaNumber = (EditText) findViewById(R.id.fuerzaNumber);
        fuerzaNumber.setTransformationMethod(null);

        destrezaNumber = (EditText) findViewById(R.id.destrezaNumber);
        destrezaNumber.setTransformationMethod(null);
    }
}
