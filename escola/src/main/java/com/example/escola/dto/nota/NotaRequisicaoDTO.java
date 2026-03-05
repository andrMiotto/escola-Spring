package com.example.escola.dto.nota;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record NotaRequisicaoDTO(
        @NotNull(message = "Aluno ID deve ser preenchido")
        int aluno_id,
        @NotNull(message = "Aula id deve ser preenchido")
        int aula_id,
        @PositiveOrZero(message = "Nota deve ser igual ou maior que 0")
        Double valor

) {


}
