package com.SoftwareEnegeering.classApp.dto.professor;

import lombok.Data;

import java.util.List;

@Data
public class ProfessorRequest {
    private String nome;
    private Integer disciplinaId;
    private List<Integer> turmasIds;
}
