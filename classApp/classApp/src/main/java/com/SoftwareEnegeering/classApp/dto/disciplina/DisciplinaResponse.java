package com.SoftwareEnegeering.classApp.dto.disciplina;

import com.SoftwareEnegeering.classApp.dto.professor.ProfessorResponse;
import com.SoftwareEnegeering.classApp.entity.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisciplinaResponse {

    private Integer id;

    private String nome;

    private List<ProfessorResponse> professores;

    public DisciplinaResponse(Disciplina entity) {
        id = entity.getId();
        nome = entity.getNome();
        professores = new ArrayList<ProfessorResponse>();
        entity.getProfessores().forEach(professor -> professores.add(new ProfessorResponse(professor)));
    }

}
