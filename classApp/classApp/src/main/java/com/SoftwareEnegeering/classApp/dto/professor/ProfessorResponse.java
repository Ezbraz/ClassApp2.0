package com.SoftwareEnegeering.classApp.dto.professor;

import com.SoftwareEnegeering.classApp.dto.disciplina.DisciplinaNome;
import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.entity.Disciplina;
import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.entity.Turma;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProfessorResponse {

    private Integer id;
    private String nome;

    private DisciplinaNome disciplina;

    private List<Integer> turmasIds;

    public ProfessorResponse(Professor entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.disciplina = new DisciplinaNome(entity.getDisciplina());
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
