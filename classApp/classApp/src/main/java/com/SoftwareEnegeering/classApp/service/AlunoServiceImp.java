package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.aluno.AlunoNome;
import com.SoftwareEnegeering.classApp.dto.aluno.AlunoRequest;
import com.SoftwareEnegeering.classApp.dto.aluno.AlunoResponse;
import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.entity.Turma;
import com.SoftwareEnegeering.classApp.exceptions.NotFoundException;
import com.SoftwareEnegeering.classApp.repository.AlunoRepository;
import com.SoftwareEnegeering.classApp.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImp implements AlunoService{

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public AlunoResponse createAluno(AlunoRequest dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setNascimento(dto.getNascimento());
        Optional<Turma> turmaOptional = turmaRepository.findById(dto.getTurmaId());

        if (turmaOptional.isPresent()) {
            aluno.setTurma(turmaOptional.get());
        } else throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Id da Turma não existe");
        alunoRepository.save(aluno);
        AlunoResponse alunoResponse = new AlunoResponse(aluno);
        return alunoResponse;
    }

    @Override
    public List<AlunoResponse> getAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        List<AlunoResponse> alunoResponses = new ArrayList<>();

        for (Aluno aluno : alunos) {
            AlunoResponse alunoDTO = new AlunoResponse(aluno);
            alunoResponses.add(alunoDTO);
        }
        return alunoResponses;
    }

    @Override
    public List<AlunoNome> getNomesAlunos() {
        return alunoRepository.findNamesAndIds();
    }

    @Override
    public AlunoResponse updateAluno(Integer id, AlunoRequest dto) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            if (dto.getNome() != null) {
                aluno.setNome(dto.getNome());
            }
            if (dto.getNascimento() != null) {
                aluno.setNascimento(dto.getNascimento());
            }
            if (dto.getTurmaId() != null) {
                Optional<Turma> turmaOptional = turmaRepository.findById(dto.getTurmaId());

                if (turmaOptional.isPresent()) {
                    aluno.setTurma(turmaOptional.get());
                } else throw new NotFoundException();
            }
            alunoRepository.save(aluno);
            return new AlunoResponse(aluno);
        } else throw new NotFoundException();
    }

    public void deleteAluno(Integer id) {
        if(alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
        } else throw new NotFoundException();
    }
}
