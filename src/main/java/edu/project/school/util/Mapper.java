package edu.project.school.util;

import edu.project.school.dto.AlunoDTO;
import edu.project.school.dto.DisciplinaDTO;
import edu.project.school.dto.NotaDTO;
import edu.project.school.entity.Aluno;
import edu.project.school.entity.Disciplina;
import edu.project.school.entity.Nota;

public class Mapper {

    public static AlunoDTO toAlunoDTO(Aluno aluno) {
        if (aluno == null) return null;
        return new AlunoDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getEmail(),
                aluno.getTelefone(),
                aluno.getEndereco()
        );
    }

    public static DisciplinaDTO toDisciplinaDTO(Disciplina disciplina) {
        if (disciplina == null) return null;
        return new DisciplinaDTO(
                disciplina.getId(),
                disciplina.getNome(),
                disciplina.getCodigo()
        );
    }

    public static NotaDTO toNotaDTO(Nota nota) {
        if (nota == null) return null;
        return new NotaDTO(
                nota.getValor(),
                toAlunoDTO(nota.getAluno()),
                toDisciplinaDTO(nota.getDisciplina())
        );
    }
}
