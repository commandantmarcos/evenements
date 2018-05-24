package com.ldnr.evenements;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/*
    Classe affichant la liste des groupes
 */

public class OngletGroupeActivity extends ListFragment implements AdapterView.OnItemClickListener {

    private DatabaseHelper db;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_onglet_groupe, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // On instancie un adaptateur avec notre liste , notre layout et l'id de notre TextView
        ArrayAdapter<String> tableau = new ArrayAdapter<>(getActivity(), R.layout.activity_list_groupe, R.id.listeGroupe);

        // On ajoute nos données de la BD


        // On affiche cet adaptateur
        setListAdapter(tableau);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }




}
