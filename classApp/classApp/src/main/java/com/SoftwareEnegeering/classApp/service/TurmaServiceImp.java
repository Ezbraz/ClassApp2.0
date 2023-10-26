package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Turma;
import com.SoftwareEnegeering.classApp.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaServiceImp implements TurmaService{
    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public Turma createTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public List<Turma> getTurmas() {
        return turmaRepository.findAll();
    }
}
