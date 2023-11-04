package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.disciplina.DisciplinaRequest;
import com.SoftwareEnegeering.classApp.dto.disciplina.DisciplinaResponse;
import com.SoftwareEnegeering.classApp.entity.Disciplina;

import java.util.List;

public interface DisciplinaService {
    DisciplinaResponse createDisciplina(DisciplinaRequest disciplina);

    List<DisciplinaResponse> getAllDisciplinas();

    DisciplinaResponse update(Integer id, DisciplinaRequest dto);

    void delete(Integer id);
}
