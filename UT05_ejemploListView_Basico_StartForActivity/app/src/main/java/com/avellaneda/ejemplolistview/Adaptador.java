package com.avellaneda.ejemplolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context miContexto;

    private ArrayList<ModeloPersona> miArrayList;


    public Adaptador(Context miContexto, ArrayList<ModeloPersona> miArrayList) {

        this.miContexto = miContexto;

        this.miArrayList = miArrayList;

    }

    @Override

    public int getCount() {
        return miArrayList.size();
    }

    @Override

    public Object getItem(int i) {
        return miArrayList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return miArrayList.get(i).getCodigo();
    }

    @Override

    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(miContexto);
        view = layoutInflater.inflate(R.layout.item, null);

        TextView nombre = (TextView) view.findViewById(R.id.tvNombre);
        TextView descripcion = (TextView) view.findViewById(R.id.tvDescripcion);
        ImageView foto = (ImageView) view.findViewById(R.id.imgFoto);
        nombre.setText(miArrayList.get(i).getNombre());
        descripcion.setText((miArrayList.get(i).getDescripcion()));
        foto.setImageResource(miArrayList.get(i).getFoto());
        return view;

    }

}