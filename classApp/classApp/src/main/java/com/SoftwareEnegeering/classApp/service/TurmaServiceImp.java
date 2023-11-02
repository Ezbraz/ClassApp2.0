package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.aluno.AlunoResponse;
import com.SoftwareEnegeering.classApp.dto.turma.TurmaRequest;
import com.SoftwareEnegeering.classApp.dto.turma.TurmaResponse;
import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.entity.Turma;
import com.SoftwareEnegeering.classApp.exceptions.NotFoundException;
import com.SoftwareEnegeering.classApp.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaServiceImp implements TurmaService{
    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public TurmaResponse createTurma(TurmaRequest dto) {
        Turma turma = new Turma();
        turma.setNome(dto.getNome());
        turma.setAno(dto.getAno());
        turma.setNivel(dto.getNivel());
        turmaRepository.save(turma);
        return new TurmaResponse(turma);
    }

    @Override
    public List<TurmaResponse> getTurmas() {
        List<Turma> turmas = turmaRepository.findAll();
        List<TurmaResponse> turmaResponses = new ArrayList<>();

        for (Turma turma : turmas) {
            TurmaResponse turmaDTO = new TurmaResponse(turma);
            turmaResponses.add(turmaDTO);
        }
        return turmaResponses;
    }

    @Override
    public TurmaResponse updateTurma(Integer id, TurmaRequest dto) {
        Optional<Turma> turmaOptional = turmaRepository.findById(id);

        if (turmaOptional.isPresent()) {
            Turma turma = turmaOptional.get();
            if (dto.getNome() != null) {
                turma.setNome(dto.getNome());
            }
            if (dto.getNivel() != null) {
                turma.setNivel(dto.getNivel());
            }
            if (dto.getAno() != null) {
                turma.setAno(dto.getAno());
            }
            turmaRepository.save(turma);
            return new TurmaResponse(turma);
        } else throw new NotFoundException();
    }

    @Override
    public void deleteTurma(Integer id) {
        if(turmaRepository.existsById(id)) {
            turmaRepository.deleteById(id);
        } else throw new NotFoundException();
    }
}
