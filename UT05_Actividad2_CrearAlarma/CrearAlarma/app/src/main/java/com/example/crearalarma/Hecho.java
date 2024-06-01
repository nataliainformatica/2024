package com.example.crearalarma;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Hecho extends AppCompatActivity {
    Button btnFinalizar;
    TextView txtDescripcion;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalizado);
        txtDescripcion= findViewById(R.id.txtDescripcion);
        Bundle bundle = getIntent().getExtras();
        txtDescripcion.setText(bundle.getString("miDescripcion"));

        btnFinalizar= findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
