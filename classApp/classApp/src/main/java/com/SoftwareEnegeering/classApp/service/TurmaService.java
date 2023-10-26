package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Turma;

import java.util.List;

public interface TurmaService {
    Turma createTurma(Turma turma);

    List<Turma> getTurmas();
}
