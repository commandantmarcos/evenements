package com.ldnr.evenements;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class EvenementViewHolder extends RecyclerView.ViewHolder{

    private TextView date;
    private TextView participants;
    private TextView lieu;

    // Here itemView is referring to one CardView
    public EvenementViewHolder(View itemView) {
        super(itemView);

        date = itemView.findViewById(R.id.date);
        participants = itemView.findViewById(R.id.participants);
        lieu = itemView.findViewById(R.id.lieu);
    }

    // Function that allows to bind an Object 'Evenement' to a CardView
    public void bind(Evenement evenement){
        date.setText(evenement.getDate().toString());
        participants.setText("ffffff");
        lieu.setText(evenement.getLieu().toString());
    }
}
