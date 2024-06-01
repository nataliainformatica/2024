package com.avellaneda.ejemplolistview;

import java.util.ArrayList;

public class DaoImagenes {
    public static ArrayList<Integer> devolverListaImagenes(){
        ArrayList<Integer> listaImagenes = new ArrayList();
        listaImagenes.add(R.drawable.foto1);
        listaImagenes.add(R.drawable.foto2);
        listaImagenes.add(R.drawable.foto3);
        return listaImagenes;
    }
}
