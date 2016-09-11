package com.push_it.isi.push_it.entities;

/**
 * Created by Nickerson on 9/6/2016.
 */
public class Challenge {
    private String titre;
    private String description;

    public Challenge(String titre, String description) {
        this.setTitre(titre);
        this.setDescription(description);
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
