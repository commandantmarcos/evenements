package com.ldnr.evenements;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    public SQLiteDatabase db;
    private static DatabaseHelper sInstance;

    private static final String DATABASE_NAME = "evenement";
    private static final int DATABASE_VERSION = 1;

    public static synchronized DatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();
    }

    public Stagiaire FindStagiaire(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Stagiaire stag = new Stagiaire();
        Cursor result = db.rawQuery("select * from " +
                "Stagiaire" + " WHERE stagiaire_id = " + id  , null);
if (result.moveToFirst()) {

    stag.setNom(result.getString(result.getColumnIndex("nom")));
    stag.setId(result.getInt(result.getColumnIndex("stagiaire_id")));
    stag.setFormation(result.getString(result.getColumnIndex("formation")));
    stag.setMail(result.getString(result.getColumnIndex("mail")));
    stag.setSession(result.getString(result.getColumnIndex("session")));
    stag.setUrl(result.getString(result.getColumnIndex("url")));


}
     return stag;
    }
    public void InsertStagiaire(Stagiaire input) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nom", input.getNom());
        contentValues.put("session", input.getSession());
        contentValues.put("formation", input.getFormation());
        contentValues.put("mail", input.getMail());
        contentValues.put("url", input.getUrl());
        db.insert(
                "Stagiaire"
                , null, contentValues);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +
                "Stagiaire");
        db.execSQL("DROP TABLE IF EXISTS " +
                "Groupe");
        db.execSQL("DROP TABLE IF EXISTS " +
                "Evenement");
        db.execSQL("DROP TABLE IF EXISTS " +
                "Participation");
        onCreate(db);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " +
                        "Stagiaire"
                        + " ( " +
                        "stagiaire_id"
                        + " integer primary key, " +
                        "nom "
                        + "text, " +
                        " formation " +
                        " text, " +
                        "session " +
                        "string, " +
                        "telephone " +
                        "text, " +
                        "mail " +
                        "text, " +
                        "url " +
                        "text "
                        + " ) "
        );

        db.execSQL(
                "create table " +
                        "Groupe"
                        + " ( " +
                        "groupe_id"
                        + "integer primary key, " +
                        "nom"
                        + "text, " +
                        "formation" +
                        "text, " +
                        "session" +
                        "text " +

                        " ) "
        );
        db.execSQL(
                "create table " +
                        "Evenement"
                        + " ( " +
                        "evenement_id"
                        + "integer primary key, " +
                        "type" +
                        "text, " +
                        "lieu" +
                        "text, " +
                        "heure" +
                        "datetime" +

                        " ) "
        );
        db.execSQL(
                "create table " +
                        "Participation"
                        + " ( " +
                        "participation_id integer primary key,  "+
                        "stagiaire_id integer, " +
                        "evenement_id integer, " +
                        " FOREIGN KEY " + "(" + "stagiaire_id" + ")" +
                        " REFERENCES " + "Stagiaire" + "(" + "stagiaire_id" + "), " +
                        " FOREIGN KEY " + "(" + "evenement_id" + ")" +
                        " REFERENCES " + "Evenement" + "(" + "evenement_id" + ")" +
                        " )"
        );
        //   FOREIGN KEY " + "(" + Practical_ID + ")" +
        //   "REFERENCES" + TABLE_PRACTICAL + "(" + Practical_ID + ")" +

    }
}