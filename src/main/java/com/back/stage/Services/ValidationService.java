package com.back.stage.Services;


import com.back.stage.Entities.Enseignant;
import com.back.stage.Entities.Etudiant;
import com.back.stage.Entities.Validation;
import com.back.stage.Repositories.EnseignantRepository;
import com.back.stage.Repositories.EtudiantRepository;
import com.back.stage.Repositories.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService implements IValidation{

    @Autowired
    ValidationRepository ValRep;
    @Autowired
    EtudiantRepository EtRep;
    @Autowired
    EnseignantRepository EnRep;


    @Override
    public Optional<Validation> getValforEn(int id) {
        return ValRep.findById(id);
    }

    @Override
    public Validation AddValforEt(long idEt, String presentation, String rapport, String travail) {

        Validation val = new Validation();
        val.setPresentation(presentation);
        val.setRapport(rapport);
        val.setTravail(travail);
        Etudiant et = EtRep.findById( idEt).get();
        val.setEtudiantsV(et);

        return ValRep.save(val);
    }

    @Override
    public Validation AddValforEn(long idEn, float note, boolean valider) {

        Validation val = new Validation();
        val.setNote(note);
        val.setValiderF(valider);
        Enseignant en= EnRep.findById((long) idEn).get();
        val.setEnseignant(en);
        return ValRep.save(val);
    }

    @Override
    public Validation AddEnAnother(int idv, long idEn, float note, boolean valider) {
        Validation su =  ValRep.findById(idv).orElse(null);
        su.setNote(note);
        su.setValiderF(valider);
        Enseignant en = EnRep.findById(idEn).get();
        su.setEnseignant(en);

        return ValRep.save(su);
    }
}
