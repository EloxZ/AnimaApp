package com.example.characterapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class OverviewActivity extends AppCompatActivity {
    private TextView nombrePJ, clase, nivel, raza, pv, agilidad, destreza, constitucion, percepcion,
            fuerza, inteligencia, poder, voluntad, hataque, hdefensa, arma, armadura, zeon, act,
            proyMagica, nivMagia, cv, proyPsiquica, sigilo, advertir, arte, conocimiento, capFisica, valMagica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        setTitle("Ver personaje");
        Intent intent = getIntent();
        Gson gson = new Gson();
        Personaje p = (Personaje) gson.fromJson(intent.getStringExtra("personaje"), Personaje.class); p = new Personaje("Fortnite Guy");

        nombrePJ = (TextView) findViewById(R.id.NombrePJ);
        nombrePJ.setText(p.getNombre());

        clase = (TextView) findViewById(R.id.Clase);
        clase.setText(p.getClase().getNombre());

        nivel = (TextView) findViewById(R.id.Nivel);
        nivel.setText(p.getNivel().toString());

        raza = (TextView) findViewById(R.id.Raza);
        raza.setText(p.getRaza());

        pv = (TextView) findViewById(R.id.PV);
        pv.setText(p.calcularVida().toString());

        agilidad = (TextView) findViewById(R.id.Agilidad);
        agilidad.setText(p.getAgilidad().toString());

        destreza = (TextView) findViewById(R.id.Destreza);
        destreza.setText(p.getDestreza().toString());

        constitucion = (TextView) findViewById(R.id.Constitucion);
        constitucion.setText(p.getConstitucion().toString());

        percepcion = (TextView) findViewById(R.id.Percepcion);
        percepcion.setText(p.getPercepcion().toString());

        fuerza = (TextView) findViewById(R.id.Fuerza);
        fuerza.setText(p.getFuerza().toString());

        inteligencia = (TextView) findViewById(R.id.Inteligencia);
        inteligencia.setText(p.getInteligencia().toString());

        poder = (TextView) findViewById(R.id.Poder);
        poder.setText(p.getPoder().toString());

        voluntad = (TextView) findViewById(R.id.Voluntad);
        voluntad.setText(p.getVoluntad().toString());

        hataque = (TextView) findViewById(R.id.H_ataque);
        hataque.setText(p.calcularHabilidadAtaque().toString());

        hdefensa = (TextView) findViewById(R.id.H_defensa);
        hdefensa.setText(p.calcularHabilidadDefensa().toString());

        arma = (TextView) findViewById(R.id.Arma);
        arma.setText(p.getArma());

        clase = (TextView) findViewById(R.id.Clase);
        clase.setText(p.getClase().toString());

        armadura = (TextView) findViewById(R.id.Armadura);
        armadura.setText(p.calcularLlevarArmadura().toString());

        zeon = (TextView) findViewById(R.id.Zeon);
        zeon.setText(p.calcularZeon().toString());

        act = (TextView) findViewById(R.id.Act);
        act.setText(p.calcularAct().toString());

        proyMagica = (TextView) findViewById(R.id.ProyMagica);
        proyMagica.setText(p.calcularProyMagica().toString());

        nivMagia = (TextView) findViewById(R.id.NivMagia);
        nivMagia.setText(p.calcularNivelMagia().toString());

        cv = (TextView) findViewById(R.id.CV);
        cv.setText(p.calcularCVs().toString());

        proyPsiquica = (TextView) findViewById(R.id.ProyPsiquica);
        proyPsiquica.setText(p.calcularProyPsiquica().toString());

        sigilo = (TextView) findViewById(R.id.Sigilo);
        sigilo.setText(p.calcularSigilo().toString());

        advertir = (TextView) findViewById(R.id.Advertir);
        advertir.setText(p.calcularAdvertir().toString());

        arte = (TextView) findViewById(R.id.Arte);
        arte.setText(p.calcularArte().toString());

        conocimiento = (TextView) findViewById(R.id.Conocimiento);
        conocimiento.setText(p.calcularConocimiento().toString());

        capFisica = (TextView) findViewById(R.id.CapFisica);
        capFisica.setText(p.calcularCapFisica().toString());

        valMagica = (TextView) findViewById(R.id.valMagica);
        valMagica.setText(p.calcularValoracionMagica().toString());
    }
}
