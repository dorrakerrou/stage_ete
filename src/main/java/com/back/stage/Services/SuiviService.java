package com.back.stage.Services;

import com.back.stage.Entities.Suivi;
import com.back.stage.Repositories.SuiviRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SuiviService implements ISuivi{

    @Autowired
    SuiviRepository SuiviRep ;


    @Override
    public List<Suivi> getAll() {
        List<Suivi> suivis = (List<Suivi>) SuiviRep.findAll();
        for(Suivi sub  : suivis ){
            System.out.println("liste des suivis    : " + sub);

        }
        return suivis;
    }

    @Override
    public Suivi add(Suivi s) {
        return SuiviRep.save(s);
    }

    @Override
    public Suivi modify(Suivi s) {

        Suivi sui =SuiviRep.findById(s.getIDs()).orElse(null);
        sui.setTaches(s.getTaches());

        return SuiviRep.save(sui);
    }
}
