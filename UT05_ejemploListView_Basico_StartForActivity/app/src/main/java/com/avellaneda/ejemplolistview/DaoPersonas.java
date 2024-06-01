package com.avellaneda.ejemplolistview;

import android.view.Display;

import java.util.ArrayList;

public class DaoPersonas {
    private static ArrayList<ModeloPersona> personas;

    public static ArrayList<ModeloPersona> getPersonas() {
        if(personas == null){
            personas = new ArrayList<ModeloPersona>();

            ModeloPersona m1 = new ModeloPersona();

            m1.setNombre("Pepe");

            m1.setDescripcion("Tranquilo y con ganas de vivir");

            m1.setCodigo(1);

            m1.setFoto(R.drawable.foto1);


            ModeloPersona m2 = new ModeloPersona();

            m2.setNombre("Rosa");

            m2.setDescripcion("Ambiciosa y sin complejos");

            m2.setCodigo(2);

            m2.setFoto(R.drawable.foto2);


            ModeloPersona m3 = new ModeloPersona();

            m3.setNombre("Chiky");

            m3.setDescripcion("Capaz de todo por amor");

            m3.setCodigo(3);

            m3.setFoto(R.drawable.foto3);


            ModeloPersona m4 = new ModeloPersona();

            m4.setNombre("Piluca");

            m4.setDescripcion("Herida pero dispuesta a perdonar");

            m4.setCodigo(4);

            m4.setFoto(R.drawable.foto4);


            personas.add(m1);

            personas.add(m2);

            personas.add(m3);

            personas.add(m4);

        }

        return personas;

    }

    public static void setPersona(ModeloPersona persona) {
        personas.add(persona);
    }
}
