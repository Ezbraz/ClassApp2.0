package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoServiceImp implements AlunoService {

    @Autowired
    private AlunoRepository repository;

    //METODOS
    @Override
    public Aluno saveStudent(Aluno aluno) {
        return repository.save(aluno);
    }
    @Override
    public List<Aluno> fetchStudentList() {
        return repository.findAll();
    }

    @Override
    public Optional<Aluno> fechStudentById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteStudent(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Aluno updateStudent(UUID id, Aluno aluno) {
        Aluno alunoTemp = repository.findById(id).get();
        if(Objects.nonNull(aluno.getNome()) && !"".equals(aluno.getNome())){
            alunoTemp.setNome(aluno.getNome());
        }
        if(Objects.nonNull(aluno.getEmail()) && !"".equals(aluno.getEmail())){
            alunoTemp.setEmail(aluno.getEmail());
        }
        if(Objects.nonNull(aluno.getGenero()) && !"".equals(aluno.getGenero())){
            alunoTemp.setGenero(aluno.getGenero());
        }
        if(aluno.getNascimento() != null){
            alunoTemp.setNascimento(aluno.getNascimento());
        }
        alunoTemp.setAtivo(aluno.isAtivo());

        return repository.save(alunoTemp);
    }
}
