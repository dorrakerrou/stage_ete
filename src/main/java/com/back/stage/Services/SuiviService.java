package com.back.stage.Services;

import com.back.stage.Entities.Enseignant;
import com.back.stage.Entities.Etudiant;
import com.back.stage.Entities.Suivi;
import com.back.stage.Repositories.EnseignantRepository;
import com.back.stage.Repositories.EtudiantRepository;
import com.back.stage.Repositories.SuiviRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SuiviService implements ISuivi{

    @Autowired
    SuiviRepository SuiviRep ;

    @Autowired
    EnseignantRepository EnRep;

    @Autowired
    EtudiantRepository EtRep;


    @Override
    public List<Suivi> getAll() {
        List<Suivi> suivis = (List<Suivi>) SuiviRep.findAll();
        for(Suivi sub  : suivis ){
            System.out.println("liste des suivis    : " + sub);

        }
        return suivis;
    }

    @Override
    public Suivi addEt(String nom_equipe, String taches, long idEt) {
        Suivi s = new Suivi();
        s.setTaches(taches);
        s.setNom_equipe(nom_equipe);
        Etudiant et = EtRep.findById(idEt).get();
        s.setEtudiants(et);
        return SuiviRep.save(s);
    }


    @Override
    public Suivi modify(Suivi s) {

        Suivi sui =SuiviRep.findById(s.getIDs()).orElse(null);
        sui.setTaches(s.getTaches());

        return SuiviRep.save(sui);
    }


    @Override
    public Suivi AddEn(String Remarque, boolean valider, long idEn) {
        Suivi S = new Suivi();
        S.setRemarque(Remarque);
        S.setValider(valider);
        Enseignant en = EnRep.findById(idEn).get();
        S.setEnseignants(en);

        return SuiviRep.save(S);
    }

    @Override
    public Optional<Suivi> getSuivForEn(long id) {
        return SuiviRep.findById((int) id);
    }

    @Override
    public Suivi AnotherOne(int id, String remarque, boolean valider, long idEn) {
       Suivi su =  SuiviRep.findById(id).orElse(null);
       su.setValider(valider);
       su.setRemarque(remarque);
        Enseignant en = EnRep.findById(idEn).get();
       su.setEnseignants(en);

        return SuiviRep.save(su);
    }
}
