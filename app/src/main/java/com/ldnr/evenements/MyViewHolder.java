package com.ldnr.evenements;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView formationGroupView;
    private TextView sessionGroupView;

    public MyViewHolder(View itemView) {
        super(itemView);
        formationGroupView = (TextView) itemView.findViewById(R.id.group_view);
        sessionGroupView = (TextView) itemView.findViewById(R.id.sessionView);
    }

    public void bind(Groupe myGroup){
        formationGroupView.setText(myGroup.getFormation());
        sessionGroupView.setText(myGroup.getSession());

    }
}
