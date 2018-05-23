package com.ldnr.evenements;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView titleGroupView;

    public MyViewHolder(View itemView) {
        super(itemView);
        titleGroupView = (TextView) itemView.findViewById(R.id.group_view);
    }

    public void bind(Groupe myGroup){
        titleGroupView.setText(myGroup.getFormation());

    }
}
