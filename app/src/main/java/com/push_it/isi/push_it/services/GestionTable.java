package com.push_it.isi.push_it.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class GestionTable extends SQLiteOpenHelper {

    public static String USER_ID = "id";
    public static String USER_EMAil = "email";
    public static String USER_PSEUDO = "pseudo";
    public static String USER_MDP = "mdp";
    public static String USER_OBJECTIF = "objectif";
    public static String USER_SEXE = "sexe";
    public static String USER_NB_PUSH_UP = "nbPushUp";
    public static String USER_C1 = "c1";
    public static String USER_C2 = "c2";
    public static String USER_C3 = "c3";
    public static String USER_C4 = "c4";
    public static String USER_C5 = "c5";
    public static String USER_C6 = "c6";
    public static String USER_C7 = "c7";
    public static String USER_C8 = "c8";
    public static String USER_C9 = "c9";
    public static String USER_C10 = "c10";
    public static String USER_NOM_TABLE = "userTab3";


    public static String CREATE_TABLE_USER = "CREATE TABLE " + USER_NOM_TABLE + " (" +
            USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            USER_EMAil + " TEXT, " +
            USER_PSEUDO + " TEXT, " +
            USER_MDP + " TEXT," +
            USER_OBJECTIF + " INTERGER, " +
            USER_SEXE + " TEXT, "+
            USER_NB_PUSH_UP + " INTERGER, "+
            USER_C1 +" INTERGER, " +
            USER_C2 +" INTERGER, " +
            USER_C3 +" INTERGER, " +
            USER_C4 +" INTERGER, " +
            USER_C5 +" INTERGER, " +
            USER_C6 +" INTERGER, " +
            USER_C7 +" INTERGER, " +
            USER_C8 +" INTERGER, " +
            USER_C9 +" INTERGER, " +
            USER_C10 +" INTERGER)";

    public static String DROP_TABLE_USER = "DROP TABLE IF EXISTS " + USER_NOM_TABLE;


    public GestionTable(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL(DROP_TABLE_USER);
        onCreate(bd);
    }
}
