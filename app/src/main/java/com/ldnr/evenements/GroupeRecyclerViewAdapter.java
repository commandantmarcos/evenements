package com.ldnr.evenements;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GroupeRecyclerViewAdapter extends RecyclerView.Adapter<GroupeViewHolder> {

    List<Groupe> list;

    public GroupeRecyclerViewAdapter(List<Groupe> list) {
        this.list = list;
    }


    // This function allows to create ViewHolders
    @Override
    public GroupeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_groupe, parent, false);

        return new GroupeViewHolder(view);
    }

    // Here we bind the data from 'Evenements' to the CardView
    @Override
    public void onBindViewHolder( GroupeViewHolder holder, int position) {
        Groupe groupe = list.get(position);
        holder.bind(groupe);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
