package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.AnoLetivo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AnoLetivoService {
    AnoLetivo saveAno(AnoLetivo anoLetivo);

    List<AnoLetivo> fetchAnoList();

    Optional<AnoLetivo> fetchAnoById(UUID id);

    void deleteAno(UUID id);

    AnoLetivo updateStudent(UUID id, AnoLetivo anoLetivo);
}
