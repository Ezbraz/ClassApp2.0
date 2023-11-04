package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.professor.ProfessorNome;
import com.SoftwareEnegeering.classApp.dto.professor.ProfessorRequest;
import com.SoftwareEnegeering.classApp.dto.professor.ProfessorResponse;

import java.util.List;

public interface ProfessorService {
    ProfessorResponse createProfessor(ProfessorRequest professor);

    List<ProfessorResponse> getAllProfessores();

    void deleteProfessor(Integer id);

    List<ProfessorNome> getNomesProfessores();

    ProfessorResponse updateProfessor(Integer id, ProfessorRequest dto);
}
