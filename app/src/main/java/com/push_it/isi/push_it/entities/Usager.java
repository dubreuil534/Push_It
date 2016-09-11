package com.push_it.isi.push_it.entities;

/**
 * Created by DominicDubreuil on 16-09-04.
 */
 public class  Usager {

    private int id;
    private String email;
    private String pseudo;
    private String mdp;
    private int objectifPush_Up;
    private int c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;


    private String sexe;
    private int nbPush_Up;


    public  Usager() {
    }


    public  Usager(int id, String email, String pseudo, String mdp, int objectifPush_Up, String sexe) {
        this.id = id;
        this.email = email;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.objectifPush_Up = objectifPush_Up;
        this.sexe = sexe;
        this.nbPush_Up = 0;
        this.c1 = 0;
        this.c2 = 0;
        this.c3 = 0;
        this.c4 = 0;
        this.c5 = 0;
        this.c6 = 0;
        this.c7 = 0;
        this.c8 = 0;
        this.c9 = 0;
        this.c10 = 0;


    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }


    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getNbPush_Up() {
        return nbPush_Up;
    }

    public void setNbPush_Up(int nbPush_Up) {
        this.nbPush_Up = nbPush_Up;
    }


    public int getObjectifPush_Up() {
        return objectifPush_Up;
    }

    public void setObjectifPush_Up(int objectifPush_Up) {
        this.objectifPush_Up = objectifPush_Up;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    public int getC3() {
        return c3;
    }

    public void setC3(int c3) {
        this.c3 = c3;
    }

    public int getC4() {
        return c4;
    }

    public void setC4(int c4) {
        this.c4 = c4;
    }

    public int getC5() {
        return c5;
    }

    public void setC5(int c5) {
        this.c5 = c5;
    }

    public int getC6() {
        return c6;
    }

    public void setC6(int c6) {
        this.c6 = c6;
    }

    public int getC7() {
        return c7;
    }

    public void setC7(int c7) {
        this.c7 = c7;
    }

    public int getC8() {
        return c8;
    }

    public void setC8(int c8) {
        this.c8 = c8;
    }

    public int getC9() {
        return c9;
    }

    public void setC9(int c9) {
        this.c9 = c9;
    }

    public int getC10() {
        return c10;
    }

    public void setC10(int c10) {
        this.c10 = c10;
    }
}
