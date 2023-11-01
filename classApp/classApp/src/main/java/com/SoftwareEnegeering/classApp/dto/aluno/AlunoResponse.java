package com.SoftwareEnegeering.classApp.dto.aluno;

import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.entity.Turma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AlunoResponse {

    private Integer id;
    private String nome;
    private Date nascimento;
    private Turma turma;
    private LocalDateTime CreatedAt;

    public AlunoResponse(Aluno entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.nascimento = entity.getNascimento();
        this.turma = entity.getTurma();
        CreatedAt = entity.getCreatedAt();
    }
}
