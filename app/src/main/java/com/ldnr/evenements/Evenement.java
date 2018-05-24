package com.ldnr.evenements;

import java.util.GregorianCalendar;
import java.util.List;

public class Evenement{

    private int id;

    private String type;

    private String lieu;

    private List<Stagiaire> participants;

    private GregorianCalendar date;


    public Evenement(int id, String type, String lieu, List<Stagiaire> participants, GregorianCalendar date) {
        this.id = id;
        this.type = type;
        this.lieu = lieu;
        this.participants = participants;
        this.date = date;
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

    public GregorianCalendar getDate() { return date; }

    public void setDate(GregorianCalendar date) { this.date = date; }

}

