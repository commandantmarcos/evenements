package com.ldnr.evenements;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
   // private GroupeRecyclerViewAdapter adapter;
    private Resources res;

    private String formation;
    private String session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("pouet", "pouet");
        setContentView(R.layout.activity_detail_groupe);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            formation = extras.getString("formation");
            session = extras.getString("session");

            TextView textFormation = findViewById(R.id.textViewForma);
            textFormation.setText(formation);
        }

        recyclerView = findViewById(R.id.recyclerViewDetailGroupe);
        layoutManager =  new LinearLayoutManager(this);
        List<Stagiaire> stagiaire = createListStagiaire();

        DetailGroupeRecyclerViewAdapter adapter = new DetailGroupeRecyclerViewAdapter(stagiaire);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter( adapter);
        recyclerView.setHasFixedSize(true);

        //Getting device orientation
        int displayMode = getResources().getConfiguration().orientation;

        //Changes depending on orientation
        if (displayMode == 1){
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }




    }

    public List<Stagiaire> createListStagiaire(){

        List<Stagiaire> stagiaire = new ArrayList<>();
        DatabaseHelper db = DatabaseHelper.getInstance(this);
        int id_groupe = db.FindIdGroupe(session, formation.trim());
        Log.d("pouet 0", session.toString().trim());
        Log.d("pouet", "pouet");


     //  Log.d("Stag " , ""+);
        Groupe group = db.FindGroupe(id_groupe);
        Log.d("Groupe " , group.getFormation());
        Log.d("Stag",""+group.getMembres().size());
        stagiaire = group.getMembres();

        Log.d("Stag liste",""+stagiaire.size());
        return  stagiaire;
    }

}
