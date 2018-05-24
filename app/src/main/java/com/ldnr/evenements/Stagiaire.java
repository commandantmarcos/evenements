package com.ldnr.evenements;

import java.util.Date;

public class Stagiaire {
    private int id;
    private String nom;
    private String formation;
    private String session;
    private String telephone;
    private String mail;
    private String url;
    private int id_groupe;



    public Stagiaire(int id, String nom, String formation, String session, String telephone, String mail, String url) {
        this.id = id;
        this.nom = nom;
        this.formation = formation;
        this.session = session;
        this.telephone = telephone;
        this.mail = mail;
        this.url = url;
    }
    public Stagiaire()
    {

    }
    public int getId_groupe() {
        return id_groupe;
    }

    public void setId_groupe(int id_groupe) {
        this.id_groupe = id_groupe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



}
