package com.ldnr.evenements;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DetailGroupeViewHolder extends RecyclerView.ViewHolder{
    View view;
    //private TextView nom;


    // Here itemView is referring to one CardView
    public DetailGroupeViewHolder(View itemView) {
super(itemView);
      //  View superview = itemView.findViewById(android.R.id.content);
    view = itemView;

    }

    // Function that allows to bind an Object 'Groupe' to a CardView
    public void bind(Stagiaire stagiaire){
      TextView nom = view.findViewById(R.id.nomGroupe);
       TextView mail = view.findViewById(R.id.mailGroupe);
     //  nom.setText("Pouet");
        nom.setText(stagiaire.getNom());
        if (stagiaire.getMail() != null) {
            mail.setText(stagiaire.getMail());
        }
            else
            {
                mail.setText("Inconnu");
            }
    }
}