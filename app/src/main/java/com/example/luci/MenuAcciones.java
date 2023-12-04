package com.example.luci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAcciones extends AppCompatActivity {

    private Button btnVerPerfil, btnEditarPerfil, btnAgendarCita, btnVerCitas, btnPanelInfo, btnCerrarSesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_acciones);

        //Descripción de la actividad: Solo redirecciona a las actividades correspondientes

        btnVerPerfil = (Button) findViewById(R.id.btnVerPerfil);
        btnEditarPerfil = (Button) findViewById(R.id.btnEditarPerfil);
        btnAgendarCita = (Button) findViewById(R.id.btnAgendarCita);
        btnVerCitas = (Button) findViewById(R.id.btnVerCitas);
        btnPanelInfo = (Button) findViewById(R.id.btnPanelInfo);
        btnCerrarSesion = (Button) findViewById(R.id.btnCerrarSesion);

        //Redirección: Desde menú acciones a perfil personal-----------------------------------------------------
        btnVerPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuAcciones.this, PerfilPersonal.class);
                startActivity(i);
            }
        });
        //Redirección: Desde menú de acciones a actualizar datos del perfil-----------------------------------------------------
        btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuAcciones.this, ActualizarDatosPerfil.class);
                startActivity(i);
            }
        });
        //Redirección: Desde menú de acciones a Agendar cita-----------------------------------------------------
        btnAgendarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuAcciones.this, AgendarCita.class);
                startActivity(i);
            }
        });
        //Redirección: Desde menú de acciones a Ver citas-----------------------------------------------------
        btnVerCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuAcciones.this, VerCitas.class);
                startActivity(i);
            }
        });
        //Redirección: Desde menú de acciones a panel informativo-----------------------------------------------------
        btnPanelInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuAcciones.this, PreguntasFrecuentes.class);
                startActivity(i);
            }
        });
        //Redirección: Desde menú de acciones al login -----------------------------------------------------
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuAcciones.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}