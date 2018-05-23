//package com.ldnr.evenements;

//import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.view.ViewPager;

//import java.sql.Timestamp;
//import java.util.List;

//public class Evenement extends FragmentActivity{

//    private int id;

//    private String type;

//    private String lieu;

//    private Timestamp date;

//    private List<Stagiaire> participants;

//    EvenementAdapter evenementAdapter;
//    ViewPager viewPager;

//    @Override
//    protected void onCreate(Bundle davedInstanceState) {

//        super.onCreate(davedInstanceState);
//        setContentView(R.layout.activity_evenement);

//        evenementAdapter = new EvenementAdapter(getSupportFragmentManager());

//        viewPager = findViewById(R.id.pager);
//        viewPager.setAdapter(evenementAdapter);

//    }

//    public Evenement(int id, String type, String lieu, List<Stagiaire> participants) {
//        this.id = id;
//        this.type = type;
//        this.lieu = lieu;
//        this.participants = participants;
//    }

//    public int getId() {
//        return id;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

//    public String getType() {
//        return type;
//    }

//    public void setType(String type) {
//        this.type = type;
//    }

//    public String getLieu() {
//        return lieu;
//    }

//    public void setLieu(String lieu) {
//        this.lieu = lieu;
//    }

//    public List<Stagiaire> getParticipants() {
//        return participants;
//    }

//    public void setParticipants(List<Stagiaire> participants) {
//        this.participants = participants;
//    }

//    public Timestamp getDate() { return date; }

//    public void setDate(Timestamp date) { this.date = date; }

//}
