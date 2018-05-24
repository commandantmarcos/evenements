package com.ldnr.evenements;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupeFragment extends Fragment {


    private static final String KEY_COLOR = "color";

    public GroupeFragment() {
        // Required empty public constructor
    }

    public static  GroupeFragment newInstance(){

        //Create new fragment
        GroupeFragment frag = new GroupeFragment();

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_groupe, container, false);

        return view;
    }

}
