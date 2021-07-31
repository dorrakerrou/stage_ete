package com.back.stage.Repositories;

import com.back.stage.Entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonneRepository extends JpaRepository<Personne,Long> {


    Optional<Personne> findByIdentifiant(String identifiant);

    Boolean existsByIdentifiant(String identifiant);

    Boolean existsByEmail(String email);
}
