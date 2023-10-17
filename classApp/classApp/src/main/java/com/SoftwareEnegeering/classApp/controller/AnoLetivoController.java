package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.entity.Aluno;
import com.SoftwareEnegeering.classApp.entity.AnoLetivo;
import com.SoftwareEnegeering.classApp.service.AnoLetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ano")
public class AnoLetivoController {
    @Autowired
    private AnoLetivoService service;

    @PostMapping("/ano")
    public AnoLetivo saveStudent(@RequestBody AnoLetivo anoLetivo){
        return service.saveAno(anoLetivo);
    }
    @GetMapping("/ano")
    public List<AnoLetivo> getAno(){
        return service.fetchAnoList();
    }
    @GetMapping("/ano/{id}")
    public AnoLetivo fetchAnoById(@PathVariable("id") UUID id){
        return service.fetchAnoById(id).get();
    }
    @DeleteMapping("/ano/{id}")
    public String deleteAno(@PathVariable("id") UUID id){
        service.deleteAno(id);
        return "Ano letivo excluído!";
    }
    @PutMapping("/ano/{id}")
    public AnoLetivo updateAno(@PathVariable("id") UUID id, @RequestBody AnoLetivo anoLetivo){
        return service.updateStudent(id, anoLetivo);
    }
}
