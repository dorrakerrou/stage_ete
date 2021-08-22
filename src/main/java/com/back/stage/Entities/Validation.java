package com.back.stage.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Validation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IDv ;

    private String Presentation;

    private String rapport;

    private String travail;

    private float note;

    private boolean validerF;

    @ManyToOne
    @JoinColumn(name = "IDet")
    private Etudiant etudiantsV ;

    @OneToOne
    private Enseignant enseignant;

    public Validation(int iDv, String presentation, String rapport, String travail, float note, boolean validerF) {
        IDv = iDv;
        Presentation = presentation;
        this.rapport = rapport;
        this.travail = travail;
        this.note = note;
        this.validerF = validerF;
    }

    public Validation() {

    }

    public int getIDv() {
        return IDv;
    }

    public void setIDv(int IDv) {
        this.IDv = IDv;
    }

    public String getPresentation() {
        return Presentation;
    }

    public void setPresentation(String presentation) {
        Presentation = presentation;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public String getTravail() {
        return travail;
    }

    public void setTravail(String travail) {
        this.travail = travail;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public boolean isValiderF() {
        return validerF;
    }

    public void setValiderF(boolean validerF) {
        this.validerF = validerF;
    }
}
