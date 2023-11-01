package com.SoftwareEnegeering.classApp.dto.aluno;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AlunoRequest {

    @NotBlank(message = "Nome is required")
    private String nome;
    @NotBlank(message = "Nascimento is required")
    private Date nascimento;

    @NotNull(message = "Nome is required")
    private Integer turmaId;
}
