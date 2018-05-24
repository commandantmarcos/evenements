package com.ldnr.evenements;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ldnr.evenements.DatabaseHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    private boolean action;
    private String event_type = "";/*Recupère la valeur contenue dans l'editText*/
    private String event_location = "";/*Recupère la valeur contenue dans l'editText2*/
    private RecyclerView groupe_recyclerView;

    private List<Groupe> groupes = new ArrayList<>();
    private ArrayList<Stagiaire> stagiaires = new ArrayList<>();
    private String session = Integer.toString(LocalDateTime.now().getYear());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        //Nos extras
        String EXTRA_TYPE = "type";
        String EXTRA_LOCATION = "location";


        TextView title = findViewById(R.id.title_view);
        EditText type = findViewById(R.id.edit_type);
        EditText location = findViewById(R.id.edit_location);

        addGroup();//On ajoute les groupes à la liste


       groupe_recyclerView = findViewById(R.id.recyclerView);
       groupe_recyclerView.setLayoutManager(new LinearLayoutManager(this));
       groupe_recyclerView.setAdapter(new MyAdapter(groupes));//on récupère la liste de groupe

        Bundle bundle = getIntent().getExtras();
        Resources resources = getResources();

        if(bundle != null){
            title.setText(resources.getString(R.string.modifier_evenement));
            action = true;
            type.setText(bundle.getString(EXTRA_TYPE));
            location.setText(bundle.getString(EXTRA_LOCATION));
        }
        else {
            title.setText((resources.getString(R.string.creer_evenement)));
            action = false;

        }
    }

    public void onConfirmButtonClicked(View view){
        //valider donc insérer les données
        //le but de ce bouton reste flou
    }

    public void onAddButtonClicked(View view){
        EditText edit_type = findViewById(R.id.edit_type);
        EditText edit_location = findViewById(R.id.edit_location);
        DatabaseHelper helper = DatabaseHelper.getInstance(this);

        String type =  edit_type.getText().toString();
        String location = edit_location.getText().toString();

        if (type.trim().isEmpty() || location.trim().isEmpty() || stagiaires.isEmpty()){
            Toast.makeText(this,"Remplir les champs svp.",Toast.LENGTH_LONG).show();
            return;
        }

        Evenement evenement = new Evenement();
        evenement.setType(type);
        evenement.setLieu(location);
        evenement.setHeure("Douze heures");
        evenement.setParticipants(stagiaires);

        if (action){
            helper.updateEvenement(evenement);
        }
        else {
            helper.InsertEvenement(evenement);
        }
        //controler la tentative d'update ou d'insertion ici ?

        //Insert à l'événement les groupes cochés
        //Utiliser une recyclerView et une checkBox
    }

    public void onCheckBoxClicked(View view){
        String titleGroup;
        String sessionGroup;
        int id_groupe;
        DatabaseHelper helper = DatabaseHelper.getInstance(this);
        Groupe groupe = new Groupe();

        //On récupère le nom de la formation...
        TextView groupView = view.findViewById(R.id.group_view);
        Toast.makeText(this,groupView.getText().toString(),Toast.LENGTH_LONG).show();
        titleGroup = groupView.getText().toString();

        //...ainsi que la sesion
        TextView sessionView = view.findViewById(R.id.sessionView);
        sessionGroup = sessionView.getText().toString();

        //id_groupe = helper.FindIdGroupe(sessionGroup, titleGroup);
        //groupe = helper.FindGroupe(id_groupe);
        //stagiaires.addAll(groupe.getMembres());

        //Toast.makeText(this,stagiaires.get(0).getNom(),Toast.LENGTH_LONG).show();

        //Modifie l'état actuel de la checkBox
        CheckBox checkBox = view.findViewById(R.id.checkBox);
        checkBox.setChecked((checkBox.isChecked()) ? false : true);//Si coché elle sera décochée sinon l'inverse
    }

    public void addGroup(){
        Resources resources = getResources();
        ArrayList<Stagiaire> stagiaires = new ArrayList();
        stagiaires.add(new Stagiaire(1,"Hervé","","","","",""));
        groupes.add(new Groupe(1, session,resources.getString(R.string.formation1),stagiaires));
        groupes.add(new Groupe(2, session,resources.getString(R.string.formation2),stagiaires));
        groupes.add(new Groupe(3, session,resources.getString(R.string.formation3),stagiaires));
        groupes.add(new Groupe(4, session,resources.getString(R.string.formation4),stagiaires));
        groupes.add(new Groupe(5, session,resources.getString(R.string.formation5),stagiaires));
    }

}