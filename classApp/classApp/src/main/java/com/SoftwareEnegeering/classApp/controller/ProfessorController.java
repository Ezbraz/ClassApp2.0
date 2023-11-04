package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.dto.professor.ProfessorNome;
import com.SoftwareEnegeering.classApp.dto.professor.ProfessorRequest;
import com.SoftwareEnegeering.classApp.dto.professor.ProfessorResponse;
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

    @PutMapping(value = "/{id}")
    private ResponseEntity<ProfessorResponse> updateProfessor(@PathVariable Integer id, @RequestBody ProfessorRequest dto) {
        ProfessorResponse professor = professorService.updateProfessor(id, dto);
        return ResponseEntity.ok().body(professor);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
