package edu.project.school.service;

import edu.project.school.entity.Aluno;
import edu.project.school.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno criarAluno(Aluno aluno) {
        return repository.save(aluno);
    }

    public List<Aluno> listarAlunos() {
        return repository.findAll();
    }
}
