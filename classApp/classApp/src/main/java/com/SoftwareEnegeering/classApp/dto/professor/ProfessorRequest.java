package com.SoftwareEnegeering.classApp.dto.professor;

import com.SoftwareEnegeering.classApp.entity.Disciplina;
import lombok.Data;

import java.util.List;

@Data
public class ProfessorRequest {
    private Integer id;
    private String nome;
    private Integer disciplinaId;
    private List<Integer> turmasIds;
}
