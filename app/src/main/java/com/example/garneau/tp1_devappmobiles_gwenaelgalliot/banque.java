package com.example.garneau.tp1_devappmobiles_gwenaelgalliot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class banque extends AppCompatActivity {
    Intent intent = getIntent();
    String name = intent.getStringExtra("Username");
    Button btn_achat;
    int montant_achat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banque);
        btn_achat = (Button)findViewById(R.id.btn_achat);
        btn_achat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText txt_montant = (EditText)findViewById(R.id.txt_montant);
                montant_achat = Integer.parseInt(txt_montant.getText().toString());
                SharedPreferences sharedPreferences = getSharedPreferences("sauvegarde", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putInt(name, montant_achat);
                myEdit.apply();

                Intent intent = new Intent(getApplicationContext(), casino_accueil.class);
                intent.putExtra("Username",name);
                startActivity(intent);
            }
        });
    }

}
