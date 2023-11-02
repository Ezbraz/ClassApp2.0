package com.SoftwareEnegeering.classApp.dto.turma;

import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.entity.Turma;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TurmaResponse {

    private Integer id;

    private String nome;
    private Integer nivel;
    private Integer ano;
    private List<Integer> alunosIds;

    public TurmaResponse(Turma entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.nivel = entity.getNivel();
        this.ano = entity.getAno();
        this.alunosIds = mapAlunosIds(entity.getAlunos());
    }

    private List<Integer> mapAlunosIds(List<Aluno> alunos) {
        if (alunos != null) {
            return alunos.stream()
                    .map(Aluno::getId)
                    .collect(Collectors.toList());
        }
        return null;
    }

}
