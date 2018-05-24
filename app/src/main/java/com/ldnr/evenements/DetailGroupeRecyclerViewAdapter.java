package com.ldnr.evenements;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class DetailGroupeRecyclerViewAdapter extends RecyclerView.Adapter<DetailGroupeViewHolder> {

    List<Stagiaire> list;
    Context context;
    DatabaseHelper db;

    public DetailGroupeRecyclerViewAdapter(List<Stagiaire> list) {
        this.list = list;
    }

    // This function allows to create ViewHolders
    @Override
    public DetailGroupeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_details_groupe, parent, false);

        return new DetailGroupeViewHolder(view);

    }

    // Here we bind the data from 'Stagiaire' to the CardView
    @Override
    public void onBindViewHolder( DetailGroupeViewHolder holder, int position) {
        Stagiaire stagiaire = list.get(position);
        holder.bind(stagiaire);
        Log.d("Ajoute", "ON AJOUTE UN STAGIAIRE");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}

