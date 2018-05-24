package com.ldnr.evenements;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupeFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private GroupeRecyclerViewAdapter adapter;
    private Resources res;
    private Button button;

    public GroupeFragment() {
        // Required empty public constructor
    }

    public static GroupeFragment newInstance(){

        //Create new fragment
        GroupeFragment frag = new GroupeFragment();

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_groupe, container, false);

        button = view.findViewById(R.id.button);

        recyclerView = view.findViewById(R.id.recyclerViewGroupe);
        layoutManager =  new LinearLayoutManager(getActivity());

        recyclerView.isClickable();

        //Getting device orientation
        int displayMode = getResources().getConfiguration().orientation;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createStag = new Intent(getActivity(), ModifStagiaireActivity.class);
                startActivity(createStag);
            }
        });

        //Changes depending on orientation
        if (displayMode == 1){
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        }

        ArrayList<Groupe> groupe = createListGroupes();
        recyclerView.setAdapter(new GroupeRecyclerViewAdapter(groupe));

        return view;
    }


    public ArrayList<Groupe> createListGroupes(){

        DatabaseHelper db = DatabaseHelper.getInstance(getContext());
        ArrayList<Stagiaire> membres = new ArrayList<>();


        db.InsertStagiaire(new Stagiaire(0,"Bersxxnard", "JAVA EE", "20017-20018", "070003390708", "jeaoon@gmail.com", "https://disney-planet.fr/wp-content/uploads/2015/09/bernard-personnage-aventure-bernard-bianca-04.jpg"));
        db.InsertStagiaire(new Stagiaire(0,"Bianxxsca", "JAVA EE", "20017-20018", "063706005508", "jeanoo@gmail.com", "https://www.google.fr/search?q=bernard+et+bianca&source=lnms&tbm=isch&sa=X&ved=0ahUKEwia1Z_CtZ7bAhWEBiwKHSdoDwoQ_AUICigB&biw=1920&bih=1014#imgrc=i-BuPkCIo9gHjM:"));

        membres = db.FindAllStagiaire();

        Resources res = getResources();

        String formation1 = res.getString(R.string.formation1);
        String formation2 = res.getString(R.string.formation2);
        String formation3 = res.getString(R.string.formation3);
        String formation4 = res.getString(R.string.formation4);
        String formation5 = res.getString(R.string.formation5);


        db.InsertGroupe(new Groupe(0, "2018, 05, 25", formation1, membres));
        db.InsertGroupe(new Groupe(0, "2017, 09, 20", formation2, membres));
        db.InsertGroupe(new Groupe(0, "2018, 01, 15", formation3, membres));
        db.InsertGroupe(new Groupe(0, "2017, 11, 5", formation4, membres));
        db.InsertGroupe(new Groupe(0, "2018, 03, 15", formation5, membres));

        return db.FindAllGroupe();
    }


    public void onCellClicked(View view) {
        TextView textFormation = view.findViewById(R.id.formationGroupe);
        String formation = textFormation.getText().toString();
        Intent udIntent = new Intent(getActivity(), DetailGroupeActivity.class);
        udIntent.putExtra("formation",formation);
        startActivity(udIntent);
    }

}
