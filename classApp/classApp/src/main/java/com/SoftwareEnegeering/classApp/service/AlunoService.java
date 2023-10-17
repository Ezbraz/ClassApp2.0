package com.SoftwareEnegeering.classApp.service;

import com.SoftwareEnegeering.classApp.entity.Aluno;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AlunoService {
    public Aluno saveStudent(Aluno aluno);

    public List<Aluno> fetchStudentList();

    public Optional<Aluno> fechStudentById(UUID id);

    public void deleteStudent(UUID id);

    public Aluno updateStudent(UUID id, Aluno aluno);
}
