package com.example.crearalarma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    //private CheckBox chkL, chkM, chkX, chkJ, chkV, chkS, chkD;
    private RadioButton chkFinSemana;
    private Button btnGuardar;
    private Context context;
    private EditText editTextTexto;
    private RadioGroup radioGroup;
    private TimePicker timePicker;
    private int hourOfDay1, minute1;
    private String amPm;

    private String horaSeleccionada;
    private CheckBox[] checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        // gridLayout tendra un menu flotante
        /***
         *
         */
        registerForContextMenu(findViewById(R.id.gridLayout));

        checkBoxes = arrayDeElementos();
        timePicker = findViewById(R.id.timePicker);
        editTextTexto = findViewById(R.id.nombreAlarma);
        btnGuardar = findViewById(R.id.btnGuardar);
        radioGroup = findViewById(R.id.rbGroup);
        // Configura un listener para el TimePicker
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            /* manejador para capturar los cambios del TimePicker */
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // Este método se llama cuando cambia la hora en el TimePicker

                // Actualiza el TextView con la hora seleccionada
                Toast.makeText(context, "Hora seleccionada: " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                horaSeleccionada = "Alarma: " + String.valueOf(editTextTexto.getText()) + "Hora seleccionada: " + hourOfDay + ":" + minute;

                hourOfDay1 = hourOfDay;
                minute1 = minute;
            }
        });
        /* versión primera de la actividad
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hecho = new Intent(context, Hecho.class);
                try {
                    //hecho.putExtra("miDescripcion", String.valueOf(editTextTexto.getText()));
                    hecho.putExtra("miHora", horaSeleccionada);
                } catch (NullPointerException es) {
                    // mostrar mensaje de campo vacío
                    Toast.makeText(context, "Debes introducir un valor en el nombre de la alarma", Toast.LENGTH_SHORT).show();

                }
                startActivity(hecho);
            }
        });
*/
        /* segunda versión crea la alarma*/
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAlarm(String.valueOf(editTextTexto.getText()), hourOfDay1, minute1);
            }
        });
/*
        chkS = findViewById(R.id.chkS);
        chkD = findViewById(R.id.chkD);
        chkL = findViewById(R.id.chkL);
        chkM = findViewById(R.id.chkM);
        chkX = findViewById(R.id.chkX);
        chkJ = findViewById(R.id.chkJ);
        chkV = findViewById(R.id.chkV);
        chkD = findViewById(R.id.chkD);*/
        chkFinSemana = findViewById(R.id.rbFinSemana);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Detecta cuál RadioButton ha sido seleccionado
                if (checkedId == R.id.rbTodos) {
                    // Opción 1 seleccionada
                    // Realiza acciones correspondientes
                    // por ejemplo  ocultar el resto de los dias
                    /**
                     *El método setVisibility toma como argumento una de las siguientes constantes de la clase View:
                     *
                     * View.VISIBLE: El componente es visible.
                     * View.INVISIBLE: El componente es invisible pero mantiene su espacio en el diseño.
                     * View.GONE: El componente es invisible y se elimina de la disposición (no ocupa espacio).
                     */

                    // recorre el array de checkboxes y pone los elementos  de 0 a 5 a View.INVISIBLE

                    for (int i = 0; i < 5; i++) {
                        checkBoxes[i].setVisibility(View.INVISIBLE);
                    }
                    /*
                    chkL.setVisibility(View.INVISIBLE);
                    chkM.setVisibility(View.INVISIBLE);
                    chkX.setVisibility(View.INVISIBLE);
                    chkJ.setVisibility(View.INVISIBLE);
                    chkV.setVisibility(View.INVISIBLE);*/
                    borrarCheks();


                } else if (checkedId == R.id.rbFinSemana) {
                    // Opción 2 seleccionada
                    // Realiza acciones correspondientes
                    // muestra todos los días

                    for (int i = 0; i < 5; i++) {
                        checkBoxes[i].setVisibility(View.VISIBLE);
                    }/*
                    chkL.setVisibility(View.VISIBLE);
                    chkM.setVisibility(View.VISIBLE);
                    chkX.setVisibility(View.VISIBLE);
                    chkJ.setVisibility(View.VISIBLE);
                    chkV.setVisibility(View.VISIBLE);*/
                    borrarCheks();

                }
                // Agrega más condiciones para otros RadioButton si es necesario
            }
        });

/* listener para el click del menú emergente*/
        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea un objeto PopupMenu asociado con el botón
                PopupMenu popupMenu = new PopupMenu(com.example.crearalarma.MainActivity.this, timePicker);
                popupMenu.getMenuInflater().inflate(R.menu.menu_actions, popupMenu.getMenu());

                // Configura un listener para manejar las selecciones del menú
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        // sustituir switch por if
                        if (item.getItemId() == R.id.hora) {
                        Toast .makeText(context, "HORA: "+ hourOfDay1, Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (item.getItemId() == R.id.minutos) {
                            // Realiza una acción cuando se selecciona la opción 2
                            Toast .makeText(context, "MINUTOS: "+ minute1, Toast.LENGTH_SHORT).show();
                            return true;
                        } else {
                            return false;
                        }

                    }
                });

                // Muestra el menú emergente
                popupMenu.show();
            }
        });
    }
    /*CONTEXT MENU*/

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
     
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getItemId() == R.id.itemInfo) {
            // accion 1

            return true;
        } else if (item.getItemId() == R.id.itemInfo)
            // acción2
            return true;
        else
            return super.onContextItemSelected(item);
    }
    /*MENU BARRA*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_barra, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == R.id.itemInfo) {
            // accion 1

            return true;
        } else if (item.getItemId() == R.id.itemInfo)
            // acción2
            return true;
        else if (item.getItemId() == R.id.salir) {
            finishAffinity();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    private void borrarCheks() {
        // recorre el array de checkboxes y pone los elementos a false
        for (CheckBox checkBox : checkBoxes) {
            checkBox.setChecked(false);
        }


    }

    public void createAlarm(String message, int hour, int minutes) {
        // recorrer checkboxs para que si está checked incluya el indice del array en un ArrayList<Integer>
        ArrayList<Integer> days = new ArrayList<>();
        int dias[] = {2,3,4,5,6,7,1};
        for (int i = 0; i < checkBoxes.length; i++) {

            if (checkBoxes[i].isChecked()) {
                days.add(dias[i]);
            }
        }
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                .putExtra(AlarmClock.EXTRA_DAYS, days); // Días de la semana
        // sunday  = 1, monday = 2 , ....
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(context, "No se pudo crear el alarma", Toast.LENGTH_SHORT).show();
        }
    }

    private CheckBox[] arrayDeElementos() {
        View childView;
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        // Obtén el número de columnas del GridLayout
        int numColumnas = gridLayout.getColumnCount();
        int contador = 0;
        checkBoxes = new CheckBox[numColumnas];
        // Itera a través de las vistas en la segunda fila (fila 1 en términos de índices)
        for (int i = numColumnas; i < numColumnas * 2; i++) {

            // Obtiene una vista de la grilla

            childView = gridLayout.getChildAt(i);
            // Haz algo con la vista, por ejemplo, establece un OnClickListener
            if (childView instanceof CheckBox) {
                checkBoxes[contador] = (CheckBox) childView;
                contador++;
            } else if (childView instanceof TextView) {
                // checkBoxes[i] = (CheckBox) childView;
                contador++;
            }

        }


        return checkBoxes;
    }
/*
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_actions, popup.getMenu());
        popup.show();
    }

    public void showMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        // This activity implements OnMenuItemClickListener
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_actions);
        popup.show();
    }
/*
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        // Handle item selection
        // si el item seleccionado es R.id.ponerceros
        // poner el timepicker a cero horas y cero minutos
        Toast.makeText(context, "id del item" +  +  R.id.ponerceros + " es " +item.getItemId(), Toast.LENGTH_SHORT).show();
        if (item.getItemId() == R.id.ponerceros) {
            Toast.makeText(context, "hora a cero", Toast.LENGTH_SHORT).show();
            timePicker.setHour(0);

            return true;
        } else if (item.getItemId() == R.id.ponercerosmMIN) {
            timePicker.setMinute(0);
            Toast.makeText(context, "min a cero", Toast.LENGTH_SHORT).show();
            return true;
        } else
            return false;
    }*/
}