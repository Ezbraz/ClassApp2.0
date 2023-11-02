package com.SoftwareEnegeering.classApp.repository;

import com.SoftwareEnegeering.classApp.dto.aluno.AlunoNome;
import com.SoftwareEnegeering.classApp.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    @Query("SELECT new com.SoftwareEnegeering.classApp.dto.aluno.AlunoNome(a.id, a.nome) FROM Aluno a")
    List<AlunoNome> findNamesAndIds();
}
