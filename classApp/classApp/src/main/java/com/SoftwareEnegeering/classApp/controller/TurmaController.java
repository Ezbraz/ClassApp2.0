package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.entity.Turma;
import com.SoftwareEnegeering.classApp.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public Turma createTurma(@RequestBody Turma turma){
        return turmaService.createTurma(turma);
    }

    @GetMapping
    public List<Turma> getTurmas(){
        return turmaService.getTurmas();
    }

}
