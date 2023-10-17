package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Disciplina;
import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class DisciplinaServiceImp implements DisciplinaService{
    @Autowired
    private DisciplinaRepository repository;
    @Override
    public Disciplina saveDisc(Disciplina disciplina) {
        return repository.save(disciplina);
    }

    @Override
    public List<Disciplina> fetchDiscList() {
        return repository.findAll();
    }

    @Override
    public Optional<Disciplina> fechDiscById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteDisc(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Disciplina updateDisc(UUID id, Disciplina disciplina) {
        Disciplina disciplinaTemp = repository.findById(id).get();
        if(Objects.nonNull(disciplina.getNome()) && !"".equals(disciplina.getNome())){
            disciplinaTemp.setNome(disciplina.getNome());
        }
        if(Objects.nonNull(disciplina.getCodigo()) && !"".equals(disciplina.getCodigo())){
            disciplinaTemp.setCodigo(disciplina.getCodigo());
        }

        return repository.save(disciplinaTemp);
    }
}
