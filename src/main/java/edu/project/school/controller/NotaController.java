package edu.project.school.controller;

import edu.project.school.dto.NotaDTO;
import edu.project.school.entity.Nota;
import edu.project.school.service.NotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService service;

    public NotaController(NotaService service) {
        this.service = service;
    }

    @PostMapping
    public Nota atribuir(@RequestBody Nota nota) {
        return service.atribuirNota(nota);
    }

    @GetMapping("/aprovados/{disciplinaId}")
    public List<NotaDTO> listarAprovados(@PathVariable Long disciplinaId) {
        return service.listarAprovados(disciplinaId);
    }

    @GetMapping("/reprovados/{disciplinaId}")
    public List<NotaDTO> listarReprovados(@PathVariable Long disciplinaId) {
        return service.listarReprovados(disciplinaId);
    }
}
