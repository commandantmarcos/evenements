package com.ldnr.evenements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        List<Evenement> evenements = createListElements();
        recyclerView.setAdapter(new EvenementRecyclerviewAdapter(evenements));

        return view;
    }

    public List<Evenement> createListElements(){

        List<Stagiaire> participants = new ArrayList<>();
        participants.add(new Stagiaire(0,"Jean", "JAVA EE", new Date(2018, 05,15), "0707070708", "jean@gmail.com", "https://disney-planet.fr/wp-content/uploads/2015/09/bernard-personnage-aventure-bernard-bianca-04.jpg"));
        participants.add(new Stagiaire(0,"Jean", "JAVA EE", new Date(2018, 05,15), "0707070708", "jean@gmail.com", "https://disney-planet.fr/wp-content/uploads/2015/09/bernard-personnage-aventure-bernard-bianca-04.jpg"));

        List<Evenement> evenements = new ArrayList<>();

        GregorianCalendar date = new GregorianCalendar();
        date.set(2018, 05, 25);
        evenements.add(new Evenement(0,"Repas","LDNR", participants, date));
        evenements.add(new Evenement(0,"Fete1","LDNR", participants, date));
        evenements.add(new Evenement(0,"Fete2","LDNR", participants, date));
        evenements.add(new Evenement(0,"Fete3","LDNR", participants, date));
        evenements.add(new Evenement(0,"Fete4","LDNR", participants, date));

        return  evenements;
    }

}

