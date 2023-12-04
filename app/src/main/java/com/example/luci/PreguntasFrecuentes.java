package com.example.luci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class PreguntasFrecuentes extends AppCompatActivity {

    private Button btnInformacionCM, btnPreguntasFrecuentes, btnInformacionApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas_frecuentes);

        //Descripción: Solo redirecciona a las actividades correspondientes

        btnInformacionApp = (Button) findViewById(R.id.btnInformacionApp);
        btnPreguntasFrecuentes = (Button) findViewById(R.id.btnPreguntasFrecuentes);
        btnInformacionCM = (Button) findViewById(R.id.btnInformacionCM);

    }
}