package edu.project.school.service;

import edu.project.school.entity.Nota;
import edu.project.school.repository.NotaRepository;
import org.springframework.stereotype.Service;
import edu.project.school.dto.NotaDTO;
import edu.project.school.util.Mapper;

import java.util.List;

@Service
public class NotaService {

    private final NotaRepository repository;

    public NotaService(NotaRepository repository) {
        this.repository = repository;
    }

    public Nota atribuirNota(Nota nota) {
        return repository.save(nota);
    }

    public List<NotaDTO> listarAprovados(Long disciplinaId) {
        return repository.findByDisciplinaIdAndValorGreaterThanEqual(disciplinaId, 7.0)
                .stream()
                .map(Mapper::toNotaDTO)
                .toList();
    }

    public List<NotaDTO> listarReprovados(Long disciplinaId) {
        return repository.findByDisciplinaIdAndValorLessThan(disciplinaId, 7.0)
                .stream()
                .map(Mapper::toNotaDTO)
                .toList();
    }
}
