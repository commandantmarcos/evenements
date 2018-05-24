package com.ldnr.evenements;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class DetailGroupeActivity extends AppCompatActivity {

    private DatabaseHelper db;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private GroupeRecyclerViewAdapter adapter;
    private Resources res;

    private String formation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_groupe);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            formation = extras.getString("formation");
            TextView textFormation = findViewById(R.id.textViewForma);
            textFormation.setText(formation);
        }

        recyclerView = findViewById(R.id.recyclerViewDetailGroupe);
        layoutManager =  new LinearLayoutManager(this);

        //Getting device orientation
        int displayMode = getResources().getConfiguration().orientation;

        //Changes depending on orientation
        if (displayMode == 1){
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }

        List<Stagiaire> stagiaire = createListStagiaire();
        recyclerView.setAdapter(new DetailGroupeRecyclerViewAdapter(stagiaire));
    }

    public List<Stagiaire> createListStagiaire(){

        List<Stagiaire> stagiaire = new ArrayList<>();

        TextView textFormation = findViewById(R.id.textViewForma);
        String formation = textFormation.getText().toString();

        stagiaire.add(new Stagiaire(0, "jean Albert", formation, "2018, 05, 25", "0505050505", "allo@OUI.fr", "paspourl'instant"));
        stagiaire.add(new Stagiaire(0, "jean Albert2", formation, "2018, 05, 25", "0505050506", "allo@PEUETRE.fr", "paspourl'instant"));
        stagiaire.add(new Stagiaire(0, "jean Albert3", formation, "2018, 05, 25", "0505050507", "allo@MOUAIS.fr", "paspourl'instant"));
        stagiaire.add(new Stagiaire(0, "jean Albert4", formation, "2018, 05, 25", "0505050508", "allo@BOF.fr", "paspourl'instant"));
        stagiaire.add(new Stagiaire(0, "jean Albert5", formation, "2018, 05, 25", "0505050509", "allo@NON.fr", "paspourl'instant"));
        return  stagiaire;
    }

}
