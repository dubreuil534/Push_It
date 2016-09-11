package com.push_it.isi.push_it.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class ConnexionBD {

    private static SQLiteDatabase bd = null;
    private static int version = 1;
    private static String nomBd = "tabUser3";

    public static SQLiteDatabase getBaseDonne(Context ctx) {
        GestionTable gt = new GestionTable(ctx, nomBd, null, version);
        bd = gt.getWritableDatabase();
        return bd;
    }

    public static void closeBD() {
        bd.close();
    }


}
