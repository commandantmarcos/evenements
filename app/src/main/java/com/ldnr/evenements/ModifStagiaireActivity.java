package com.ldnr.evenements;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class ModifStagiaireActivity extends AppCompatActivity {

    //String déterminant pour la gestion des données saisies s'il s'agit d'une inscription ou d'une modification de stagiaire
    private String action;
    //Strings permettant d'indiquer sur quels champs des erreurs ont été détectées
    private String erreurNom = "";
    private String erreurAge = "";
    private String erreurMail = "";
    private String erreurTel= "";
    private String erreurSession = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_stagiaire);

        //String correspondant aux clés des extras
        String EXTRA_IMAGE = "imageUrl";
        String EXTRA_NOM = "nom";
        String EXTRA_AGE = "age";
        String EXTRA_MAIL = "mail";
        String EXTRA_TEL = "tel";
        String EXTRA_SESSION = "session";
        String EXTRA_FORMATION = "formation";

        Bundle extras = getIntent().getExtras();
        Resources res = getResources();
        // S'il n'y a pas d'extras la page et en "mode inscription"
        // sinon elle est en "mode modification"
        if(extras == null) {
            action = "Inscription";
            TextView viewTitre = findViewById(R.id.modifStagiaireTitle);
            viewTitre.setText(res.getString(R.string.inscriptionStagiaireTitre));
        }
        else {
            action = "Modification";
            TextView viewTitre = findViewById(R.id.modifStagiaireTitle);
            viewTitre.setText(res.getString(R.string.modifStagiaireTitre));
        }
        Toast.makeText(this,action,Toast.LENGTH_LONG).show();

        //Affectation des valeurs au spinner (combobox de choix de la formation)
        Spinner spinFormation = findViewById(R.id.modifStagiaireFormation);

        ArrayAdapter<String> adapterFormation = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item);
        adapterFormation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Ici il faut affecter les noms des formations depuis la base de données
        adapterFormation.addAll("Developpeur(se) logiciel C/C++/JAVA","hello","world");
        spinFormation.setAdapter(adapterFormation);

        // Si la page est en modification, on récupère les données du stagiaire à modifier
        if(action.equals("Modification")) {
            EditText viewNom = findViewById(R.id.modifStagiaireNom);
            viewNom.setText(extras.getString(EXTRA_NOM));

            EditText viewAge = findViewById(R.id.modifStagiaireAge);
            viewAge.setText(extras.getString(EXTRA_AGE));

            EditText viewMail = findViewById(R.id.modifStagiaireMail);
            viewMail.setText(extras.getString(EXTRA_MAIL));

            EditText viewTel = findViewById(R.id.modifStagiaireTel);
            viewTel.setText(extras.getString(EXTRA_TEL));

            EditText viewImage = findViewById(R.id.modifStagiaireImage);
            viewImage.setText(extras.getString(EXTRA_IMAGE));

            EditText viewSession = findViewById(R.id.modifStagiaireSession);
            viewSession.setText(extras.getString(EXTRA_SESSION));

            String formation = extras.getString(EXTRA_FORMATION);
            int selected = 0;
            for(int i = 0 ; i < spinFormation.getAdapter().getCount() ; i++) {
                if(formation.equals(spinFormation.getItemAtPosition(i).toString())) {
                    spinFormation.setSelection(i);
                }
            }
        }
    }

    /**
     * Fonction qui va vérifier les données rentrées pour insérer un stagiaire dans la bdd
     * @param view vue depuis laquelle la méthode est appelée
     */
    public void onValidationClicked(View view) {
        Resources res = getResources();

        // Récupération des données saisies par l'utilisateur
        EditText viewNom = findViewById(R.id.modifStagiaireNom);
        String nom = viewNom.getText().toString();

        EditText viewAge = findViewById(R.id.modifStagiaireAge);
        String age = viewAge.getText().toString();

        EditText viewMail = findViewById(R.id.modifStagiaireMail);
        String mail = viewMail.getText().toString();

        EditText viewTel = findViewById(R.id.modifStagiaireTel);
        String tel = viewTel.getText().toString();

        EditText viewImage = findViewById(R.id.modifStagiaireImage);
        String imageUrl = viewImage.getText().toString();

        EditText viewSession = findViewById(R.id.modifStagiaireSession);
        String session = viewSession.getText().toString();

        Spinner viewFormation = findViewById(R.id.modifStagiaireFormation);
        String formation = viewFormation.getSelectedItem().toString();

        // Vérification des données saisies
        // Je ne vérifie pas l'image, il y aura un image not found affiché si l'url n'est pas valide
        // Champ vide = erreur (sauf pour l'image)
        if(nom.trim().isEmpty()
                || age.trim().isEmpty()
                || session.trim().isEmpty()
                || mail.trim().isEmpty()
                || tel.trim().isEmpty()) {
            Toast.makeText(this,res.getString(R.string.modifStagiaireErreurChampVide),Toast.LENGTH_LONG).show();
        }
        else {
            // Vérification validité des données saisies
            if (checkNom(nom) && checkAge(age) && checkMail(mail) && checkTel(tel) && checkSession(session)) {
                DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
                /* ajout à la BDD/modification de la BDD et la fermeture de l'activité */
                if(action.equals("modification")) {

                }
                else { // action = "inscription"
                    Stagiaire stag = new Stagiaire();
                    stag.setNom(nom);
                    stag.setSession(session);
                    stag.setFormation(formation);
                    stag.setMail(mail);
                    stag.setUrl(imageUrl);
                }
            } else {
                // Message d'erreur indiquant quels champs comportent des erreurs
                Toast.makeText(this,
                        res.getString(R.string.modifStagiaireErreurChamp) + " "
                                + erreurNom
                                + erreurAge
                                + erreurMail
                                + erreurTel
                                + erreurSession, Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * CheckNom vérifie que le nom ne contienne pas de chiffre
     * @param nom nom à vérifier
     * @return boolean
     */
    private boolean checkNom(String nom) {
        if(Pattern.compile("[0-9]").matcher(nom).find()) {
            erreurNom = "Nom ";
            return false;
        }
        erreurNom = "";
        return true;
    }

    /**
     * CheckAge vérifie que l'âge est un nombre situé entre 6 et 150
     * @param age âge à vérifier
     * @return boolean
     */
    private boolean checkAge(String age) {
        int ageInt;
        try {
            ageInt = Integer.parseInt(age.trim());
        } catch(NumberFormatException e) {
            erreurAge = "Age ";
            return false;
        }
        if(ageInt < 6 || ageInt > 150) {
            erreurAge = "Age ";
            return false;
        }
        erreurAge = "";
        return true;
    }

    /**
     * CheckMail vérifie que le mail a un format d'adresse mail valide
     * @param mail mail à vérifier
     * @return boolean
     */
    private boolean checkMail(String mail) {
        if(!mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
            erreurMail = "Mail ";
            return false;
        }
        erreurMail = "";
        return true;
    }

    /**
     * CheckTel vérifie que le téléphone a un format français (on peut toujours ajouter des formats possibles)
     * @param tel numéro de téléphone à vérifier
     * @return boolean
     */
    private boolean checkTel(String tel) {
        if(!tel.trim().matches("(0|\\+33|0033)[1-9][0-9]{8}")) {
            erreurTel = "Tel ";
            return false;
        }
        erreurTel = "";
        return true;
    }

    /**
     * CheckSession vérifie que la session est un nombre correspondant à une année comprise entre 2002 et l'année actuelle
     * @param session session à vérifier
     * @return boolean
     */
    private boolean checkSession(String session) {
        int sessionInt;
        try {
            sessionInt = Integer.parseInt(session.trim());
        } catch (NumberFormatException e) {
            erreurSession = "Session ";
            return false;
        }
        if(sessionInt < 2002 || sessionInt > LocalDateTime.now().getYear()) {
            erreurSession = "Session ";
            return false;
        }
        erreurSession = "";
        return true;
    }
}
