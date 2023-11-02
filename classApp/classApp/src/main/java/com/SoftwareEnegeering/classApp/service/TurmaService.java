package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.turma.TurmaRequest;
import com.SoftwareEnegeering.classApp.dto.turma.TurmaResponse;

import java.util.List;

public interface TurmaService {
    TurmaResponse createTurma(TurmaRequest turma);

    List<TurmaResponse> getTurmas();

    TurmaResponse updateTurma(Integer id, TurmaRequest dto);

    void deleteTurma(Integer id);
}
