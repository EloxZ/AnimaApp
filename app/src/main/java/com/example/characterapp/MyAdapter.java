package com.example.characterapp;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter<Personaje> extends ArrayAdapter<Personaje> {
    public MyAdapter(Context context, int resource, List<Personaje> items) {
        super(context, resource, items);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        Personaje p = (Personaje) getItem(position);
        String texto = p.toString();
        String[] tokens = texto.split("\n");
        int sizeTitle = tokens[0].length();

        SpannableString str = new SpannableString(texto);

        if (position % 2 == 1) {
            view.setBackgroundColor(Color.WHITE);
        } else {
            view.setBackgroundColor(Color.LTGRAY);
        }
        str.setSpan(new ForegroundColorSpan(0xFF0c1821), 0, sizeTitle, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(new ForegroundColorSpan(0xFF324a5f), sizeTitle+1, texto.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) view).setText(str);

        return view;
    }
}
