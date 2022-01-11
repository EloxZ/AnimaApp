package com.example.characterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.util.Collections;
import java.util.Map;

public class EditorActivity extends AppCompatActivity {
    private Spinner classSpinner;
    private Spinner razaSpinner;
    private EditText agilidadNumber, percepNumber, volNumber, poderNumber, intNumber, constNumber, fuerzaNumber, destrezaNumber, nameField;
    private EditText PDsAtaque, PDsDefensa, PDsArmadura, PDsZeon, PDsAct, PDsProyMagica, PDsNivelMagia, PDsCV,
            PDsProyPsiquica, PDsSigilo, PDsAdvertir, PDsConocimiento, PDsArte, PDsCapFisica, PDsValMagica, PDsVida;
    private Button buttonPd, btnAccept;
    private boolean back;
    private ScrollView viewAtr;
    private ConstraintLayout viewPds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator);
        setTitle("Editor de personaje");
        back = false;
        Intent intent = getIntent();
        Gson gson = new Gson();
        Personaje p = (Personaje) gson.fromJson(intent.getStringExtra("personaje"), Personaje.class);
        viewAtr = (ScrollView) findViewById(R.id.viewAtr);
        viewPds = (ConstraintLayout) findViewById(R.id.viewPds);
        classSpinner = (Spinner) findViewById(R.id.classSpinner);
        razaSpinner = (Spinner) findViewById(R.id.razaSpinner);
        buttonPd = (Button) findViewById(R.id.buttonPd);
        btnAccept = (Button) findViewById(R.id.btnAccept);
        btnAccept.setText("Guardar");
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.clases, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.razas, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        classSpinner.setAdapter(adapter);
        razaSpinner.setAdapter(adapter2);
        nameField = (EditText) findViewById(R.id.nameField);
        nameField.setText(p.getNombre());
        PDsAtaque = (EditText) findViewById(R.id.PDsAtaque);
        PDsAtaque.setTransformationMethod(null);

        PDsDefensa = (EditText) findViewById(R.id.PDsDefensa);
        PDsDefensa.setTransformationMethod(null);

        PDsArmadura = (EditText) findViewById(R.id.PDsArmadura);
        PDsArmadura.setTransformationMethod(null);

        PDsZeon = (EditText) findViewById(R.id.PDsZeon);
        PDsZeon.setTransformationMethod(null);

        PDsAct = (EditText) findViewById(R.id.PDsAct);
        PDsAct.setTransformationMethod(null);

        PDsProyMagica = (EditText) findViewById(R.id.PDsProyMagica);
        PDsProyMagica.setTransformationMethod(null);

        PDsNivelMagia = (EditText) findViewById(R.id.PDsNivelMagia);
        PDsNivelMagia.setTransformationMethod(null);

        PDsCV = (EditText) findViewById(R.id.PDsCV);
        PDsCV.setTransformationMethod(null);

        PDsProyPsiquica = (EditText) findViewById(R.id.PDsProyPsiquica);
        PDsProyPsiquica.setTransformationMethod(null);

        PDsSigilo = (EditText) findViewById(R.id.PDsSigilo);
        PDsSigilo.setTransformationMethod(null);

        PDsAdvertir = (EditText) findViewById(R.id.PDsAdvertir);
        PDsAdvertir.setTransformationMethod(null);

        PDsConocimiento = (EditText) findViewById(R.id.PDsConocimiento);
        PDsConocimiento.setTransformationMethod(null);

        PDsArte = (EditText) findViewById(R.id.PDsArte);
        PDsArte.setTransformationMethod(null);

        PDsCapFisica = (EditText) findViewById(R.id.PDsCapFisica);
        PDsCapFisica.setTransformationMethod(null);

        PDsValMagica = (EditText) findViewById(R.id.PDsValoracionMagica);
        PDsValMagica.setTransformationMethod(null);

        PDsVida = (EditText) findViewById(R.id.PDsVida);
        PDsVida.setTransformationMethod(null);

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

        buttonPd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                back = true;
                viewAtr.setVisibility(View.GONE);
                viewPds.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(back){
            back = false;
            viewPds.setVisibility(View.GONE);
            viewAtr.setVisibility(View.VISIBLE);
        } else {
            finish();
        }
    }

}