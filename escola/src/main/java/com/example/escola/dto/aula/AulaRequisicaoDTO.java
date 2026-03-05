package com.example.escola.dto.aula;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record AulaRequisicaoDTO(
        @NotNull(message = "ID da turma deve ser preenchido")
        int turma_id,
        Date data_hora,
        String assunto
) {
}
