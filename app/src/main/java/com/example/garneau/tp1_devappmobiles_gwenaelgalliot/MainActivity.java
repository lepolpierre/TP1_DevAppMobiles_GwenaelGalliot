package com.example.garneau.tp1_devappmobiles_gwenaelgalliot;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txt_NomUtilisateur;
    private Button btn_connection;
    int Solde = 15;
    EditText txt_montant;

    // ActivityResultLauncher<Intent> activiteResultat;

    public static SharedPreferences prefs;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection);
        instance();
    }

    public void instance (){
        prefs = getSharedPreferences("sauvegarde",MODE_PRIVATE);
        txt_NomUtilisateur = (EditText)findViewById(R.id.txt_NomUtilisateur);
        btn_connection = (Button)findViewById(R.id.btn_connection);

        btn_connection.setOnClickListener(this);
    }
    public void utilisateur(){
        name = txt_NomUtilisateur.getText().toString();

        if(!prefs.contains(name)){
            SharedPreferences.Editor myEdit = prefs.edit();
            myEdit.putInt(name, 15);
            myEdit.apply();
        }
    }


    @Override
    public void onClick(View view) {
        utilisateur();
        Intent intent = new Intent(getApplicationContext(), casino_accueil.class);
        intent.putExtra("Username",name);
        startActivity(intent);
    }
}