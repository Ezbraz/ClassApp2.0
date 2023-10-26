package com.SoftwareEnegeering.classApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aluno_id;
    private String aluno_nome;
    private Date aluno_nascimento;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma aluno_turma;

    @CreationTimestamp
    private LocalDateTime CreatedAt;
}
