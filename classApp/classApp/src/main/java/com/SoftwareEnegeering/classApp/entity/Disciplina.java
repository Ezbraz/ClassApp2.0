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
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer disc_id;
    private String disc_nome;

    @OneToMany(mappedBy = "prof_disciplina")
    private Set<Professor> disc_professores;


}
