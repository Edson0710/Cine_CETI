package com.example.edson0710.cine_ceti.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.edson0710.cine_ceti.R;

public class MainActivity extends AppCompatActivity {

    private Button actividad2,actividad3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actividad2 = findViewById(R.id.btn_peli);
        actividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent1);
            }
        });

        actividad3 = findViewById(R.id.btn_sala);
        actividad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent2);
            }
        });

    }
}
