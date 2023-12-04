package com.example.luci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class agendar_cita_3 extends AppCompatActivity {

    private Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_cita3);

        /*Descripción de la actividad:
        - Mostrar datos de la cita
        - El boton confirmar registra la cita en la en la base de datos y confirma el  estado de la cita (agendada o no)
        */

        btnConfirmar = (Button) findViewById(R.id.btnConfirmar);


        //Redirección: Paso 3/3 agendar cita-----------------------------------------------------
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(agendar_cita_3.this, MenuAcciones.class);
                startActivity(i);
                try {
                    Toast.makeText(agendar_cita_3.this, "Su cita fue agendada con éxito", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(agendar_cita_3.this, "ERROR, inténtelo más tarde", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}