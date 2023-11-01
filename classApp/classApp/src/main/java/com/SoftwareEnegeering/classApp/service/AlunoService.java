package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.aluno.AlunoRequest;
import com.SoftwareEnegeering.classApp.dto.aluno.AlunoResponse;
import com.SoftwareEnegeering.classApp.entity.Aluno;

import java.util.List;

public interface AlunoService {
    Aluno createAluno(Aluno aluno);

    List<Aluno> getAlunos();

    AlunoResponse updateAluno(Integer id, AlunoRequest dto);

    void deleteAluno(Integer id);
}
