package com.avellaneda.ejemplolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class EntradaDatos extends AppCompatActivity {
    private static final int REQUEST_IMAGE_PICK = 1;

    private ImageView imageView;
    private Button btn;
    private ArrayList<Integer> imagenes;
    private int contador;
    private ArrayList<ModeloPersona> personas;
    private EditText edt1,edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_datos);
        personas = DaoPersonas.getPersonas();
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);

        imageView = findViewById(R.id.imageView);
        btn = findViewById(R.id.btn);
        imagenes = DaoImagenes.devolverListaImagenes();
        // configuramos evento sobre imageView
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                imageView.setImageResource(imagenes.get(contador));
            }
        });
        // configuramos boton con evento de agregar datos a la lista
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // creamos el objeto ModeloPersona, para añadirlo al dao mediante el método setPersona()
                ModeloPersona persona = new ModeloPersona();
                persona.setCodigo(personas.size() + 1);
                persona.setNombre(String.valueOf(edt1.getText()));
                persona.setDescripcion(String.valueOf(edt2.getText()));
                persona.setFoto(imagenes.get(contador));
                personas.add(persona);
                finish();
            }

            });
        }
    }