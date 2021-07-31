package com.back.stage.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@DiscriminatorValue("Et")
public class Etudiant extends Personne implements Serializable {



    private String specialite;

    @OneToMany(mappedBy = "etudiants")
    private List<Suivi> suivi ;

    @OneToMany(mappedBy = "etudiantsV")
    private List<Validation> Vals ;


    public Etudiant(String specialite) {
        this.specialite = specialite;
    }

    public Etudiant() {
    }

    public Etudiant(Long ID, String nom, String prenom, String email, String identifiant, String cin, String numTel) {
        super(ID, nom, prenom, email, identifiant, cin, numTel);
    }



    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
