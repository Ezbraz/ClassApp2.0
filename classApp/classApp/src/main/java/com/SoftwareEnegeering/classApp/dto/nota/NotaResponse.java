package com.SoftwareEnegeering.classApp.dto.nota;

import com.SoftwareEnegeering.classApp.dto.aluno.AlunoNome;
import com.SoftwareEnegeering.classApp.dto.disciplina.DisciplinaResponse;
import com.SoftwareEnegeering.classApp.entity.Nota;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotaResponse {
    private Integer id;

    private AlunoNome aluno;

    private DisciplinaResponse disciplina;

    private Double pontuacao;

    private LocalDateTime CreatedAt;

    public NotaResponse(Nota nota) {
        this.id = nota.getId();
        this.aluno = new AlunoNome(nota.getAluno());
        this.disciplina = new DisciplinaResponse(nota.getDisciplina());
        this.pontuacao = nota.getPontuacao();
        this.CreatedAt = nota.getCreatedAt();
    }
}
