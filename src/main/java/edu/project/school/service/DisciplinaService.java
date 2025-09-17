package edu.project.school.service;

import edu.project.school.entity.Disciplina;
import edu.project.school.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public Disciplina criarDisciplina(Disciplina disciplina) {
        return repository.save(disciplina);
    }

    public List<Disciplina> listarDisciplinas() {
        return repository.findAll();
    }
}
