package com.SoftwareEnegeering.classApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome; //ex:3B (terceiro ano b)
    private Integer nivel; //serie. ex: 3 (TERCEIRO ANO)
    private Integer ano; //ex: 2020

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;

    @ManyToMany
    @JoinTable(name = "turma_professores",
    joinColumns = @JoinColumn (name = "turma_id"),
    inverseJoinColumns = @JoinColumn(name = "prof_id"))
    private Set<Professor> turma_professores;

}
