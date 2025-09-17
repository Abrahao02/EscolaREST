package edu.project.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.project.school.entity.Disciplina;
import edu.project.school.service.DisciplinaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class DisciplinaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DisciplinaService service;

    @InjectMocks
    private DisciplinaController controller;

    private Disciplina disciplina;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        disciplina = new Disciplina();
        disciplina.setId(1L);
        disciplina.setNome("Matemática");
        disciplina.setCodigo("MAT101");
    }

    @Test
    void testCriarDisciplina() throws Exception {
        Mockito.when(service.criarDisciplina(Mockito.any(Disciplina.class))).thenReturn(disciplina);

        mockMvc.perform(post("/disciplinas")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(disciplina)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Matemática"));
    }

    @Test
    void testListarDisciplinas() throws Exception {
        Mockito.when(service.listarDisciplinas()).thenReturn(List.of(disciplina));

        mockMvc.perform(get("/disciplinas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Matemática"));
    }
}
