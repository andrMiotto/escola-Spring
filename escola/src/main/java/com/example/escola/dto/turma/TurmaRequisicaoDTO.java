package com.example.escola.dto.turma;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TurmaRequisicaoDTO(

        @NotBlank(message = "Nome deve ser preenchido")
        String nome,
        @NotNull(message = "Curso id deve ser preenchido")
        int curso_id,
        @NotNull(message = "Professor ID deve ser preenchido")
        int professor_id,
        List<Long> alunosID


) {

}
