package com.example.garneau.tp1_devappmobiles_gwenaelgalliot;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class casino_accueil extends AppCompatActivity implements View.OnClickListener{

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
        btn_roulette = (Button)findViewById(R.id.btn_roulette);
        btn_banque = (Button)findViewById(R.id.btn_banque);
        btn_roulette.setOnClickListener(this);
        btn_banque.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_roulette:
                    intent = new Intent(getApplicationContext(), jeu_roulette.class);
                    startActivity(intent);

                break;

            case R.id.btn_banque:
                intent = new Intent(getApplicationContext(), banque.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
