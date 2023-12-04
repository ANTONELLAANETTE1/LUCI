package com.example.luci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PerfilPersonal extends AppCompatActivity {

    private EditText MostrarRutNombre, MostrarRol, MostrarEmail, MostrarTelefono, MostrarDireccion, MostrarPlanSalud;
    private EditText MostrarNombreE, MostrarDireccionE, MostrarTelefonoE, MostrarEmailE;

    //NO PUDE DECLARA EL IMAGENVIEW (QUE CORRESPONDE A LA FOTO DE PERFIL), ¿LA QUITO?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_personal);

        //Descripción de la actividad: Solo cumple la función de mostrar la información almacenada

        //ANTES DE DECLARAR Y USAR LOS ELEMENTOS DE VISTA, PREGUNTARE COMO ACCEDER Y MOSTRAR ESOS DATOS
    }
}