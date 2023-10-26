package com.SoftwareEnegeering.classApp.repository;

import com.SoftwareEnegeering.classApp.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
