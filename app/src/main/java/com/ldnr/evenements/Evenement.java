package com.ldnr.evenements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evenement {
    private int id;


    private String type;
    private String lieu;
    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    private String heure;
    private ArrayList<Stagiaire> participants;


    public Evenement(int id, String type, String lieu, ArrayList<Stagiaire> participants, String heure) {
        this.id = id;
        this.type = type;
        this.lieu = lieu;
        this.participants = participants;
        this.heure = heure;
    }

    public Evenement()
    { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public List<Stagiaire> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Stagiaire> participants) {
        this.participants = participants;
    }
}