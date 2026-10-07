package com.unifacisa.academia.repositories;

import com.unifacisa.academia.entities.Planos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlanosRepository extends JpaRepository<Planos, Integer> {
}
