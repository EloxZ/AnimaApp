package com.example.characterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        InputStream inputStream = context.getResources().openRawResource(R.raw.script);
        try {
            String queries = CharStreams.toString(new InputStreamReader(
                    inputStream, Charsets.UTF_8));

            for (String query : queries.split(";")) {
                Log.d("DB", query);
                db.execSQL(query);
            }
        } catch (IOException e) {
            Log.e("Error", e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Armaduras");
        db.execSQL("DROP TABLE IF EXISTS Armas");
        db.execSQL("DROP TABLE IF EXISTS Caracteristica");
        db.execSQL("DROP TABLE IF EXISTS Clases");
        db.execSQL("DROP TABLE IF EXISTS Personajes");
        onCreate(db);
    }

    public boolean addPersonaje(Personaje p) {
        //Faltan cosas xd
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nombre", p.getNombre());
        contentValues.put("Raza", p.getRaza());
        contentValues.put("Nivel", p.getRaza());
        contentValues.put("Clase", p.getClase().getNombre());
        contentValues.put("Agilidad", p.getAgilidad());
        contentValues.put("Constitucion", p.getConstitucion());
        contentValues.put("Destreza", p.getDestreza());
        contentValues.put("Inteligencia", p.getInteligencia());
        contentValues.put("Percepcion", p.getPercepcion());
        contentValues.put("Poder", p.getPoder());
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
        contentValues.put("PDSigilo", p.getPdSigilo());
        contentValues.put("PDAvertir", p.getPdAdvertir());
        contentValues.put("PDConocimiento", p.getPdConocimiento());
        contentValues.put("PDCapFisica", p.getPdCapFisica());
        contentValues.put("Arma",p.getArma());
        //contentValues.put("Armadura",p.getArmadura());


        long result = db.insert("Personajes", null, contentValues);

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
        String sql = "DELETE FROM Personajes " +
                "WHERE ID = " + id;
        try {
            db.execSQL(sql);
            sol = true;
        } catch (Exception e) {

        }

        return sol;
    }

    public List<Personaje> getPersonajes(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + "Personajes", null);
        ArrayList<Personaje> pjs = new ArrayList<>();
        try {
            while (cursor.moveToNext()) {
                Personaje pj = new Personaje(cursor.getString(cursor.getColumnIndexOrThrow("Nombre")));
                pj.setId(cursor.getInt(cursor.getColumnIndexOrThrow("ID")));
                pj.setRaza(cursor.getString(cursor.getColumnIndexOrThrow("Raza")));
                pj.setNivel(cursor.getInt(cursor.getColumnIndexOrThrow("Nivel")));
                pjs.add(pj);
            }
        } finally {
            cursor.close();
        }

        return pjs;
    }
}