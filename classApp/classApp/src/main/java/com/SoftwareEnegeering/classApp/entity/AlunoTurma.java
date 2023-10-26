//package com.SoftwareEnegeering.classApp.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Entity
//@Data
//@AllArgsConstructor
//public class AlunoTurma {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer alunoTurma_id;
//
//    @OneToOne
//    @JoinColumn(name = "fk_aluno_id", referencedColumnName = "aluno_id")
//    private Aluno aluno;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_turma_id", referencedColumnName = "turma_id")
//    private Turma turma;
//
//    private N
//
//
//}
