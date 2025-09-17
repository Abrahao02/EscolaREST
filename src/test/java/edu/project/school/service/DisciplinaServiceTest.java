package edu.project.school.service;

import edu.project.school.entity.Disciplina;
import edu.project.school.repository.DisciplinaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DisciplinaServiceTest {

    @Mock
    private DisciplinaRepository repository;

    @InjectMocks
    private DisciplinaService service;

    private Disciplina disciplina;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        disciplina = new Disciplina();
        disciplina.setId(1L);
        disciplina.setNome("Matemática");
        disciplina.setCodigo("MAT101");
    }

    @Test
    void testCriarDisciplina() {
        when(repository.save(disciplina)).thenReturn(disciplina);
        Disciplina result = service.criarDisciplina(disciplina);
        assertEquals("Matemática", result.getNome());
        verify(repository, times(1)).save(disciplina);
    }

    @Test
    void testListarDisciplinas() {
        when(repository.findAll()).thenReturn(List.of(disciplina));
        List<Disciplina> list = service.listarDisciplinas();
        assertEquals(1, list.size());
    }
}
