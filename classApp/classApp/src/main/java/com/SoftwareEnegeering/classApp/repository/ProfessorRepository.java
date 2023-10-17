package com.SoftwareEnegeering.classApp.repository;

import com.SoftwareEnegeering.classApp.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<Professor,UUID> {
}
