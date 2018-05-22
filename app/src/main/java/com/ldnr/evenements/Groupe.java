package com.ldnr.evenements;

import java.util.Date;
import java.util.List;

public class Groupe {




    private int id;
    private Date session;
    private String formation;



    private List<Stagiaire> membres;

    public Groupe(int id, Date session, String formation, List<Stagiaire> membres) {
        this.id = id;
        this.session = session;
        this.formation = formation;
        this.membres = membres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSession() {
        return session;
    }

    public void setSession(Date session) {
        this.session = session;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public List<Stagiaire> getMembres() {
        return membres;
    }

    public void setMembres(List<Stagiaire> membres) {
        this.membres = membres;
    }
}
