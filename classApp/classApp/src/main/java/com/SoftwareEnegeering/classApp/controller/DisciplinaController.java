package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.entity.Disciplina;
import com.SoftwareEnegeering.classApp.entity.Professor;
import com.SoftwareEnegeering.classApp.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    //metodos
    @PostMapping("/disciplina")
    public Disciplina saveDisc(@RequestBody Disciplina disciplina){
        return service.saveDisc(disciplina);
    }
    @GetMapping("/disciplina")
    public List<Disciplina> getDiscs(){
        return service.fetchDiscList();
    }
    @GetMapping("/disciplina/{id}")
    public Disciplina fechDiscById(@PathVariable("id") UUID id){
        return service.fechDiscById(id).get();
    }
    @DeleteMapping("/disciplina/{id}")
    public String deleteProf(@PathVariable("id") UUID id){
        service.deleteDisc(id);
        return "disciplina excluída!";
    }
    @PutMapping("/disciplina/{id}")
    public Disciplina updateDisc(@PathVariable("id") UUID id, @RequestBody Disciplina disciplina){
        return service.updateDisc(id, disciplina);
    }

}
