package com.avellaneda.apprepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button boton;
    private EditText etnombre, etapellido, etedad, ettelefono, etpassword;
    private ArrayList<Contacto> contactos;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        contactos = DAO_contactos.getContactos();
        boton = findViewById(R.id.registro);
        etnombre = findViewById(R.id.etnombre);
        etapellido = findViewById(R.id.etapellido);
        etedad = findViewById(R.id.etedad);
        ettelefono = findViewById(R.id.ettelefono);
        etpassword = findViewById(R.id.etpassword);


        boton.setOnClickListener(v -> {
           /* Intent intent = new Intent(this, Registro.class);
            startActivity(intent);  */
//
// crea Contacto con todos los campos de la pantalla
            Contacto miContacto = new Contacto();
            try{
            miContacto.setNombre(etnombre.getText().toString());
            miContacto.setEdad(Integer.parseInt(etedad.getText().toString()));
            miContacto.setApellido(etapellido.getText().toString());
            miContacto.setPassword(etpassword.getText().toString());
            miContacto.setTelefono(Integer.parseInt(ettelefono.getText().toString()));
            contactos.add(miContacto);
            Toast.makeText(context,  miContacto.toString(), Toast.LENGTH_SHORT).show();}
            catch (Exception e){
                Toast.makeText(context, "ERROR EN  ALGÚN DATO", Toast.LENGTH_SHORT).show();
            }
        });
    }
}