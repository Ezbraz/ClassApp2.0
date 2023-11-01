package com.SoftwareEnegeering.classApp.dto.professor;

import com.SoftwareEnegeering.classApp.entity.Disciplina;
import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.entity.Turma;
import jakarta.persistence.*;

import java.util.Set;

public class ProfessorResponse {

    private Integer id;
    private String nome;

    private Disciplina disciplina;

    private Set<Turma> turmas;

    public ProfessorResponse(Professor entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.disciplina = entity.getProf_disciplina();
        this.turmas = (Set<Turma>) entity.getTurmas();
    }
}
