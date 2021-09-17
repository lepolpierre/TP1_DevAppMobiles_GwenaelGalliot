package com.example.garneau.tp1_devappmobiles_gwenaelgalliot;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.Toast;

public class jeu_roulette extends AppCompatActivity {
    EditText txtNumb_mise;
    Button btn_jouer;
    RadioButton btnRad_pair;
    RadioButton btnRad_impaire;
    EditText txtNumb_nombreChoisie;

    public static final String Name = "nameKey";
    public static final int solde = 10;
    int mise;
    int nbChoisie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu_roulette);

        txtNumb_mise = (EditText)findViewById(R.id.txtNumb_mise);
        btn_jouer = (Button)findViewById(R.id.btn_jouer);
        btnRad_pair = (RadioButton)findViewById(R.id.btnRad_pair);
        btnRad_impaire = (RadioButton)findViewById(R.id.btnRad_impair);

        btn_jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mise = Integer.parseInt(txtNumb_mise.getText().toString());
                nbChoisie = Integer.parseInt((txtNumb_nombreChoisie.getText().toString()));

                Intent intent = new Intent(getApplicationContext(), casino_accueil.class);
                startActivity(intent);
            }
        });
    }
}
