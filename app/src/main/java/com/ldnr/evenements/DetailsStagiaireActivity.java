package com.ldnr.evenements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Vue de détail des informations d'un stagiare
 */
public class DetailsStagiaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_stagiaire);

        // Ici les clés des extras contenant les informations
        String EXTRA_IMAGE = "imageUrl";
        String EXTRA_NOM = "nom";
        String EXTRA_PRENOM = "prenom";
        String EXTRA_AGE = "age";
        String EXTRA_MAIL = "mail";
        String EXTRA_TEL = "tel";
        String EXTRA_SESSION = "session";
        String EXTRA_FORMATION = "formation";

        // Récupération des extras
        Bundle extras = getIntent().getExtras();

        // Si les extras sont présents on affecte aux champs leur valeur
        if(extras != null) {

            ImageView viewImage = findViewById(R.id.detailsImage);
            Picasso.with(viewImage.getContext()).load(extras.getString(EXTRA_IMAGE)).centerCrop().fit().error(R.drawable.imagenotfound).into(viewImage);

            TextView viewNom = findViewById(R.id.detailsNom);
            viewNom.setText(extras.getString(EXTRA_NOM));

            TextView viewPrenom = findViewById(R.id.detailsPrenom);
            viewPrenom.setText(extras.getString(EXTRA_PRENOM));

            TextView viewAge = findViewById(R.id.detailsAge);
            viewAge.setText(extras.getString(EXTRA_AGE));

            TextView viewMail = findViewById(R.id.detailsMail);
            viewMail.setText(extras.getString(EXTRA_MAIL));

            TextView viewTel = findViewById(R.id.detailsTel);
            viewTel.setText(extras.getString(EXTRA_TEL));

            TextView viewSession = findViewById(R.id.detailsSession);
            viewSession.setText(extras.getString(EXTRA_SESSION));

            TextView viewFormation = findViewById(R.id.detailsFormation);
            viewFormation.setText(extras.getString(EXTRA_FORMATION));
        }
    }
}
