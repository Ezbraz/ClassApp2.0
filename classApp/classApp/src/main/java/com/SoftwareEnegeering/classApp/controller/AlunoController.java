package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.dto.aluno.AlunoNome;
import com.SoftwareEnegeering.classApp.dto.aluno.AlunoRequest;
import com.SoftwareEnegeering.classApp.dto.aluno.AlunoResponse;
import com.SoftwareEnegeering.classApp.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoResponse> createAluno(@RequestBody AlunoRequest aluno){
        return ResponseEntity.status(201).body(alunoService.createAluno(aluno));
    }

    @GetMapping
    public List<AlunoResponse> getAlunos(){
        return alunoService.getAlunos();
    }

    @GetMapping(value = "/nomes")
    public ResponseEntity<List<AlunoNome>> getNomesAlunos() {
        return ResponseEntity.ok().body(alunoService.getNomesAlunos());
    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<AlunoResponse> updateAluno(@PathVariable Integer id, @RequestBody AlunoRequest dto) {
        AlunoResponse aluno = alunoService.updateAluno(id, dto);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }
}
