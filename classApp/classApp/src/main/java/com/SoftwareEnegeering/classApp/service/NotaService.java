package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.nota.NotaRequest;
import com.SoftwareEnegeering.classApp.dto.nota.NotaResponse;

import java.util.List;

public interface NotaService {
    List<NotaResponse> getAllNotas();
    NotaResponse createNota(NotaRequest nota);
    NotaResponse updateNota(Integer id, NotaRequest nota);
    void deleteNota(Integer id);
    List<Double> recuperarNotasPorAlunoEDisciplina(Integer alunoId, Integer disciplinaId);
}
