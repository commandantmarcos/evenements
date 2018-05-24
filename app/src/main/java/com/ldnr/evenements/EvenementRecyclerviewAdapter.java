package com.ldnr.evenements;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class EvenementRecyclerviewAdapter extends RecyclerView.Adapter<EvenementViewHolder> {

    List<Evenement> list;

    public EvenementRecyclerviewAdapter(List<Evenement> list) {
        this.list = list;
    }


    // This function allows to create ViewHolders
    @Override
    public EvenementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card, parent, false);

        return new EvenementViewHolder(view);
    }

    // Here we bind the data from 'Evenements' to the CardView
    @Override
    public void onBindViewHolder( EvenementViewHolder holder, int position) {
        Evenement evenement = list.get(position);
        holder.bind(evenement);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
