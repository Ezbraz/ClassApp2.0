package com.SoftwareEnegeering.classApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity //define a classe como entidade
@Data //notação do lombok para geração automática dos getters e setters
@AllArgsConstructor //notação do lombok para geração do construtor com todos os parametros como argumentos
@NoArgsConstructor // notação lombok para geração do construtor sem nenhum argumento
@Builder // notação lombok para geração de um construtor personalizado
@Table(uniqueConstraints = @UniqueConstraint(name = "emailIdUnique", columnNames = "email")) // define a tabela e nomeia para "tb_students"
public class Aluno {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;

    private String genero;

    @Column(name = "email", nullable = false)
    private String email;

    //@Column(name = "idade") //notação jpa column define o campo como coluna
    private Date nascimento;

    private boolean ativo = true;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
