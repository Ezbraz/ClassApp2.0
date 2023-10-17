package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.AnoLetivo;
import com.SoftwareEnegeering.classApp.repository.AnoLetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnoLetivoServiceImp implements AnoLetivoService{
    @Autowired
    private AnoLetivoRepository repository;
    @Override
    public AnoLetivo saveAno(AnoLetivo anoLetivo) {
        return repository.save(anoLetivo);
    }
    @Override
    public List<AnoLetivo> fetchAnoList() {
        return repository.findAll();
    }

    @Override
    public Optional<AnoLetivo> fetchAnoById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteAno(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public AnoLetivo updateStudent(UUID id, AnoLetivo anoLetivo) {
        AnoLetivo ano = repository.findById(id).get();
        if(Objects.nonNull(anoLetivo.getNome()) && !"".equals(anoLetivo.getNome())){
            ano.setNome(anoLetivo.getNome());
        }
        if(Objects.nonNull(anoLetivo.getInicio())){
            ano.setInicio(anoLetivo.getInicio());
        }
        if(Objects.nonNull(anoLetivo.getFim())){
            ano.setFim(anoLetivo.getFim());
        }
        return repository.save(ano);
    }
}
