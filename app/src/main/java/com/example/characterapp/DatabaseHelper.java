package com.example.characterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.characterapp.clases.Guerrero;
import com.example.characterapp.clases.Hechicero;
import com.example.characterapp.clases.Ladron;
import com.example.characterapp.clases.Mentalista;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "anima.db";
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 8);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE Personaje (ID INTEGER PRIMARY KEY AUTOINCREMENT, Nombre VARCHAR, Raza VARCHAR, Nivel INTEGER, Clase VARCHAR, Agilidad INTEGER, Fuerza INTEGER, Constitucion INTEGER, Destreza INTEGER, Inteligencia INTEGER, Percepcion INTEGER, Poder INTEGER, Voluntad INTEGER, PD INTEGER, PDVida INTEGER, PDHA INTEGER, PDHD INTEGER, PDLlevarArmadura INTEGER, PDZeon INTEGER, PDACT INTEGER, PDProyMagica INTEGER, PDNivelMagia INTEGER, PDCV INTEGER, PDproyPsiquica INTEGER, PDSigilo INTEGER, PDAvertir INTEGER, PDConocimiento INTEGER, PDArte INTEGER, PDCapFisica INTEGER, Arma INTEGER, Armadura INTEGER,  PDValMagica INTEGER)");

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Personaje");
        onCreate(db);
    }

    public boolean addPersonaje(Personaje p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nombre", p.getNombre());
        contentValues.put("Raza", p.getRaza());
        contentValues.put("Nivel", p.getNivel());
        contentValues.put("Clase", p.getClase().getNombre());
        contentValues.put("Agilidad", p.getAgilidad());
        contentValues.put("Constitucion", p.getConstitucion());
        contentValues.put("Destreza", p.getDestreza());
        contentValues.put("Inteligencia", p.getInteligencia());
        contentValues.put("Fuerza", p.getFuerza());
        contentValues.put("Percepcion", p.getPercepcion());
        contentValues.put("Poder", p.getPoder());
        contentValues.put("PDHD", p.getPdHd());
        contentValues.put("Voluntad", p.getVoluntad());
        contentValues.put("PD", p.getPd());
        contentValues.put("PDVida", p.getPdVida());
        contentValues.put("PDHA", p.getPdHa());
        contentValues.put("PDLlevarArmadura", p.getPdLlevarArmadura());
        contentValues.put("PDZeon", p.getPdZeon());
        contentValues.put("PDACT", p.getPdAct());
        contentValues.put("PDProyMagica", p.getPdProyMagica());
        contentValues.put("PDNivelMagia", p.getPdNivelMagia());
        contentValues.put("PDproyPsiquica", p.getPdProyPsiquica());
        contentValues.put("PDArte", p.getPdArte());
        contentValues.put("PDCV", p.getPdCv());
        contentValues.put("PDSigilo", p.getPdSigilo());
        contentValues.put("PDValMagica", p.getPdValoracionMagica());
        contentValues.put("PDAvertir", p.getPdAdvertir());
        contentValues.put("PDConocimiento", p.getPdConocimiento());
        contentValues.put("PDCapFisica", p.getPdCapFisica());
        contentValues.put("Arma",p.getArma());
        contentValues.put("Armadura",p.getArmadura());

        long result = db.insert("Personaje", null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean removePersonaje(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        boolean sol = false;
        String sql = "DELETE FROM Personaje" +
                " WHERE ID = " + id;
        try {
            db.execSQL(sql);
            sol = true;
        } catch (Exception e) {
            Log.e("Error",e.getMessage());
        }

        return sol;
    }

    public boolean editarPersonaje(Personaje p) {
        removePersonaje(p.getId());
        return addPersonaje(p);
    }

    public List<Personaje> getPersonajes(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + "Personaje", null);
        ArrayList<Personaje> pjs = new ArrayList<>();
        try {
            while (cursor.moveToNext()) {
                Personaje pj = new Personaje(cursor.getString(cursor.getColumnIndexOrThrow("Nombre")));
                pj.setId(cursor.getInt(cursor.getColumnIndexOrThrow("ID")));
                pj.setRaza(cursor.getString(cursor.getColumnIndexOrThrow("Raza")));
                pj.setNivel(cursor.getInt(cursor.getColumnIndexOrThrow("Nivel")));
                String clase = cursor.getString(cursor.getColumnIndexOrThrow("Clase"));
                Clase c = new Guerrero();
                switch (clase) {
                    case "Guerrero":
                        c = new Guerrero();
                        break;
                    case "Hechicero":
                        c = new Hechicero();
                        break;
                    case "Mentalista":
                        c = new Mentalista();
                        break;
                    case "Ladron":
                        c = new Ladron();
                }
                pj.setClase(c);
                pj.setAgilidad(cursor.getInt(cursor.getColumnIndexOrThrow("Agilidad")));
                pj.setFuerza(cursor.getInt(cursor.getColumnIndexOrThrow("Fuerza")));
                pj.setConstitucion(cursor.getInt(cursor.getColumnIndexOrThrow("Constitucion")));
                pj.setDestreza(cursor.getInt(cursor.getColumnIndexOrThrow("Destreza")));
                pj.setPdHd(cursor.getInt(cursor.getColumnIndexOrThrow("PDHD")));
                pj.setPdValoracionMagica(cursor.getInt(cursor.getColumnIndexOrThrow("PDValMagica")));
                pj.setInteligencia(cursor.getInt(cursor.getColumnIndexOrThrow("Inteligencia")));
                pj.setPercepcion(cursor.getInt(cursor.getColumnIndexOrThrow("Percepcion")));
                pj.setPoder(cursor.getInt(cursor.getColumnIndexOrThrow("Poder")));
                pj.setVoluntad(cursor.getInt(cursor.getColumnIndexOrThrow("Voluntad")));
                pj.setPd(cursor.getInt(cursor.getColumnIndexOrThrow("PD")));
                pj.setPdVida(cursor.getInt(cursor.getColumnIndexOrThrow("PDVida")));
                pj.setPdHa(cursor.getInt(cursor.getColumnIndexOrThrow("PDHA")));
                pj.setPdLlevarArmadura(cursor.getInt(cursor.getColumnIndexOrThrow("PDLlevarArmadura")));
                pj.setPdZeon(cursor.getInt(cursor.getColumnIndexOrThrow("PDZeon")));
                pj.setPdAct(cursor.getInt(cursor.getColumnIndexOrThrow("PDACT")));
                pj.setPdArte(cursor.getInt(cursor.getColumnIndexOrThrow("PDArte")));
                pj.setPdCv(cursor.getInt(cursor.getColumnIndexOrThrow("PDCV")));
                pj.setPdProyMagica(cursor.getInt(cursor.getColumnIndexOrThrow("PDProyMagica")));
                pj.setPdNivelMagia(cursor.getInt(cursor.getColumnIndexOrThrow("PDNivelMagia")));
                pj.setPdProyPsiquica(cursor.getInt(cursor.getColumnIndexOrThrow("PDproyPsiquica")));
                pj.setPdSigilo(cursor.getInt(cursor.getColumnIndexOrThrow("PDSigilo")));
                pj.setPdAdvertir(cursor.getInt(cursor.getColumnIndexOrThrow("PDAvertir")));
                pj.setPdConocimiento(cursor.getInt(cursor.getColumnIndexOrThrow("PDConocimiento")));
                pj.setPdCapFisica(cursor.getInt(cursor.getColumnIndexOrThrow("PDCapFisica")));
                pj.setArma(cursor.getInt(cursor.getColumnIndexOrThrow("Arma")));
                pj.setArmadura(cursor.getInt(cursor.getColumnIndexOrThrow("Armadura")));

                pjs.add(pj);
            }
        } finally {
            cursor.close();
        }

        return pjs;
    }
}