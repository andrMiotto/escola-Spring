package com.example.escola.dto.curso;

import com.example.escola.model.Professor;
import jakarta.validation.constraints.NotBlank;

import java.lang.reflect.Array;
import java.util.List;

public record CursoRequisicaoDTO(
        @NotBlank(message = "Nome deve ser preenchido")
        String nome,
        @NotBlank(message = "Codigo deve ser preenchido")
        String codigo
) {
}
