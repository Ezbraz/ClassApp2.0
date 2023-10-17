package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Disciplina;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DisciplinaService {

    Disciplina saveDisc(Disciplina disciplina);

    List<Disciplina> fetchDiscList();

    Optional<Disciplina> fechDiscById(UUID id);

    void deleteDisc(UUID id);

    Disciplina updateDisc(UUID id, Disciplina disciplina);
}
