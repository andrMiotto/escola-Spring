package com.example.escola.dto.turma;

import java.util.List;

public record TurmaRespostaDTO(
        int id,
        String nome,
        int curso_id,
        int professor_id,
        List<String> nomeAlunos

) {
}
