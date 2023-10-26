package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Disciplina;
import com.SoftwareEnegeering.classApp.entity.Professor;

import java.util.List;

public interface DisciplinaService {
    Disciplina createDisciplina(Disciplina disciplina);

    List<Disciplina> getAllDisciplinas();
}
