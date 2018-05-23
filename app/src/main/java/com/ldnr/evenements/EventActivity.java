package com.ldnr.evenements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import .DataBaseHelper

public class EventActivity extends AppCompatActivity {

    private String event_type;/*Recupère la valeur contenue dans l'editText*/
    private String event_location;/*Recupère la valeur contenue dans l'editText2*/
    //private DataBaseHelper helper;
    private RecyclerView list_group;

    private List<Groupe> test_list = new ArrayList();
    private List<Stagiaire> stagiaireList = new ArrayList<>();
    private Date session;
    private Groupe dev = new Groupe(1, session,"Developpeur.se logiciel C.C++.Java", stagiaireList);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

       list_group = findViewById(R.id.list_grp);
       list_group.setLayoutManager(new LinearLayoutManager(this));

       for(int i = 0; i<7 ; i++){
           test_list.add(dev);
       }
       list_group.setAdapter(new MyAdapter (test_list));//on récupère la liste de groupe
    }

    public void onConfirmButtonClicked(View view){
        //valider donc insérer les données
        //le but de ce bouton reste flou
    }

    public void onAddButtonClicked(View view){
        //controler la tentative d'update ou d'insertion ici ?

        //Insert à l'événement les groupes cochés
        //listView doit contenir TOUT les groupes existants et il faudra les cocher
        //utiliser une recyclerView et une checkBox
    }

}