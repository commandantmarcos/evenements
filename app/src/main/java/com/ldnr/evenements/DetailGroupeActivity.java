package com.ldnr.evenements;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class DetailGroupeActivity extends AppCompatActivity {

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_groupe);

        String EXTRA_SESSION = "date de formation";
        String EXTRA_FORMATION = "nom de la formation";


        ListView list = findViewById(R.id.affichageDetailGroupe);

        // On instancie un adaptateur avec notre liste , notre layout et l'id de notre TextView
        ArrayAdapter<String> tableau = new ArrayAdapter<>(list.getContext(), R.layout.activity_detail_groupe, R.id.affichageDetailGroupe);


        // Récupération des extras
        Bundle extras = getIntent().getExtras();

        // Si les extras sont présents on affecte aux champs leur valeur
        if(extras != null) {

            TextView viewNom = findViewById(R.id.detailGroupeFormation);
            viewNom.setText(extras.getString(EXTRA_FORMATION));

            TextView viewAge = findViewById(R.id.detailGroupeSession);
            viewAge.setText(extras.getString(EXTRA_SESSION));

        }
    }

}
