package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.aluno.AlunoRequest;
import com.SoftwareEnegeering.classApp.dto.aluno.AlunoResponse;
import com.SoftwareEnegeering.classApp.dto.disciplina.DisciplinaResponse;
import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.entity.Turma;
import com.SoftwareEnegeering.classApp.exceptions.NotFoundException;
import com.SoftwareEnegeering.classApp.repository.AlunoRepository;
import com.SoftwareEnegeering.classApp.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImp implements AlunoService{

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    @Override
    public AlunoResponse updateAluno(Integer id, AlunoRequest dto) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setNome(dto.getNome());
            aluno.setNascimento(dto.getNascimento());
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
