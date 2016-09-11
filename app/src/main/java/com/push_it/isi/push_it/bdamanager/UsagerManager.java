package com.push_it.isi.push_it.bdamanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.push_it.isi.push_it.entities.Usager;
import com.push_it.isi.push_it.services.ConnexionBD;
import com.push_it.isi.push_it.services.GestionTable;

import java.util.ArrayList;

/**
 * Created by DominicDubreuil on 16-09-04.
 */
public class UsagerManager {
    private static String queryGetAll = "select * from " + GestionTable.USER_NOM_TABLE;
    private static String querySearchUser = "select * from " + GestionTable.USER_NOM_TABLE + " where  " + GestionTable.USER_PSEUDO + " like ? and " + GestionTable.USER_MDP + " like ?";
    private static String querySearchUserSetting = "select * from " + GestionTable.USER_NOM_TABLE + " where  " + GestionTable.USER_PSEUDO + " like ? ";
    private static String queryDeleteAll = "DROP TABLE IF EXISTS " + GestionTable.USER_NOM_TABLE;


    public static Usager getSearchUser(Usager userToTest, Context ctx) {
        Usager retour = null;
        Cursor c = ConnexionBD.getBaseDonne(ctx).rawQuery(querySearchUser, new String[]{userToTest.getPseudo(), userToTest.getMdp()});

        while (c.moveToNext()) {
            retour = new Usager();
            retour.setId(c.getInt(0));


        }


        return retour;


    }


    public static void update(Usager user, Context ctx) {
        ContentValues value = new ContentValues();
        value.put(GestionTable.USER_NB_PUSH_UP, user.getNbPush_Up());

        SQLiteDatabase bd = ConnexionBD.getBaseDonne(ctx);
        bd.update(GestionTable.USER_NOM_TABLE, value, GestionTable.USER_PSEUDO + " = ? ", new String[]{String.valueOf(user.getPseudo())});
    }


    public static Usager getSearchUserSetting(Usager userToTest, Context ctx) {
        Usager retour = null;
        Cursor c = ConnexionBD.getBaseDonne(ctx).rawQuery(querySearchUserSetting, new String[]{userToTest.getPseudo()});

        while (c.moveToNext()) {
            retour = new Usager();
            retour.setId(c.getInt(0));
            retour.setEmail(c.getString(1));
            retour.setPseudo(c.getString(2));
            retour.setMdp(c.getString(3));
            retour.setObjectifPush_Up(c.getInt(4));
            retour.setSexe(c.getString(5));
            retour.setNbPush_Up(c.getInt(6));


        }


        return retour;


    }


    public static void supTable(Context ctx) {
        Cursor c = ConnexionBD.getBaseDonne(ctx).rawQuery(queryDeleteAll, new String[]{});


    }


    public static long add(Usager user, Context ctx) {
        ContentValues cv = new ContentValues();
        cv.put(GestionTable.USER_EMAil, user.getEmail());
        cv.put(GestionTable.USER_PSEUDO, user.getPseudo());
        cv.put(GestionTable.USER_MDP, user.getMdp());
        cv.put(GestionTable.USER_OBJECTIF, user.getObjectifPush_Up());
        cv.put(GestionTable.USER_SEXE, user.getSexe());
        cv.put(GestionTable.USER_NB_PUSH_UP, user.getNbPush_Up());
        cv.put(GestionTable.USER_C1, user.getC1());
        cv.put(GestionTable.USER_C2, user.getC2());
        cv.put(GestionTable.USER_C3, user.getC3());
        cv.put(GestionTable.USER_C4, user.getC4());
        cv.put(GestionTable.USER_C5, user.getC5());
        cv.put(GestionTable.USER_C6, user.getC6());
        cv.put(GestionTable.USER_C7, user.getC7());
        cv.put(GestionTable.USER_C8, user.getC8());
        cv.put(GestionTable.USER_C9, user.getC9());
        cv.put(GestionTable.USER_C10, user.getC10());


        Log.d("debug", "entrer");

        long id = ConnexionBD.getBaseDonne(ctx).insert(GestionTable.USER_NOM_TABLE, null, cv);
        ConnexionBD.closeBD();
        return id;
    }


    public static ArrayList<Usager> getAll(Context ctx) {
        ArrayList<Usager> retour = new ArrayList<>();

        Cursor c = ConnexionBD.getBaseDonne(ctx).rawQuery(queryGetAll, null);
        while (c.moveToNext()) {
            Usager etu = new Usager();
            etu.setId(c.getInt(0));
            etu.setEmail(c.getString(1));
            etu.setPseudo(c.getString(2));
            etu.setMdp(c.getString(3));
            etu.setNbPush_Up(c.getInt(4));
            etu.setSexe(c.getString(5));
            etu.setNbPush_Up(c.getInt(6));
            etu.setC1(c.getInt(7));
            etu.setC2(c.getInt(8));
            etu.setC3(c.getInt(9));
            etu.setC4(c.getInt(10));
            etu.setC5(c.getInt(11));
            etu.setC6(c.getInt(12));
            etu.setC7(c.getInt(13));
            etu.setC8(c.getInt(14));
            etu.setC9(c.getInt(15));
            etu.setC10(c.getInt(16));
            retour.add(etu);
        }
        return retour;
    }


}
