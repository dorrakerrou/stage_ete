package com.back.stage.Repositories;

import com.back.stage.Entities.Suivi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuiviRepository extends JpaRepository<Suivi, Integer> {
}
