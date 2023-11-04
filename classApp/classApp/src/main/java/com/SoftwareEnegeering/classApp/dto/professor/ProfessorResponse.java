package com.SoftwareEnegeering.classApp.dto.professor;

import com.SoftwareEnegeering.classApp.dto.disciplina.DisciplinaResponse;
import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.entity.Turma;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProfessorResponse {

    private Integer id;
    private String nome;

    private DisciplinaResponse disciplina;

    private List<Integer> turmasIds;

    public ProfessorResponse(Professor entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.disciplina = new DisciplinaResponse(entity.getDisciplina());
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
