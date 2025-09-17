package edu.project.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlunoDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
}
