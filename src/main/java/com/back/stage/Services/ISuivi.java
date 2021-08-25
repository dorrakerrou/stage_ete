package com.back.stage.Services;

import com.back.stage.Entities.Suivi;

import java.util.List;
import java.util.Optional;

public interface ISuivi {

    List<Suivi> getAll();
    Suivi addEt(String nom_equipe , String taches, long idEt);
    Suivi modify(Suivi s);
    Suivi AddEn(String Remarque, boolean valider, long idEn);
    Optional<Suivi> getSuivForEn(long id);
    Suivi AnotherOne(int id,String Remarque, boolean valider, long idEn);
}
