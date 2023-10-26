package com.SoftwareEnegeering.classApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prof_id;
    private String prof_nome;

    @ManyToOne
    @JoinColumn(name = "disc_id")
    private Disciplina prof_disciplina;

    @ManyToMany(mappedBy = "turma_professores")
    private Set<Turma> prof_turmas;
}
