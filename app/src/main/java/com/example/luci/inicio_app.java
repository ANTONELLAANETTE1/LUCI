package com.example.luci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class inicio_app extends AppCompatActivity {

    private ProgressBar progressBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_app);

        /*Descripción de la actividad:
        - Se inicia la aplicación al cargar la progressBar
        */

    progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);

        new Thread(new Runnable() {
            public void run() {
                int progressStatus = 0;
                while (progressStatus < 100) {
                    progressStatus += 1;
                    int finalProgressStatus = progressStatus;
                    View handler = null;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar1.setProgress(finalProgressStatus);
                        }
                    });
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        myIntent.putExtra("key", "......"); //Optional parameters
        startActivity(myIntent);
    }
}