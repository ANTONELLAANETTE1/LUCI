package com.example.luci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.nullness.qual.NonNull;

public class MainActivity extends AppCompatActivity {
    //Declarar Componentes
    private EditText et1, et2;
    private Button btncc;
    private Button btni;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String rut,password;
    private static final String BROKER_URL = "mqtt://androidteststiqq.cloud.shiftr.io:1883";
    private static final String CLIENT_ID = "APP_LUXI";
    private MqttHandler mqttHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Descripción de la actividad:
        - Ingresar datos
        - Validar campos vacios
        - Validar existencia del usuario:
            - Si está registrado redirecciona al menú de acciones (ó posibilidad de error)
            - Si No está registrado dará aviso por medio de un Toast y el usuario deberá registrarse,
            se redirecciona al usuario a CrearCuenta.
        - Validar largo de contraseña:
            - Máximo 10 carácteres.
            - Excluir carácteres especiales {#"!$%&/()=?¿¡}

        Validaciones:
        - Campos vacios
        - Existencia del usuario
        - Largo de la contraseña y carateres validos
        */

        //Inicializar Componentes

        btncc = (Button) findViewById(R.id.btncc);
        btni = (Button) findViewById(R.id.btni);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        mqttHandler = new MqttHandler();
        mqttHandler.connect(BROKER_URL,CLIENT_ID,this);
        subscribeToTopic("Tema1");
        publishMessage("Tema1","asd");

        //Llamar métodos

        inicializarFirebase();
        //Investigar: Debo instanciar la base de datos en cada activity, cada vez que quiera usarlo ó solo una vez.

        //Redirección del botón Crear cuenta (btncc)-- ---------------------------------------------

        btncc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CrearCuenta.class);
                startActivity(i);
            }
        });

        //Redirección del botón ingresar (btni)-----------------------------------------------------

        btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    rut = et1.getText().toString();
                    password = et2.getText().toString();
                    login();
                }catch(Exception e){
                    Toast.makeText(MainActivity.this, "ERROR"+ e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void publishMessage(String topic, String message){
        Toast.makeText(this, "Publishing message: " + message, Toast.LENGTH_SHORT).show();
        mqttHandler.publish(topic,message);
    }
    private void subscribeToTopic(String topic){
        Toast.makeText(this, "Subscribing to topic "+ topic, Toast.LENGTH_SHORT).show();
        mqttHandler.subscribe(topic);
    }
    @Override
    protected void onDestroy() {
        mqttHandler.disconnect();
        super.onDestroy();

    }

    //Login ------------------------------------------------------------------------------------------
    private void login(){

            databaseReference.child("Usuarios").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    try{

                    for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                        Usuarios u = objSnaptshot.getValue(Usuarios.class);

                        if(rut.equals(u.getRut())){
                            if (password.equals(u.getPass())){
                                CommonFn.validaRut(u.getRut());
                                Toast.makeText(MainActivity.this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(MainActivity.this, MenuAcciones.class);
                                startActivity(i);
                            }
                            else if(rut.isEmpty() || password.isEmpty()){
                                Toast.makeText(MainActivity.this, "Rellene ambos campos", Toast.LENGTH_SHORT).show();
                            }

                            else{
                                Toast.makeText(MainActivity.this, "El usuario no existe, debe registrarse", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "ERROR. Intente más tarde"+ e.getMessage(), Toast.LENGTH_SHORT).show();

                }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

    }

    //Fin Login


    private void inicializarFirebase (){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

}