package com.SoftwareEnegeering.classApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Turma {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nome;
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    private boolean ativo;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
