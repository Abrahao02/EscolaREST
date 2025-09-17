package edu.project.school.service;

import edu.project.school.entity.Aluno;
import edu.project.school.repository.AlunoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlunoServiceTest {

    @Mock
    private AlunoRepository repository;

    @InjectMocks
    private AlunoService service;

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("João Silva");
    }

    @Test
    void testCriarAluno() {
        when(repository.save(aluno)).thenReturn(aluno);
        Aluno result = service.criarAluno(aluno);
        assertEquals("João Silva", result.getNome());
        verify(repository, times(1)).save(aluno);
    }

    @Test
    void testListarAlunos() {
        when(repository.findAll()).thenReturn(List.of(aluno));
        List<Aluno> alunos = service.listarAlunos();
        assertEquals(1, alunos.size());
    }
}
