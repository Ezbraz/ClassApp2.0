package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.dto.nota.NotaRequest;
import com.SoftwareEnegeering.classApp.dto.nota.NotaResponse;
import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.entity.Disciplina;
import com.SoftwareEnegeering.classApp.entity.Nota;
import com.SoftwareEnegeering.classApp.exceptions.NotFoundException;
import com.SoftwareEnegeering.classApp.repository.AlunoRepository;
import com.SoftwareEnegeering.classApp.repository.DisciplinaRepository;
import com.SoftwareEnegeering.classApp.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotaServiceImp  implements NotaService{

    @Autowired
    private NotaRepository notaRepository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<NotaResponse> getAllNotas() {
        List<Nota> notas = notaRepository.findAll();
        List<NotaResponse> notaResponses = new ArrayList<>();

        for(Nota nota : notas) {
            NotaResponse notaDTO = new NotaResponse(nota);
            notaResponses.add(notaDTO);
        }
        return notaResponses;
    }

    public NotaResponse createNota(NotaRequest dto) {
        Nota nota = new Nota();
        Optional<Aluno> alunoOptional = alunoRepository.findById(dto.getAlunoId());
        if (alunoOptional.isPresent()) {
            nota.setAluno(alunoOptional.get());
        } else throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Aluno não existe no banco de dados");

        Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(dto.getDisciplinaId());
        if (disciplinaOptional.isPresent()) {
            nota.setDisciplina(disciplinaOptional.get());
        } else throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Disciplina não existe no banco de dados");

        nota.setPontuacao(dto.getPontuacao());
        notaRepository.save(nota);
        return new NotaResponse(nota);
    }

    public NotaResponse updateNota(Integer id, NotaRequest dto) {
        Optional<Nota> notaOptional = notaRepository.findById(id);

        if (notaOptional.isPresent()) {
            if(dto.getAlunoId() != null || dto.getDisciplinaId() != null) throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Só é possivel alterar o valor da nota");

            Nota nota = notaOptional.get();
            nota.setPontuacao(dto.getPontuacao());
            notaRepository.save(nota);
            return new NotaResponse(nota);
        } else throw new NotFoundException();
    }

    public void deleteNota(Integer id) {
        if(notaRepository.existsById(id)) {
            notaRepository.deleteById(id);
        } else throw new NotFoundException();
    }

    public List<Double> recuperarNotasPorAlunoEDisciplina(Integer alunoId, Integer disciplinaId) {
        List<Double> pontuacao = new ArrayList<>();
        List<Nota> notas = notaRepository.findByAlunoIdAndDisciplinaId(alunoId, disciplinaId);
        for(Nota nota: notas) {
            pontuacao.add(nota.getPontuacao());
        }
        return pontuacao;
    }
}
