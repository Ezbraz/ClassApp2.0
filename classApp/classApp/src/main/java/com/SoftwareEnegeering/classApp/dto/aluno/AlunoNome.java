package com.SoftwareEnegeering.classApp.dto.aluno;

import com.SoftwareEnegeering.classApp.entity.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlunoNome {
    private Integer id;
    private String nome;

    public AlunoNome(Aluno entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }
}
