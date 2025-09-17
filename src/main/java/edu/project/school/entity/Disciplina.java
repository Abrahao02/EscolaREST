package edu.project.school.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String codigo;

    @ManyToMany
    @JoinTable(
            name = "aluno_disciplina",
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "disciplina")
    private List<Nota> notas;

    // Getters e Setters
}
