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

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class AnoLetivo {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nome;
    private Date inicio;
    private Date fim;
    private boolean ativo;

    @CreationTimestamp
    private LocalDateTime createdAt;
}