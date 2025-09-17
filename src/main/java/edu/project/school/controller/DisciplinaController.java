package edu.project.school.controller;

import edu.project.school.entity.Disciplina;
import edu.project.school.service.DisciplinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @PostMapping
    public Disciplina criar(@RequestBody Disciplina disciplina) {
        return service.criarDisciplina(disciplina);
    }

    @GetMapping
    public List<Disciplina> listar() {
        return service.listarDisciplinas();
    }
}
