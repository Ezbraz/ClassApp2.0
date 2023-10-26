package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno){
        return alunoService.createAluno(aluno);
    }

    @GetMapping
    public List<Aluno> getAlunos(){
        return alunoService.getAlunos();
    }
}
