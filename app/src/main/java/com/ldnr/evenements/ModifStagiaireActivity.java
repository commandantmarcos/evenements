package com.ldnr.evenements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModifStagiaireActivity extends AppCompatActivity {

    private String action;
    private String EXTRA_IMAGE = "imageUrl";
    private String EXTRA_NOM = "nom";
    private String EXTRA_PRENOM = "prenom";
    private String EXTRA_AGE = "age";
    private String EXTRA_MAIL = "mail";
    private String EXTRA_TEL = "tel";
    private String EXTRA_SESSION = "session";
    private String EXTRA_FORMATION = "formation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_stagiaire);

        Bundle extras = getIntent().getExtras();

        // S'il n'y a pas d'extras la page et en "mode inscription"
        // sinon elle est en "mode modification"
        if(extras == null) {
            action = "Inscription";
            TextView viewTitre = findViewById(R.id.modifStagiaireTitle);
            viewTitre.setText(getResources().getString(R.string.inscriptionStagiaireTitre));
        }
        else {
            action = "Modification";
            TextView viewTitre = findViewById(R.id.modifStagiaireTitle);
            viewTitre.setText(getResources().getString(R.string.modifStagiaireTitre));
        }
        Toast.makeText(this,action,Toast.LENGTH_LONG).show();

        // Si la page est en modification, on récupère les données du stagiaire à modifier
        if(action.equals("Modification")) {
            EditText viewNom = findViewById(R.id.modifStagiaireNom);
            viewNom.setText(extras.getString(EXTRA_NOM));

            EditText viewPrenom = findViewById(R.id.modifStagiairePrenom);
            viewPrenom.setText(extras.getString(EXTRA_PRENOM));

            EditText viewAge = findViewById(R.id.modifStagiaireAge);
            viewAge.setText(extras.getString(EXTRA_AGE));

            EditText viewMail = findViewById(R.id.modifStagiaireMail);
            viewMail.setText(extras.getString(EXTRA_MAIL));

            EditText viewTel = findViewById(R.id.modifStagiaireTel);
            viewTel.setText(extras.getString(EXTRA_TEL));

            EditText viewImage = findViewById(R.id.modifStagiaireImage);
            viewImage.setText(extras.getString(EXTRA_IMAGE));
        }
    }

    /**
     * Fonction qui va vérifier les données rentrées pour insérer un stagiaire dans la bdd
     * @param view
     */
    public void onValidationClicked(View view) {
        // Récupération des données saisies par l'utilisateur
        EditText viewNom = findViewById(R.id.modifStagiaireNom);
        String nom = viewNom.getText().toString();

        EditText viewPrenom = findViewById(R.id.modifStagiairePrenom);
        String prenom = viewPrenom.getText().toString();

        EditText viewAge = findViewById(R.id.modifStagiaireAge);
        String age = viewAge.getText().toString();

        EditText viewMail = findViewById(R.id.modifStagiaireMail);
        String mail = viewMail.getText().toString();

        EditText viewTel = findViewById(R.id.modifStagiaireTel);
        String tel = viewTel.getText().toString();

        EditText viewImage = findViewById(R.id.modifStagiaireImage);
        String imageUrl = viewImage.getText().toString();

        // Vérification des données saisies
        if(nom.trim().isEmpty() || prenom.trim().isEmpty() || age.trim().isEmpty()
                || mail.trim().isEmpty() || tel.trim().isEmpty() || imageUrl.trim().isEmpty()) {
            Toast.makeText(this,"erreur",Toast.LENGTH_LONG).show();
        }
    }
}
