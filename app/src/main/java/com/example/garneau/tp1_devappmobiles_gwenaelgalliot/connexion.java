package com.example.garneau.tp1_devappmobiles_gwenaelgalliot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class connexion extends AppCompatActivity implements View.OnClickListener{

    EditText txt_NomUtilisateur;
    private Button btn_connection;
    String name;
    int SoldeNouvelleUtilisateur = 15;
    public static SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection);
        init();
    }
    @Override
    public void onClick(View view) {
        utilisateur();
        Intent intent = new Intent(getApplicationContext(), accueil.class);
        intent.putExtra("Username",name);
        startActivity(intent);
    }

    public void init (){
        prefs = getSharedPreferences("sauvegarde",MODE_PRIVATE);
        txt_NomUtilisateur = (EditText)findViewById(R.id.txt_NomUtilisateur);
        btn_connection = (Button)findViewById(R.id.btn_connection);
        btn_connection.setOnClickListener(this);
    }
    public void utilisateur(){
        name = txt_NomUtilisateur.getText().toString();

        if(!prefs.contains(name)){
            SharedPreferences.Editor myEdit = prefs.edit();
            myEdit.putInt(name, SoldeNouvelleUtilisateur);
            myEdit.apply();
        }
    }
}