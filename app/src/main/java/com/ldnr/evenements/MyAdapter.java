package com.ldnr.evenements;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<Groupe> groupeList;

    public MyAdapter(List<Groupe> groupeList) {
        this.groupeList = groupeList;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_event,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Groupe groupe = groupeList.get(position);
        holder.bind(groupe);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
