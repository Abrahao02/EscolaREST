package edu.project.school.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    // Getters e Setters
}
