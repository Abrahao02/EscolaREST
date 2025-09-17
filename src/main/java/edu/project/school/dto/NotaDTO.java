package edu.project.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotaDTO {
    private Double valor;
    private AlunoDTO aluno;
    private DisciplinaDTO disciplina;

}
