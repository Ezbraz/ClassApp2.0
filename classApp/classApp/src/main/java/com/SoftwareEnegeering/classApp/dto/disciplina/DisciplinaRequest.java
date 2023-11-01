package com.SoftwareEnegeering.classApp.dto.disciplina;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisciplinaRequest {

    @NotBlank(message = "Nome is required")
    private String nome;

    private List<Integer> professores;

}