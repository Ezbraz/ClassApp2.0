package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfessorServiceImp implements ProfessorService{

    @Autowired
    private ProfessorRepository repository;
    @Override
    public Professor saveProf(Professor professor) {
        return repository.save(professor);
    }

    @Override
    public List<Professor> fetchProfList() {
        return repository.findAll();
    }

    @Override
    public Optional<Professor> fechProfById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteProf(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Professor updateProf(UUID id, Professor professor) {
        Professor professorTemp = repository.findById(id).get();
        if(Objects.nonNull(professor.getNome()) && !"".equals(professor.getNome())){
            professorTemp.setNome(professor.getNome());
        }
        if(Objects.nonNull(professor.getEmail()) && !"".equals(professor.getEmail())){
            professorTemp.setEmail(professor.getEmail());
        }
        if(Objects.nonNull(professor.getRegistro()) && !"".equals(professor.getRegistro())){
            professorTemp.setRegistro(professor.getRegistro());
        }
        professorTemp.setAtivo(professor.isAtivo());
        return repository.save(professorTemp);
    }
}
