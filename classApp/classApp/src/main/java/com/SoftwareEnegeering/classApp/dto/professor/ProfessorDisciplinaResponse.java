package com.SoftwareEnegeering.classApp.dto.professor;

import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.entity.Turma;

import java.util.List;
import java.util.stream.Collectors;

public class ProfessorDisciplinaResponse {
    private Integer id;
    private String nome;

    private List<Integer> turmasIds;

    public ProfessorDisciplinaResponse(Professor entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.turmasIds = mapTurmasIds(entity.getTurmas());
    }

    private List<Integer> mapTurmasIds(List<Turma> turmas) {
        if (turmas != null) {
            return turmas.stream()
                    .map(Turma::getId)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
