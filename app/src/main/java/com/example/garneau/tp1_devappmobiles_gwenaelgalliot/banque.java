package com.example.garneau.tp1_devappmobiles_gwenaelgalliot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class banque extends AppCompatActivity implements View.OnClickListener{
    String name;
    Button btn_achat;
    int montant_achat = 0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banque);
        intent = getIntent();
        name = intent.getStringExtra("Username");
        btn_achat = (Button) findViewById(R.id.btn_achat);
        btn_achat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int argent = connexion.prefs.getInt(name,0);
        EditText txt_montant = (EditText)findViewById(R.id.txt_montant);
        montant_achat = Integer.parseInt(txt_montant.getText().toString());
        argent = argent + montant_achat;
        SharedPreferences.Editor myEdit = connexion.prefs.edit();
        myEdit.putInt(name, argent);
        myEdit.apply();

        intent = new Intent(getApplicationContext(), accueil.class);
        intent.putExtra("Username",name);
        startActivity(intent);
    }
}
