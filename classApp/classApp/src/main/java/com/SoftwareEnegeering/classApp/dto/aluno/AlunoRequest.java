package com.SoftwareEnegeering.classApp.dto.aluno;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Data
public class AlunoRequest {

    @NotBlank(message = "Nome is required")
    private String nome;
    @NotBlank(message = "Nascimento is required")
    private Date nascimento;

    @NotNull(message = "Nome is required")
    private Integer turmaId;
}
