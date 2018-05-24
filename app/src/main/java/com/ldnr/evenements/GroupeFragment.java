package com.ldnr.evenements;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupeFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Resources res;

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

        recyclerView = view.findViewById(R.id.recyclerViewGroupe);
        layoutManager =  new LinearLayoutManager(getActivity());

        //Getting device orientation
        int displayMode = getResources().getConfiguration().orientation;

        //Changes depending on orientation
        if (displayMode == 1){
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        }

        List<Groupe> groupe = createListGroupes();
        recyclerView.setAdapter(new GroupeRecyclerViewAdapter(groupe));

        return view;
    }

    public List<Groupe> createListGroupes(){

        ArrayList<Stagiaire> membres = new ArrayList<>();
        membres.add(new Stagiaire(0,"Jean", "JAVA EE", "2017-2018", "0707070708", "jean@gmail.com", "https://disney-planet.fr/wp-content/uploads/2015/09/bernard-personnage-aventure-bernard-bianca-04.jpg"));
        membres.add(new Stagiaire(0,"Jean", "JAVA EE", "2017-2018", "0707070708", "jean@gmail.com", "https://disney-planet.fr/wp-content/uploads/2015/09/bernard-personnage-aventure-bernard-bianca-04.jpg"));

        List<Groupe> groupes = new ArrayList<>();

        res = getResources();

        String formation1 = res.getString(R.string.formation1);
        String formation2 = res.getString(R.string.formation2);
        String formation3 = res.getString(R.string.formation3);
        String formation4 = res.getString(R.string.formation4);
        String formation5 = res.getString(R.string.formation5);

        groupes.add(new Groupe(0, "2018, 05, 25", formation1, membres));
        groupes.add(new Groupe(0, "2017, 09, 20", formation2, membres));
        groupes.add(new Groupe(0, "2018, 01, 15", formation3, membres));
        groupes.add(new Groupe(0, "2017, 11, 5", formation4, membres));
        groupes.add(new Groupe(0, "2018, 03, 15", formation5, membres));
        return  groupes;
    }

}
