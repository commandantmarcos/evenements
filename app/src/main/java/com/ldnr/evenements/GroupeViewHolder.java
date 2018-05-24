package com.ldnr.evenements;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class GroupeViewHolder extends RecyclerView.ViewHolder{

    private TextView session;
    private TextView formation;
    private TextView membres;

    // Here itemView is referring to one CardView
    public GroupeViewHolder(View itemView) {
        super(itemView);

        session = itemView.findViewById(R.id.sessionGroupe);
        membres = itemView.findViewById(R.id.membresGroupe);
        formation = itemView.findViewById(R.id.formationGroupe);
    }

    // Function that allows to bind an Object 'Groupe' to a CardView
    public void bind(Groupe groupe){

        String nbr_membres = Integer.toString(groupe.getMembres().size());
        session.setText(groupe.getSession().toString());
        formation.setText(groupe.getFormation().toString());
        membres.setText(nbr_membres+" Participants");

    }
}
