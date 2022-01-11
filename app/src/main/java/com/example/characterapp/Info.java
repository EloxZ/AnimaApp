package com.example.characterapp;

public class Info {

    public static int getArmorValue(int w) {
        int v = 0;

        switch(w) {
            case R.string.cuero:
                v = 1;
                break;
            case R.string.piezas:
                v = 4;
                break;
            case R.string.completaPesada:
                v = 7;
                break;
            case R.string.completa:
                v = 6;
                break;
            case R.string.semicompleta:
                v = 5;
                break;
            case R.string.placas:
                v = 5;
                break;
            case R.string.mallas:
                v = 3;
                break;
            case R.string.cueroTachonado:
                v = 3;
                break;
            case R.string.piel:
                v = 2;
                break;
            case R.string.acolchada:
                v = 1;
        }
        return v;
    }

    public static int getArmorReq(int w) {
        int v = 0;

        switch(w) {
            case R.string.cuero:
                v = 0;
                break;
            case R.string.piezas:
                v = 50;
                break;
            case R.string.completaPesada:
                v = 120;
                break;
            case R.string.completa:
                v = 100;
                break;
            case R.string.semicompleta:
                v = 70;
                break;
            case R.string.placas:
                v = 80;
                break;
            case R.string.mallas:
                v = 30;
                break;
            case R.string.cueroTachonado:
                v = 25;
                break;
            case R.string.piel:
                v = 10;
                break;
            case R.string.acolchada:
                v = 0;
        }
        return v;
    }


    public static int getWeaponDmg(int w) {
        int v = 0;

        switch(w) {
            case R.string.vara:
                v = 30;
                break;
            case R.string.lanza:
                v = 40;
                break;
            case R.string.martillo:
                v = 70;
                break;
            case R.string.daga:
                v = 30;
                break;
            case R.string.ballesta:
                v = 40;
                break;
            case R.string.arco:
                v = 40;
                break;
            case R.string.espada:
                v = 50;
        }
        return v;
    }

}
