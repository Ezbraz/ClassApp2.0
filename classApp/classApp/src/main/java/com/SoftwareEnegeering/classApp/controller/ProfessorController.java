package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService prof_service;
    //Mapping
    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor){
        return prof_service.createProfessor(professor);
    }

    @GetMapping
    public List<Professor> getAllProfessores(){
        return prof_service.getAllProfessores();
    }
}
