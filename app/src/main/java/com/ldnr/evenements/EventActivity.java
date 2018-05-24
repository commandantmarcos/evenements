package com.ldnr.evenements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import .DataBaseHelper

public class EventActivity extends AppCompatActivity {

    private String event_type;/*Recupère la valeur contenue dans l'editText*/
    private String event_location;/*Recupère la valeur contenue dans l'editText2*/
    //private DataBaseHelper helper;
    private RecyclerView groupe_recyclerView;

    private List<Groupe> groupes = new ArrayList<>();
    private List<Stagiaire> stagiaires = new ArrayList<>();
    private String session = Integer.toString(LocalDateTime.now().getYear());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        addGroup();//On ajoute les groupes à la liste

       groupe_recyclerView = findViewById(R.id.recyclerView);
       groupe_recyclerView.setLayoutManager(new LinearLayoutManager(this));
       groupe_recyclerView.setAdapter(new MyAdapter(groupes));//on récupère la liste de groupe
    }

    public void onConfirmButtonClicked(View view){
        //valider donc insérer les données
        //le but de ce bouton reste flou
    }

    public void onAddButtonClicked(View view){
        //controler la tentative d'update ou d'insertion ici ?

        //Insert à l'événement les groupes cochés
        //Utiliser une recyclerView et une checkBox
    }

    public void addGroup(){
        //groupes.add(new Groupe(1, session,"Développeur.se C.C++.Java - en salle", stagiaires));
        //groupes.add(new Groupe(2, session,"Développeur.se C.C++.Java - à distance", stagiaires));
    }

}