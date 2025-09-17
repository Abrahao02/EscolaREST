package edu.project.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.project.school.entity.Aluno;
import edu.project.school.service.AlunoService;
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
class AlunoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AlunoService service;

    @InjectMocks
    private AlunoController controller;

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("João Silva");
    }

    @Test
    void testCriarAluno() throws Exception {
        Mockito.when(service.criarAluno(Mockito.any(Aluno.class))).thenReturn(aluno);

        mockMvc.perform(post("/alunos")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(aluno)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João Silva"));
    }

    @Test
    void testListarAlunos() throws Exception {
        Mockito.when(service.listarAlunos()).thenReturn(List.of(aluno));

        mockMvc.perform(get("/alunos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("João Silva"));
    }
}
