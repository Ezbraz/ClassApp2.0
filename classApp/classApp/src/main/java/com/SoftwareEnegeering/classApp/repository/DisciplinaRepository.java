package com.SoftwareEnegeering.classApp.repository;

import com.SoftwareEnegeering.classApp.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, UUID> {

}
