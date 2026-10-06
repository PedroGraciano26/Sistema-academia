package com.unifacisa.academia.repositories;

import com.unifacisa.academia.entities.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos,Integer> {
}
