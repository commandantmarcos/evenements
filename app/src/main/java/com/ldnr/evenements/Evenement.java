package com.ldnr.evenements;

import java.util.List;

public class Evenement {
    private int id;


    private String type;
    private String lieu;

    private List<Stagiaire> participants;


    public Evenement(int id, String type, String lieu, List<Stagiaire> participants) {
        this.id = id;
        this.type = type;
        this.lieu = lieu;
        this.participants = participants;
    }

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

    public void setParticipants(List<Stagiaire> participants) {
        this.participants = participants;
    }
}
