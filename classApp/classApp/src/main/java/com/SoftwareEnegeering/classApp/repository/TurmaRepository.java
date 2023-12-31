package com.SoftwareEnegeering.classApp.repository;

import com.SoftwareEnegeering.classApp.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}
