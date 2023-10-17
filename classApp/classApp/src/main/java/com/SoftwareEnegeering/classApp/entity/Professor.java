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
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class Professor {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;


    private String Nome;
    private String Email;
    private String registro;
    private boolean ativo = true;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
