package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Disciplina;
import com.SoftwareEnegeering.classApp.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaServiceImp implements DisciplinaService{

    @Autowired
    private DisciplinaRepository disc_repository;
    @Override
    public Disciplina createDisciplina(Disciplina disciplina) {
        return disc_repository.save(disciplina);
    }
    @Override
    public List<Disciplina> getAllDisciplinas() {
        return disc_repository.findAll();
    }
}
