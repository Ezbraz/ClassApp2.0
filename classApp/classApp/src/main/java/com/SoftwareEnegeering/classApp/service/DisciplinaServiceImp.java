package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.disciplina.DisciplinaRequest;
import com.SoftwareEnegeering.classApp.dto.disciplina.DisciplinaResponse;
import com.SoftwareEnegeering.classApp.entity.Disciplina;
import com.SoftwareEnegeering.classApp.exceptions.NotFoundException;
import com.SoftwareEnegeering.classApp.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaServiceImp implements DisciplinaService{

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Override
    public DisciplinaResponse createDisciplina(DisciplinaRequest dto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.getNome());
        return new DisciplinaResponse(disciplina);
    }
    @Override
    public List<DisciplinaResponse> getAllDisciplinas() {
        List<Disciplina> disciplinas = disciplinaRepository.findAll();
        List<DisciplinaResponse> disciplinaResponses = new ArrayList<>();

        for (Disciplina disciplina : disciplinas) {
            DisciplinaResponse disciplinaDTO = new DisciplinaResponse(disciplina);
            disciplinaResponses.add(disciplinaDTO);
        }
        return disciplinaResponses;
    }
    @Override
    public DisciplinaResponse update(Integer id, DisciplinaRequest dto) {
        Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(id);

        if (disciplinaOptional.isPresent()) {
            Disciplina disciplina = disciplinaOptional.get();
            disciplina.setNome(dto.getNome());

            disciplinaRepository.save(disciplina);
            return new DisciplinaResponse(disciplina);
        }
        else throw new NotFoundException();
    }

    public void delete(Integer id) {
        if(disciplinaRepository.existsById(id)) {
            disciplinaRepository.deleteById(id);
        } else throw new NotFoundException();
    }
}
