package com.ldnr.evenements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EvenementFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public EvenementFragment() {
        // Required empty public constructor
    }

    public static  EvenementFragment newInstance(){

        //Create new fragment
        EvenementFragment frag = new EvenementFragment();

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_evenement, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager =  new LinearLayoutManager(getActivity());

        //Getting device orientation
        int displayMode = getResources().getConfiguration().orientation;

        //Changes depending on orientation
        if (displayMode == 1){
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        }
        createListElements();

        recyclerView.setAdapter(new EvenementRecyclerviewAdapter(createListElements()));

        return view;
    }

    public ArrayList<Evenement> createListElements(){
        DatabaseHelper db = DatabaseHelper.getInstance(getContext());

        db.InsertStagiaire(new Stagiaire(0,"Bernard", "JAVA EE", "2017-2018", "0703390708", "jean@gmail.com", "https://disney-planet.fr/wp-content/uploads/2015/09/bernard-personnage-aventure-bernard-bianca-04.jpg"));
        db.InsertStagiaire(new Stagiaire(0,"Bianca", "JAVA EE", "2017-2018", "0637065508", "jean@gmail.com", "https://www.google.fr/search?q=bernard+et+bianca&source=lnms&tbm=isch&sa=X&ved=0ahUKEwia1Z_CtZ7bAhWEBiwKHSdoDwoQ_AUICigB&biw=1920&bih=1014#imgrc=i-BuPkCIo9gHjM:"));

        db.InsertEvenement(new Evenement(1,"type", "lieu", db.FindAllStagiaire(), "heure"));

        return db.FindAllEvenement();
    }

}

