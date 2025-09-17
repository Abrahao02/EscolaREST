package edu.project.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DisciplinaDTO {
    private Long id;
    private String nome;
    private String codigo;
}
