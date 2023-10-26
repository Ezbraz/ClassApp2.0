package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Professor;

import java.util.List;

public interface ProfessorService {
    Professor createProfessor(Professor professor);

    List<Professor> getAllProfessores();
}
