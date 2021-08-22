package com.back.stage.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@DiscriminatorValue("En")
public class Enseignant extends Personne implements Serializable {


    private float salaire;
    private String module_enseigne;

    @OneToMany(mappedBy = "enseignants")
    private List<Suivi> suivi ;



    public Enseignant(float salaire, String module_enseigne) {
        this.salaire = salaire;
        this.module_enseigne = module_enseigne;
    }

    public Enseignant(Long ID, String nom, String prenom, String email, String identifiant, String cin, String numTel) {
        super(ID, nom, prenom, email, identifiant, cin, numTel);
    }

    public Enseignant() {

    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public String getModule_enseigne() {
        return module_enseigne;
    }

    public void setModule_enseigne(String module_enseigne) {
        this.module_enseigne = module_enseigne;
    }
}
