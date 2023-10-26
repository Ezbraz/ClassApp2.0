package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.entity.Disciplina;
import com.SoftwareEnegeering.classApp.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas") //SEGUIR ESSE PADRÃO DE MAPPING DE ENDPOINT
public class DisciplinaController {

    @Autowired
    private DisciplinaService disc_service;

    //MAPPING
    @PostMapping
    private Disciplina createDisciplina(@RequestBody Disciplina disciplina){
        return disc_service.createDisciplina(disciplina);
    }
    @GetMapping
    private List<Disciplina> getAllDisciplinas(){
        return disc_service.getAllDisciplinas();
    }
}
