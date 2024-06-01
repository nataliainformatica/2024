package com.avellaneda.ejemplolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView lv;

    private Adaptador adaptador;
    private ArrayList<ModeloPersona> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personas = DaoPersonas.getPersonas();
        adaptador = new Adaptador(this, personas);
        lv = (ListView) findViewById(R.id.lv);
        registerForContextMenu(lv);

        lv.setAdapter(adaptador);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    ModeloPersona persona = (ModeloPersona) adaptador.getItem(i);
                    Log.e("PERSONA", persona.getCodigo() + "-" + persona.getNombre());
                    Toast.makeText(getBaseContext(), "El código es: " + persona.getCodigo(), Toast.LENGTH_LONG).show();



                } catch (Exception e) {
                    e.printStackTrace();

                }

            }

        });


    }

    @Override

    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int i = info.position;
        if (item.getItemId() == R.id.item1) {
            ModeloPersona persona = (ModeloPersona) adaptador.getItem(i);
            Log.e("PERSONA", persona.getCodigo() + "-" + persona.getNombre());
            Toast.makeText(this, "BORRAMOS ESTA PERSONA DE LA LISTA : " + persona.getNombre(), Toast.LENGTH_SHORT).show();
            personas.remove(persona);
            adaptador.notifyDataSetChanged();

//
        } else if (item.getItemId() == R.id.item2) {
            // abrir EntradaDatos
            Intent intent = new Intent(this, EntradaDatos.class);
            startActivity(intent);
            adaptador.notifyDataSetChanged();

        } else {
            return super.onContextItemSelected(item);
        }
        return true;

    }

    @Override

    public void onCreateContextMenu(ContextMenu menu, View v,

                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu, menu);

    }

}
