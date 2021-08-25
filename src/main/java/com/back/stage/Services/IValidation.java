package com.back.stage.Services;

import com.back.stage.Entities.Validation;

import java.util.Optional;

public interface IValidation {


    Optional<Validation> getValforEn(int id);
    Validation AddValforEt(long idEt , String presentation, String rapport, String travail);
    Validation AddValforEn(long idEn, float note , boolean valider);
    Validation AddEnAnother(int idv,long idEn, float note, boolean valider);
}
