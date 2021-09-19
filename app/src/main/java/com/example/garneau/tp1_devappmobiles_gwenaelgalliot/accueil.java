package com.example.garneau.tp1_devappmobiles_gwenaelgalliot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class accueil extends AppCompatActivity implements View.OnClickListener{

    Button btn_roulette,btn_banque;
    String name,numGagnant,txtsolde,victoire;
    TextView txt_solde,txt_numGagnant,txt_bienvenue;
    Intent intent;
    int solde;
    Boolean win;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.casino_accueil);
        init();
    }

    public void init(){
        intent = getIntent();
        name = intent.getStringExtra("Username");

        solde = connexion.prefs.getInt(name,0);

        btn_roulette = (Button)findViewById(R.id.btn_roulette);
        btn_banque = (Button)findViewById(R.id.btn_banque);
        btn_roulette.setOnClickListener(this);
        btn_banque.setOnClickListener(this);int i = 0;

        txtsolde = String.valueOf(solde);
        txt_solde = (TextView)findViewById(R.id.txt_solde);
        txt_bienvenue= (TextView)findViewById(R.id.txt_bienvenue);
        txt_numGagnant = (TextView)findViewById(R.id.txt_numGagnant);

        txt_bienvenue.setText("Bienvenue " + name);
        txt_numGagnant.setText("");
        txt_solde.setText("votre solde est de : "+txtsolde+ " jetons");
        if (intent.getStringExtra("numGagnant")!=null){
            win = intent.getBooleanExtra("win", false);
            if (win){victoire="GAGNER";}
            else{victoire="perdu... retentez votre chance";}
            numGagnant = intent.getStringExtra("numGagnant");
            txt_numGagnant.setText("le numero gagnant est : "+numGagnant+"" +
                    "\nVous avez "+ victoire+" !!!");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_roulette:
                intent = new Intent(getApplicationContext(), roulette.class);
                intent.putExtra("Username",name);
                startActivity(intent);
                break;
            case R.id.btn_banque:
                intent = new Intent(getApplicationContext(), banque.class);
                intent.putExtra("Username",name);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
