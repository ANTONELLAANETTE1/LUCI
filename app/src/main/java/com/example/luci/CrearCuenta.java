package com.example.luci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearCuenta extends AppCompatActivity {
    //Validar rut y largo de contraseña

    private EditText etNombre, etRut, etFechaNacimiento, etEmail, etTelefono, etDireccion, etPass;

    private Button btnr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        /* Descripcion de la actividad:
         - Ingresar datos
         - Validar Campos vacios
         - Hacer obligatorios a TODOS los campos
         - Crear el registro del usuario en la base de datos (o posibilidad error), confirmar esto
         con un toast.
         * */

        btnr = (Button) findViewById(R.id.btnr);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etRut = (EditText) findViewById(R.id.etRut);
        etFechaNacimiento = (EditText) findViewById(R.id.etFechaNacimiento);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etDireccion = (EditText) findViewById(R.id.etDireccion);
        etPass = (EditText) findViewById(R.id.etTelefono2);

        //Redirección: Desde Crear cuenta a Menú de Acciones ---------------------------------------
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CrearCuenta.this, MenuAcciones.class);
                startActivity(i);
                Toast.makeText(CrearCuenta.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            }
        });
    }
}