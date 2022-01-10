package com.example.characterapp;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PDsActivity extends AppCompatActivity {
    private EditText PDsAtaque, PDsDefensa, PDsArmadura, PDsZeon, PDsAct, PDsProyMagica, PDsNivelMagia, PDsCV,
            PDsProyPsiquica, PDsSigilo, PDsAdvertir, PDsConocimiento, PDsArte, PDsCapFisica, PDsValMagica, PDsVida;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pds2);
        setTitle("owo");

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
    }
}
