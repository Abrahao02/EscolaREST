package edu.project.school.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;

    @ManyToMany(mappedBy = "alunos")
    private List<Disciplina> disciplinas;

    // Getters e Setters
}
