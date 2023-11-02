package com.SoftwareEnegeering.classApp.dto.disciplina;

import com.SoftwareEnegeering.classApp.entity.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DisciplinaNome {

    private Integer id;

    private String nome;

    public DisciplinaNome(Disciplina entity) {
        id = entity.getId();
        nome = entity.getNome();
    }
}
