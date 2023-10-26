package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImp implements AlunoService{

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }
}
