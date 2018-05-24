    package com.ldnr.evenements;

    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.util.Log;

    import java.util.ArrayList;

    public class DatabaseHelper extends SQLiteOpenHelper {
        public SQLiteDatabase db;
        private static DatabaseHelper sInstance;
        private static final String DATABASE_NAME = "evenement";
        private static final int DATABASE_VERSION = 2;

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

        public int InsertEvenement(Evenement input)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            int id_event;
            ContentValues contentValues = new ContentValues();

            contentValues.put("type", input.getType());
            contentValues.put("lieu", input.getLieu());
            contentValues.put("heure", input.getHeure());
            id_event = (int) db.insert(
                    "Evenement"
                    , null, contentValues);

            for(Stagiaire stag : input.getParticipants())
            {
                ContentValues contentValuesPart = new ContentValues();
                contentValues.put("stagiaire_id", stag.getId());
                contentValues.put("evenement_id", id_event);
            }
            return id_event;
        }

        /**
         * Met a jour un evenement et sa liste de participants
         * @param input L'evenement a mettre a jour (doit contenir l'id)
         * @return
         */
        public boolean updateEvenement(Evenement input)
        {
            ContentValues cv = new ContentValues();
            cv.put("Type",input.getType());
            cv.put("Lieu",input.getLieu());
            cv.put("Heure",input.getHeure());
            db.delete("Participant", "evenement_id = " + input.getId(), null); // On purge la table des participants de cet evenement

            for (Stagiaire stag : input.getParticipants())
            {
                db.insert("Participant", "evenement_id = " + input.getId() + " AND stagiaire_id = " + stag.getId(), null); // On rajoute ceux qui correspondent

            }
            db.update("Evenement", cv, "evenement_id = "+ "'" + input.getId() +"'", null ); // On met a jour l'evenement proprement dit

            return true;
        }

        /**
         * Purge un evenement par ID
         * @param id
         */
        public void deleteEvenement(int id)
        {
            db.delete("Evenement", "evenement_id = " + id, null);
            db.delete("Participant", "evenement_id = " + id, null);
        }

        public void deleteStagiaire(int id)
        {
            db.delete("Stagiaire", "stagiaire_id = " + id, null);

        }
        public Evenement FindEvenement(int id)
        {
            SQLiteDatabase db = this.getReadableDatabase();
           Evenement event = new Evenement();
           ArrayList<Stagiaire> liste = new ArrayList<Stagiaire>();
            Cursor result = db.rawQuery("select * from " +
                    "Evenement" + " WHERE evenement_id = " + id  , null);

            if (result.moveToFirst()) {


                event.setId(result.getInt(result.getColumnIndex("evenement_id")));
                event.setLieu(result.getString(result.getColumnIndex("lieu")));
                event.setType(result.getString(result.getColumnIndex("type")));
                event.setHeure(result.getString(result.getColumnIndex("heure")));
                Cursor result2 = db.rawQuery("select * from " +
                        "Participation" + " WHERE evenement_id = " + id  , null);
                while (result2.moveToNext())
                {

                    liste.add(FindStagiaire(result2.getInt(result.getColumnIndex("stagiaire_id"))));

            }
            event.setParticipants(liste);
            }
            return event;
        }
        public ArrayList<Evenement> FindAllEvenement()
        {
            ArrayList<Evenement> liste = new ArrayList<>();
            Cursor result = db.rawQuery("select evenement_id from " +
                    "Evenement", null);
            while (result.moveToNext())
            {
                liste.add(FindEvenement(result.getInt(result.getColumnIndex("evenement_id"))));
            }
            return liste;
        }


        public ArrayList<Stagiaire> FindAllStagiaire()
        {
            SQLiteDatabase db = this.getReadableDatabase();
            Stagiaire stag = new Stagiaire();
            ArrayList<Stagiaire> liste = new ArrayList<Stagiaire>();
            Cursor result = db.rawQuery("select * from " +
                    "Stagiaire"  , null);
            while (result.moveToNext()) {

                stag.setNom(result.getString(result.getColumnIndex("nom")));
                stag.setId(result.getInt(result.getColumnIndex("stagiaire_id")));
                stag.setFormation(result.getString(result.getColumnIndex("formation")));
                stag.setMail(result.getString(result.getColumnIndex("mail")));
                stag.setSession(result.getString(result.getColumnIndex("session")));
                stag.setUrl(result.getString(result.getColumnIndex("url")));
                stag.setId_groupe(result.getInt(result.getColumnIndex("id_groupe")));
            liste.add(stag);
            }
            return liste;
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
        stag.setId_groupe(result.getInt(result.getColumnIndex("groupe_id")));

    }
         return stag;
        }


        /**
         * Assigne un groupe existant a un stagiaire, ou crée le groupe
         * @param session La session a laquelle appartient le stagiaire
         * @param formation La formation que suit le stagiaire
         * @return l'id du groupe auquel le stagiaire appartient
         */
        public int FindIdGroupe(String session, String formation) {
            SQLiteDatabase db = this.getReadableDatabase();
            Groupe groupe= new Groupe();
            Cursor result = db.rawQuery("select * from Groupe WHERE session = ? AND  formation = ?",new String[]{session,formation});
            if (result.moveToFirst()) {

return result.getInt(result.getColumnIndex("groupe_id"));

            }
            else
            {
                groupe.setFormation(formation);
                groupe.setSession(session);
            return (int)InsertGroupe(groupe);
            }

        }

        /**
         * Trouve un bean groupe par son id
         * @param id l'id du groupe
         * @return un bean groupe correspondant à l'id du groupe
         */
        public Groupe FindGroupe(int id) {
            SQLiteDatabase db = this.getReadableDatabase();
            Groupe groupe= new Groupe();
            ArrayList<Stagiaire> liste = new ArrayList<Stagiaire>();
            Cursor result = db.rawQuery("select * from " +
                    "Groupe" + " WHERE groupe_id = " + id + ""  , null);
            if (result.moveToFirst()) {

                groupe.setId(result.getInt(result.getColumnIndex("groupe_id")));
                groupe.setFormation(result.getString(result.getColumnIndex("formation")));
                groupe.setSession(result.getString(result.getColumnIndex("session")));
                Cursor result2 = db.rawQuery("select stagiaire_id from " +
                        "Stagiaire" + " WHERE groupe_id = ?"  , new String[]{Integer.toString(id)});
                while (result2.moveToNext())
                {
                   int id_stag = result2.getInt(result2.getColumnIndex("stagiaire_id"));
                    liste.add(FindStagiaire(id_stag));
                }
                groupe.setMembres(liste);
            }
            return groupe;
        }
        public long InsertGroupe(Groupe input) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put("session", input.getSession());
            contentValues.put("formation", input.getFormation());

           return  db.insert(
                    "Groupe"
                    , null, contentValues);
        }

        public void InsertStagiaire(Stagiaire input) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("nom", input.getNom());
            contentValues.put("session", input.getSession());
            contentValues.put("formation", input.getFormation());
            contentValues.put("mail", input.getMail());
            contentValues.put("url", input.getUrl());
            contentValues.put("groupe_id", FindIdGroupe(input.getSession(), input.getFormation()));
            db.insert(
                    "Stagiaire"
                    , null, contentValues);
        }
        public boolean updateStagiaire(Stagiaire input)
        {
            ContentValues cv = new ContentValues();
            cv.put("nom",input.getNom());
            cv.put("session",input.getSession());
            cv.put("formation",input.getFormation());
            cv.put("mail",input.getMail());
            cv.put("url",input.getUrl());
            db.update("Stagiaire", cv, "stagiaire_id = "+ "'" + input.getId() +"'", null );
            return true;
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
            Log.d("Pouet", "creation db");
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
                            "text, " +
                            "telephone " +
                            "text, " +
                             "groupe_id " +
                            "integer," +
                            "mail " +
                            "text, "+
                            "url " +
                            "text, "+
                          " FOREIGN KEY " + "(" + "groupe_id" + ")" +
                            " REFERENCES " + "Groupe" + "(" + "groupe_id" + ") "
                            + " ) "
            );

            db.execSQL(
                    "create table " +
                            "Groupe"
                            + " ( " +
                            "groupe_id "
                            + "integer primary key, " +
                            " formation " +
                            "text, " +
                            " session " +
                            "text " +

                            " ) "
            );
            db.execSQL(
                    "create table " +
                            "Evenement"
                            + " ( " +
                            "evenement_id "
                            + "integer primary key, " +
                            "type " +
                            "text, " +
                            "lieu " +
                            "text, " +
                            "heure " +
                            "text" +

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