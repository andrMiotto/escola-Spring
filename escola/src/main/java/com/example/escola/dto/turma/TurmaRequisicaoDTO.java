package com.example.escola.dto.turma;

import java.util.List;

public record TurmaRequisicaoDTO(
        String nome,
        int curso_id,
        int professor_id,
        List<Long> alunosID


) {

}
