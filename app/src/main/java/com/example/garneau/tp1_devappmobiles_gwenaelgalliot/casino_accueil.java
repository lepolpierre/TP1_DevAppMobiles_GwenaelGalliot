package com.example.garneau.tp1_devappmobiles_gwenaelgalliot;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class casino_accueil extends AppCompatActivity{

    Button btn_roulette,btn_banque;
    Map<String, ?> prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefs = getSharedPreferences("sauvegarde",MODE_PRIVATE).getAll();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.casino_accueil);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Username");
        int s = MainActivity.prefs.getInt(name,0);
        Toast.makeText(this,Integer.toString(s),Toast.LENGTH_LONG).show();

        btn_roulette = findViewById(R.id.btn_roulette);
        btn_banque = findViewById(R.id.btn_banque);
        int i = 0;
        btn_roulette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), jeu_roulette.class);
                intent.putExtra("Username",name);
                startActivity(intent);
            }
        });

        btn_banque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), banque.class);
                intent.putExtra("Username",name);
                startActivity(intent);
            }
        });
    }

}
