package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Aluno;

import java.util.List;

public interface AlunoService {
    Aluno createAluno(Aluno aluno);

    List<Aluno> getAlunos();
}
