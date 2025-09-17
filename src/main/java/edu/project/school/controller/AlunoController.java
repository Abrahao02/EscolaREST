package edu.project.school.controller;

import edu.project.school.entity.Aluno;
import edu.project.school.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno) {
        return service.criarAluno(aluno);
    }

    @GetMapping
    public List<Aluno> listar() {
        return service.listarAlunos();
    }
}
