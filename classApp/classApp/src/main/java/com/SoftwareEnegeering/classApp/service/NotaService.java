package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.nota.NotaRequest;
import com.SoftwareEnegeering.classApp.dto.nota.NotaResponse;
import com.SoftwareEnegeering.classApp.dto.nota.NotaUpdateRequest;

import java.util.List;

public interface NotaService {
    List<NotaResponse> getAllNotas();
    NotaResponse createNota(NotaRequest nota);
    NotaResponse updateNota(Integer id, NotaUpdateRequest nota);
    void deleteNota(Integer id);
    List<Double> recuperarNotasPorAlunoEDisciplina(Integer alunoId, Integer disciplinaId);
}
