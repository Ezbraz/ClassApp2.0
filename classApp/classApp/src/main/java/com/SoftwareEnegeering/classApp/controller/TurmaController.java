package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.dto.aluno.AlunoRequest;
import com.SoftwareEnegeering.classApp.dto.aluno.AlunoResponse;
import com.SoftwareEnegeering.classApp.dto.turma.TurmaRequest;
import com.SoftwareEnegeering.classApp.dto.turma.TurmaResponse;
import com.SoftwareEnegeering.classApp.entity.Turma;
import com.SoftwareEnegeering.classApp.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<TurmaResponse> createTurma(@RequestBody TurmaRequest turma){
        return  ResponseEntity.status(201).body(turmaService.createTurma(turma));
    }

    @GetMapping
    public List<TurmaResponse> getTurmas(){
        return turmaService.getTurmas();
    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<TurmaResponse> updateTurma(@PathVariable Integer id, @RequestBody TurmaRequest dto) {
        TurmaResponse turma = turmaService.updateTurma(id, dto);
        return ResponseEntity.ok().body(turma);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        turmaService.deleteTurma(id);
        return ResponseEntity.noContent().build();
    }
}
