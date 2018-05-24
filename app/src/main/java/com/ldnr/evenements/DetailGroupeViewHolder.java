package com.ldnr.evenements;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DetailGroupeViewHolder extends RecyclerView.ViewHolder{

    private TextView nom;
    private TextView mail;

    // Here itemView is referring to one CardView
    public DetailGroupeViewHolder(View itemView) {
super(itemView);
      //  View superview = itemView.findViewById(android.R.id.content);
        nom = itemView.getRootView().findViewById(R.id.nomGroupe);
        mail = itemView.getRootView().findViewById(R.id.sessionGroupe);
    }

    // Function that allows to bind an Object 'Groupe' to a CardView
    public void bind(Stagiaire stagiaire){

       // nom.setText(stagiaire.getNom().toString());
     //   mail.setText(stagiaire.getMail().toString());

    }
}