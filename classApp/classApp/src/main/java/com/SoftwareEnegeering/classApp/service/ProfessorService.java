package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Professor;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfessorService {
    public Professor saveProf(Professor professor);

    public List<Professor> fetchProfList();

    public Optional<Professor> fechProfById(UUID id);

    public void deleteProf(UUID id);

    public Professor updateProf(UUID id, Professor professor);
}
