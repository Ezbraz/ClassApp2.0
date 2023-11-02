package com.SoftwareEnegeering.classApp.repository;

import com.SoftwareEnegeering.classApp.dto.professor.ProfessorNome;
import com.SoftwareEnegeering.classApp.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Query("SELECT new com.SoftwareEnegeering.classApp.dto.professor.ProfessorNome(a.id, a.nome) FROM Professor a")
    List<ProfessorNome> findNamesAndIds();
}
