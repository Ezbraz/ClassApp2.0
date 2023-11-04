package com.SoftwareEnegeering.classApp.controller;

import com.SoftwareEnegeering.classApp.dto.nota.NotaRequest;
import com.SoftwareEnegeering.classApp.dto.nota.NotaResponse;
import com.SoftwareEnegeering.classApp.dto.nota.NotaUpdateRequest;
import com.SoftwareEnegeering.classApp.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping
    public List<NotaResponse> getAllNotas() {
        return notaService.getAllNotas();
    }

    @PostMapping
    public NotaResponse createNota(@RequestBody NotaRequest nota) {
        return notaService.createNota(nota);
    }

    @PutMapping("/{id}")
    public NotaResponse atualizarNota(@PathVariable Integer id, @RequestBody NotaUpdateRequest nota) {
        return notaService.updateNota(id, nota);
    }

    @DeleteMapping("/{id}")
    public void excluirNota(@PathVariable Integer id) {
        notaService.deleteNota(id);
    }

    @GetMapping("/aluno/{alunoId}/disciplina/{disciplinaId}")
    public List<Double> recuperarNotasPorAlunoEInstituicao(@PathVariable Integer alunoId, @PathVariable Integer disciplinaId) {
        return notaService.recuperarNotasPorAlunoEDisciplina(alunoId, disciplinaId);
    }
}
