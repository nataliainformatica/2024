package com.avellaneda.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import com.avellaneda.myapplication.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button boton;
    private String descripcionSigno;
    private DatePicker datePicker;
    private ImageView imagenSingo;
    private CalendarView calendarView;
    private int miSigno;
    private int miSignoImagen;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = findViewById((R.id.datePicker));
        imagenSingo = findViewById((R.id.imagenSigno));
        textView = findViewById(R.id.textView);
        // Configura un listener para el DatePicker
        /*  calendarView = findViewById(R.id.calendarView);

       // Configura un listener para el CalendarView
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
           @Override
           public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
               // La fecha seleccionada por el usuario
               String fechaSeleccionada = dayOfMonth + "/" + (month + 1) + "/" + year;
               Toast.makeText(getApplicationContext(), "Fecha seleccionada: " + fechaSeleccionada, Toast.LENGTH_SHORT).show();
           }
       });*/
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // La fecha seleccionada por el usuario
                        String fechaSeleccionada = dayOfMonth + "/" + (monthOfYear +1) + "/" + year;
                        miSigno = SignoZodiaco.signo((monthOfYear+1), dayOfMonth);
                        miSignoImagen = Imagenes.getImagen(miSigno);
                        imagenSingo.setImageResource(miSignoImagen);
                        // oculta el DatePicker
                        datePicker.setVisibility(View.GONE);
                        // view.GONE oculta el elemento datepicker, pero además deja el hueco vacio
                        descripcionSigno = SignoZodiaco.descripcionSigno(miSigno);
                        textView.setText(descripcionSigno);
                        Toast.makeText(getApplicationContext(), "Fecha seleccionada: " + fechaSeleccionada, Toast.LENGTH_SHORT).show();

                    }
                });

    }

}

