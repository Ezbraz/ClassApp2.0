package com.SoftwareEnegeering.classApp.dto.disciplina;

import com.SoftwareEnegeering.classApp.entity.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisciplinaResponse {

    private Integer id;

    private String nome;

    public DisciplinaResponse(Disciplina entity) {
        id = entity.getId();
        nome = entity.getNome();
    }

}
