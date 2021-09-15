package com.example.garneau.tp1_devappmobiles_gwenaelgalliot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    SharedPreferences prefs;


    // connection
    EditText txt_NomUtilisateur;
    Button btn_connection;
    int Solde = 0;




    // jeu roulette
    EditText txtNumb_mise;
    Button btn_jouer;
    RadioButton btnRad_pair;
    RadioButton btnRad_impaire;
    EditText txtNumb_nombreChoisie;
    String name;
    public static final String Name = "nameKey";
    public static final int solde = 10;
    int mise;
    int nbChoisie;
    int nbClickPaire = 0;
    int nbClickImpaire = 0;
    int test;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection);
        prefs = getSharedPreferences("sauvegard",MODE_PRIVATE);

//  connection
        txt_NomUtilisateur = (EditText)findViewById(R.id.txtNumb_nombreChoisie);
        btn_connection = (Button)findViewById(R.id.btn_connection);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(Name, "bob");
        editor.putInt("solde", 10);
        editor.apply();

        SharedPreferences sharedPreferences = getSharedPreferences("solde", MODE_PRIVATE);



//  jeu roulette
        txtNumb_mise = (EditText)findViewById(R.id.txtNumb_mise);
        btn_jouer = (Button)findViewById(R.id.btn_jouer);
        btnRad_pair = (RadioButton)findViewById(R.id.btnRad_pair);
        btnRad_impaire = (RadioButton)findViewById(R.id.btnRad_impair);


        btn_jouer.setOnClickListener( this);
        btnRad_pair.setOnClickListener(this);
        btnRad_impaire.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
//  connection


//  roulette
        switch (v.getId()) {
            case R.id.btn_jouer:
                mise = Integer.parseInt(txtNumb_mise.getText().toString());
                break;

            case R.id.btnRad_impair:
                if (btnRad_pair.isChecked()){
                    btnRad_pair.setChecked(false);
                    nbClickPaire += 1;
                }
                nbClickImpaire += 1;
                if(nbClickImpaire % 2 == 0 && nbClickImpaire!= 0)
                {
                    btnRad_impaire.setChecked(false);
                }
                break;

            case R.id.btnRad_pair:
                if (btnRad_impaire.isChecked()){
                    btnRad_impaire.setChecked(false);
                    nbClickImpaire += 1;
                }
                nbClickPaire += 1;
                if (nbClickPaire % 2 == 0 && nbClickPaire!= 0)
                {
                    btnRad_pair.setChecked(false);
                }
                break;
        }
        if (btnRad_pair.isChecked() || btnRad_impaire.isChecked()) {
        txtNumb_nombreChoisie.setEnabled(false);
        }
        else{
            txtNumb_nombreChoisie.setEnabled(true);
        }
    }

}