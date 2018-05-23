package com.ldnr.evenements;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EvenementFragment extends Fragment {

    private static final String KEY_COLOR = "color";

    public EvenementFragment() {
        // Required empty public constructor
    }

    public static  EvenementFragment newInstance(String stringColor){

        //Create new fragment
        EvenementFragment frag = new EvenementFragment();

        int color = Color.parseColor(stringColor);

        //Create Bundle and add data
        Bundle args = new Bundle();
        args.putInt(KEY_COLOR, color);

        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_evenement, container, false);

        // Getting Widgets drom layout
        FrameLayout rootView = view.findViewById(R.id.rootview);
        TextView textView = view.findViewById(R.id.textview);

        // Getting data from Bundle
        int lightColor = Color.parseColor("#FFF5EE");
        int color = getArguments().getInt(KEY_COLOR, -1);

        // Update Widgets with given data
        rootView.setBackgroundColor(color);
        textView.setBackgroundColor(lightColor);

        return view;
    }

}
