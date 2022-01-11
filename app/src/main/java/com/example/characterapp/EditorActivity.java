package com.example.characterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Collections;
import java.util.Map;

public class EditorActivity extends AppCompatActivity {
    private Spinner classSpinner;
    private Spinner razaSpinner;
    private EditText agilidadNumber, percepNumber, volNumber, poderNumber, intNumber, constNumber, fuerzaNumber, destrezaNumber, nameField;
    private EditText PDsAtaque, PDsDefensa, PDsArmadura, PDsZeon, PDsAct, PDsProyMagica, PDsNivelMagia, PDsCV,
            PDsProyPsiquica, PDsSigilo, PDsAdvertir, PDsConocimiento, PDsArte, PDsCapFisica, PDsValMagica, PDsVida;
    private TextView pdsDisponibles, costeAtaque, costeDefensa, costeArmadura, costeZeon, costeAct, costeProyMagica, costeNivelMagia, costeCV, costeProyPsiquica, costeSigilo, costeAdvertir, costeConocimiento, costeArte, costeCapFisica, costeValoracionMagica;
    
    private TextView baseAtaque, baseDefensa, baseArmadura, baseZeon, baseAct, baseProyMagica, baseNivelMagia, baseCV, baseProyPsiquica, baseSigilo, baseAdvertir, baseConocimiento, baseArte, baseCapFisica, baseValoracionMagica;

    private TextView bonoAtaque, bonoDefensa, bonoArmadura, bonoZeon, bonoAct, bonoProyMagica, bonoNivelMagia, bonoCV, bonoProyPsiquica, bonoSigilo, bonoAdvertir, bonoConocimiento, bonoArte, bonoCapFisica, bonoValoracionMagica;

    private TextView totalAtaque, totalDefensa, totalArmadura, totalZeon, totalAct, totalProyMagica, totalNivelMagia, totalCV, totalProyPsiquica, totalSigilo, totalAdvertir, totalConocimiento, totalArte, totalCapFisica, totalValoracionMagica;
    
    private Button buttonPd;
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
        PDsAtaque.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsAtaque.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsAtaque.getText().toString());
                }
                p.setPdHa(val);
                baseAtaque.setText(p.calcularValorPdsHabilidad(p.getPdHa(),p.getClase().getCosteHa()).toString());
                bonoAtaque.setText(p.calcularBonoHabilidad(p.getDestreza(),p.getClase().getHaNivel()));
                totalAtaque.setText(p.calcularHabilidadAtaque());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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
        agilidadNumber.setText(p.getAgilidad().toString());
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
                p.setAgilidad(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        percepNumber = (EditText) findViewById(R.id.percepNumber);
        percepNumber.setTransformationMethod(null);
        percepNumber.setText(p.getPercepcion().toString());
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
                p.setPercepcion(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        volNumber = (EditText) findViewById(R.id.volNumber);
        volNumber.setTransformationMethod(null);
        volNumber.setText(p.getVoluntad().toString());
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
                p.setVoluntad(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        poderNumber = (EditText) findViewById(R.id.poderNumber);
        poderNumber.setTransformationMethod(null);
        poderNumber.setText(p.getPoder().toString());
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
                p.setPoder(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        intNumber = (EditText) findViewById(R.id.intNumber);
        intNumber.setTransformationMethod(null);
        intNumber.setText(p.getInteligencia().toString());
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
                p.setInteligencia(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        constNumber = (EditText) findViewById(R.id.constNumber);
        constNumber.setTransformationMethod(null);
        constNumber.setText(p.getConstitucion().toString());
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
                p.setConstitucion(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        fuerzaNumber = (EditText) findViewById(R.id.fuerzaNumber);
        fuerzaNumber.setTransformationMethod(null);
        fuerzaNumber.setText(p.getFuerza().toString());
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
                p.setFuerza(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        destrezaNumber = (EditText) findViewById(R.id.destrezaNumber);
        destrezaNumber.setTransformationMethod(null);
        destrezaNumber.setText(p.getDestreza().toString());
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
                p.setDestreza(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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