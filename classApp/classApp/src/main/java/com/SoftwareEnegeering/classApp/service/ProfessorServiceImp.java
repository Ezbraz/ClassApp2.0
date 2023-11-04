package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.aluno.AlunoNome;
import com.SoftwareEnegeering.classApp.dto.professor.ProfessorNome;
import com.SoftwareEnegeering.classApp.dto.professor.ProfessorRequest;
import com.SoftwareEnegeering.classApp.dto.professor.ProfessorResponse;
import com.SoftwareEnegeering.classApp.entity.Disciplina;
import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.entity.Turma;
import com.SoftwareEnegeering.classApp.exceptions.NotFoundException;
import com.SoftwareEnegeering.classApp.repository.DisciplinaRepository;
import com.SoftwareEnegeering.classApp.repository.ProfessorRepository;
import com.SoftwareEnegeering.classApp.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImp implements ProfessorService{

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private TurmaRepository turmaRepository;
    @Override
    public ProfessorResponse createProfessor(ProfessorRequest dto) {
        Professor professor = new Professor();
        if(dto.getDisciplinaId() != null) {
            Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(dto.getDisciplinaId());

            if (disciplinaOptional.isPresent()) {
                professor.setDisciplina(disciplinaOptional.get());
            } else throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Id da Disciplina não existe");
        }
        professor.setNome(dto.getNome());
        if(dto.getTurmasIds() != null && !dto.getTurmasIds().isEmpty()) {
            List<Turma> turmas = new ArrayList<>();
            dto.getTurmasIds().forEach(turmaId -> {
                Optional<Turma> turmaOptional = turmaRepository.findById(turmaId);
                if (turmaOptional.isPresent()) {
                    turmas.add(turmaOptional.get());
                } else throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Id " + turmaId + " da Turma não existe");
            });
            turmaRepository.saveAll(turmas);
            turmas.forEach(turma -> turma.getTurma_professores().add(professor));
            professor.setTurmas(turmas);
        }
        professorRepository.save(professor);
        ProfessorResponse professorResponse = new ProfessorResponse(professor);
        return professorResponse;
    }

    @Override
    public List<ProfessorResponse> getAllProfessores() {
        List<Professor> professores = professorRepository.findAll();
        List<ProfessorResponse> professoresResponses = new ArrayList<>();

        for(Professor professor : professores) {
            ProfessorResponse professorDTO = new ProfessorResponse(professor);
            professoresResponses.add(professorDTO);
        }
        return professoresResponses;
    }

    public List<ProfessorNome> getNomesProfessores() {
        return professorRepository.findNamesAndIds();
    }

    @Override
    public ProfessorResponse updateProfessor(Integer id, ProfessorRequest dto) {
        Optional<Professor> professorOptional = professorRepository.findById(id);
        if(professorOptional.isPresent()) {
            Professor professor = professorOptional.get();
            if(dto.getNome() != null) {
                professor.setNome(dto.getNome());
            }
            if(dto.getDisciplinaId() != null) {
                Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(dto.getDisciplinaId());
                if (disciplinaOptional.isPresent()) {
                    professor.setDisciplina(disciplinaOptional.get());
                } else throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Id da Disciplina não existe");
            }
            if(dto.getTurmasIds() != null && !dto.getTurmasIds().isEmpty()) {
                List<Turma> turmas = new ArrayList<>();
                dto.getTurmasIds().forEach(turmaId -> {
                    Optional<Turma> turmaOptional = turmaRepository.findById(turmaId);
                    if (turmaOptional.isPresent()) {
                        turmas.add(turmaOptional.get());
                    } else throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Id " + turmaId + " da Turma não existe");
                });
                professor.setTurmas(turmas);
            }
            professorRepository.save(professor);
            ProfessorResponse professorResponse = new ProfessorResponse(professor);
            return professorResponse;
        }else throw new NotFoundException();
    }

    @Override
    public void deleteProfessor(Integer id) {
        if(professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
        } else throw new NotFoundException();
    }
}
