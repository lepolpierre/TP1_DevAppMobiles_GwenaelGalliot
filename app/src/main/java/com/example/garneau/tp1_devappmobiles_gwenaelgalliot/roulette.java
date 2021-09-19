package com.example.garneau.tp1_devappmobiles_gwenaelgalliot;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import java.util.Random;

        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Map;

public class roulette extends AppCompatActivity implements View.OnClickListener{
    EditText txtNumb_mise,txtNumb_nombreChoisie;
    RadioButton btnRad_pair,btnRad_impaire;
    TextView txtVMise, txtVNbChoisie;
    Button btn_jouer;
    int random,mise,nbChoisie,gain,argent;
    String name,numGagnant, numJouer;
    int max = 36;
    int min = 1;
    Boolean jeux,win,erreur; // jeux vraie = nombre exacte / jeux faux = pair|impaire
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu_roulette);
        intent = getIntent();
        name = intent.getStringExtra("Username");
        init();
    }

    public void init(){
        txtNumb_mise = (EditText)findViewById(R.id.txtNumb_mise);
        txtNumb_nombreChoisie = (EditText)findViewById(R.id.txtNumb_nombreChoisie);
        txtVMise= (TextView)findViewById(R.id.txtVMise);
        txtVNbChoisie= (TextView)findViewById(R.id.txtVNbChoisie);
        btn_jouer = (Button)findViewById(R.id.btn_jouer);
        btnRad_pair = (RadioButton)findViewById(R.id.btnRad_pair);
        btnRad_impaire = (RadioButton)findViewById(R.id.btnRad_impair);
        btn_jouer.setOnClickListener(this);
        btnRad_pair.setOnClickListener(this);
        btnRad_impaire.setOnClickListener(this);
        argent = connexion.prefs.getInt(name,0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_jouer:
                    if (verification()){
                        jeux();
                        if (win){
                            gains();
                        }
                        numGagnant = String.valueOf(random);
                        numJouer = txtNumb_nombreChoisie.getText().toString();
                        intent = new Intent(getApplicationContext(), accueil.class);
                        intent.putExtra("Username",name);
                        intent.putExtra("numGagnant",numGagnant);
                        intent.putExtra("win", win);
                        startActivity(intent);
                        break;
                    }
                    else    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "jetons insuffisant", Toast.LENGTH_LONG);
                        toast.show();
                        break;

                }

            case R.id.btnRad_pair:
                txtNumb_nombreChoisie.setEnabled(false);
                break;
            case R.id.btnRad_impair:
                txtNumb_nombreChoisie.setEnabled(false);
                break;
            default:
                break;
        }

    }

    public void gains(){
       if (jeux){
           gain = mise * 35;
       }
       else{
           gain = mise ;
       }
        int argent = connexion.prefs.getInt(name,0);
        argent = argent + gain;
        SharedPreferences.Editor myEdit = connexion.prefs.edit();
        myEdit.putInt(name, argent);
        myEdit.apply();
    }

    public void perte(){
        argent = argent - mise;
        SharedPreferences.Editor myEdit = connexion.prefs.edit();
        myEdit.putInt(name, argent);
        myEdit.apply();
    }

    public Boolean verification(){
        String numbMise =txtNumb_mise.getText().toString();
        if (numbMise.equals ("")){
            erreur = true;
        }
        else if (argent <= mise)
        {
            erreur = true;
        }
        else if (nbChoisie > 36 || nbChoisie < 1){
            erreur = true;
        }
        else{
            erreur = false;
        }

        return erreur;
    }

    public void jeux(){
        Random rand = new Random();
        random = rand.nextInt((max - min)+1)+ min;

        if (btnRad_pair.isChecked() || btnRad_impaire.isChecked())
        {
            if (btnRad_pair.isChecked()){
                if (random % 2 == 0){
                    win = true;
                }
                else{
                    win = false;
                    perte();
                }
            }
            else{
                if (random % 2 == 0){
                    win = false;
                    perte();
                }
                else{
                    win = true;
                }
            }
            jeux = false;
        }
        else{
            nbChoisie = Integer.parseInt(txtNumb_nombreChoisie.getText().toString());
                if (nbChoisie == random){
                    win = true;
                }
                else{
                    win = false;
                    perte();
                }

            jeux = true;
        }
    }
}
