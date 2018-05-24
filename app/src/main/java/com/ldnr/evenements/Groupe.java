package com.ldnr.evenements;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Groupe {




    private int id;
    private String session;
    private String formation;



    private ArrayList<Stagiaire> membres;

    public Groupe(int id, String session, String formation, ArrayList<Stagiaire> membres) {
        this.id = id;
        this.session = session;
        this.formation = formation;
        this.membres = membres;
    }
    public Groupe()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
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

    public void setMembres(ArrayList<Stagiaire> membres) {
        this.membres = membres;
    }
}
