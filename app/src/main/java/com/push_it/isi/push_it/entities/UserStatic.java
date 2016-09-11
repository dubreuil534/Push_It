package com.push_it.isi.push_it.entities;

/**
 * Created by DominicDubreuil on 16-09-09.
 */
public  class UserStatic {

    public static Usager usagerEnCour;
    static int nbPushUp;
    static String pseudo;

    public UserStatic() {
    }

    public static String getPseudo() {
        return pseudo;
    }

    public static void setPseudo(String pseudo) {
        UserStatic.pseudo = pseudo;
    }

    public static int getNbPushUp() {
        return nbPushUp;
    }

    public static void setNbPushUp(int nbPushUp) {
        UserStatic.nbPushUp = nbPushUp;
    }
}


