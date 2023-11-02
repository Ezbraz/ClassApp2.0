package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.dto.aluno.AlunoNome;
import com.SoftwareEnegeering.classApp.dto.professor.ProfessorNome;
import com.SoftwareEnegeering.classApp.dto.professor.ProfessorRequest;
import com.SoftwareEnegeering.classApp.dto.professor.ProfessorResponse;
import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorResponse> createProfessor(@RequestBody ProfessorRequest professor){
        return ResponseEntity.status(201).body(professorService.createProfessor(professor));
    }

    @GetMapping
    public List<ProfessorResponse> getAllProfessores(){
        return professorService.getAllProfessores();
    }

    @GetMapping(value = "/nomes")
    public ResponseEntity<List<ProfessorNome>> getNomesProfessores() {
        return ResponseEntity.ok().body(professorService.getNomesProfessores());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
