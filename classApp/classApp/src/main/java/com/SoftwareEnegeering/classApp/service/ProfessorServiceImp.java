package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImp implements ProfessorService{

    @Autowired
    private ProfessorRepository prof_repository;
    @Override
    public Professor createProfessor(Professor professor) {
        return prof_repository.save(professor);
    }

    @Override
    public List<Professor> getAllProfessores() {
        return prof_repository.findAll();
    }
}
