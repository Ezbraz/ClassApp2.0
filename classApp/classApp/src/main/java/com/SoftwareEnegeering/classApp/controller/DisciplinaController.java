package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.dto.disciplina.DisciplinaRequest;
import com.SoftwareEnegeering.classApp.dto.disciplina.DisciplinaResponse;
import com.SoftwareEnegeering.classApp.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disc_service;

    @PostMapping
    private DisciplinaResponse createDisciplina(@RequestBody DisciplinaRequest disciplina){
        return disc_service.createDisciplina(disciplina);
    }
    @GetMapping
    private List<DisciplinaResponse> getAllDisciplinas(){
        return disc_service.getAllDisciplinas();
    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<DisciplinaResponse> updateDisciplina(@PathVariable Integer id, @RequestBody DisciplinaRequest dto) {
        DisciplinaResponse disciplina = disc_service.update(id, dto);
        return ResponseEntity.ok().body(disciplina);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        disc_service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
