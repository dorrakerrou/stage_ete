package com.back.stage.Repositories;

import com.back.stage.Entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PersonneRepository extends JpaRepository<Personne,Long> {


    Optional<Personne> findByIdentifiant(String identifiant);

    Boolean existsByIdentifiant(String identifiant);

    Boolean existsByEmail(String email);
}
