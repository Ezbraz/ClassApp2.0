package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping("/aluno")
    public Aluno saveStudent(@RequestBody Aluno aluno){
        return service.saveStudent(aluno);
    }
    @GetMapping("/aluno")
    public List<Aluno> getStudents(){
        return service.fetchStudentList();
    }
    @GetMapping("/aluno/{id}")
    public Aluno fechStudentById(@PathVariable("id") UUID id){
        return service.fechStudentById(id).get();
    }
    @DeleteMapping("/aluno/{id}")
    public String deleteStudent(@PathVariable("id") UUID id){
        service.deleteStudent(id);
        return "Aluno excluído!";
    }
    @PutMapping("/aluno/{id}")
    public Aluno updateStudent(@PathVariable("id") UUID id, @RequestBody Aluno aluno){
        return service.updateStudent(id, aluno);
    }

}
