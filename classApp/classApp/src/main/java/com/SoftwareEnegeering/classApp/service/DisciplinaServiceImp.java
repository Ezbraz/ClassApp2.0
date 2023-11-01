package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.disciplina.DisciplinaRequest;
import com.SoftwareEnegeering.classApp.dto.disciplina.DisciplinaResponse;
import com.SoftwareEnegeering.classApp.entity.Disciplina;
import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.exceptions.NotFoundException;
import com.SoftwareEnegeering.classApp.repository.DisciplinaRepository;
import com.SoftwareEnegeering.classApp.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaServiceImp implements DisciplinaService{

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Override
    public Disciplina createDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }
    @Override
    public List<Disciplina> getAllDisciplinas() {
        return disciplinaRepository.findAll();
    }
    @Override
    public DisciplinaResponse update(Integer id, DisciplinaRequest dto) {
        Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(id);

        if (disciplinaOptional.isPresent()) {
            Disciplina disciplina = disciplinaOptional.get();
            disciplina.setNome(dto.getNome());

            List<Professor> professores = professorRepository.findAllById(dto.getProfessores());
            disciplina.setProfessores(professores);

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
