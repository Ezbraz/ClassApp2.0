package com.SoftwareEnegeering.classApp.dto.nota;

import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class NotaRequest {

    private Integer alunoId;

    @ManyToOne
    private Integer disciplinaId;

    private Double pontuacao;
}
