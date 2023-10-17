package com.SoftwareEnegeering.classApp.repository;

import com.SoftwareEnegeering.classApp.entity.AnoLetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnoLetivoRepository extends JpaRepository<AnoLetivo, UUID> {
}
