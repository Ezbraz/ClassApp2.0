package com.SoftwareEnegeering.classApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer turma_id;

    private String turma_nome; //ex:3B (terceiro ano b)
    private Integer turma_nivel; //serie. ex: 3 (TERCEIRO ANO)
    private Integer turma_ano; //ex: 2020

    @OneToMany(mappedBy = "aluno_turma")
    private Set<Aluno> turma_alunos;

    @ManyToMany
    @JoinTable(name = "turma_professores",
    joinColumns = @JoinColumn (name = "turma_id"),
    inverseJoinColumns = @JoinColumn(name = "prof_id"))
    private Set<Professor> turma_professores;

}
