package com.back.stage.Services;

import com.back.stage.Entities.Suivi;

import java.util.List;

public interface ISuivi {

    List<Suivi> getAll();
    Suivi add(Suivi s);
    Suivi modify(Suivi s);
}
