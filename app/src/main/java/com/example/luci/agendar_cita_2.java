package com.example.luci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class agendar_cita_2 extends AppCompatActivity {

    private Spinner spinnerMedicos;
    private Button btnSiguiente3;

    //NECESITO PONER UN CALENDARIO Y VER COMO HACER LO DE LAS HORAS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_cita2);

        /*Descripció de la actividad:
        - Mostrar por medio de un spinner un listado de médicos (validar que solo sea una opción)
        - Marcar fecha en calendario (validar que la fecha sea pasada a la actual)
        - Recibir el horario por medio del radio button (VAlidar que solo sea uno)
        - El boton siguiente lleva al paso 3/3 de agendar cita
        */

        spinnerMedicos = (Spinner) findViewById(R.id.spinnerMedicos);

        btnSiguiente3 = (Button) findViewById(R.id.btnSiguiente3);

        //Redirección: Paso 2/3 agendar cita -----------------------------------------------------
        btnSiguiente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(agendar_cita_2.this, agendar_cita_3.class);
                startActivity(i);
            }
        });

    }
}