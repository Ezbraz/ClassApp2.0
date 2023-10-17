package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    //METODOS

    @PostMapping("/professor")
    public Professor saveStudent(@RequestBody Professor professor){
        return service.saveProf(professor);
    }
    @GetMapping("/professor")
    public List<Professor> getProfs(){
        return service.fetchProfList();
    }
    @GetMapping("/professor/{id}")
    public Professor fechProfById(@PathVariable("id") UUID id){
        return service.fechProfById(id).get();
    }
    @DeleteMapping("/professor/{id}")
    public String deleteProf(@PathVariable("id") UUID id){
        service.deleteProf(id);
        return "Professor excluído!";
    }
    @PutMapping("/professor/{id}")
    public Professor updateStudent(@PathVariable("id") UUID id, @RequestBody Professor professor){
        return service.updateProf(id, professor);
    }

}
