package com.back.stage.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Suivi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDs;

    private String nom_equipe;

    private String Remarque;

    private String taches;

    private boolean valider;


    @ManyToOne
    @JoinColumn(name = "IDet")
    private Etudiant etudiants ;


    @ManyToOne
    @JoinColumn(name = "IDen")
    private Enseignant enseignants ;

    public Suivi(int iDs, String nom_equipe, String remarque, String taches, boolean valider) {
        IDs = iDs;
        this.nom_equipe = nom_equipe;
        Remarque = remarque;
        this.taches = taches;
        this.valider = valider;
    }

    public Suivi() {
    }

    public int getIDs() {
        return IDs;
    }

    public void setIDs(int IDs) {
        this.IDs = IDs;
    }

    public String getNom_equipe() {
        return nom_equipe;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }

    public String getRemarque() {
        return Remarque;
    }

    public void setRemarque(String remarque) {
        Remarque = remarque;
    }

    public String getTaches() {
        return taches;
    }

    public void setTaches(String taches) {
        this.taches = taches;
    }

    public boolean isValider() {
        return valider;
    }

    public void setValider(boolean valider) {
        this.valider = valider;
    }

    public Enseignant getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Enseignant enseignants) {
        this.enseignants = enseignants;
    }

    public Etudiant getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Etudiant etudiants) {
        this.etudiants = etudiants;
    }
}
