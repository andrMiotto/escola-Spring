package com.example.escola.dto.aluno;

import jakarta.validation.constraints.*;

import java.sql.Date;

public record AlunoRequisicaoDTO(
        @NotBlank(message = "Nome deve ser preenchido")
        String nome,
        @Size(min = 3, max = 100, message = "Email deve ter pelo menos 3 caracteres e no maximo 100")
        @NotBlank(message = "Email deve ser obrigario o preenchimento")
        @Email(message = "Email digitado de forma incorreta")
        String email,
        @NotNull(message = "Matricula é obrigatoria")
        int matricula,
        @Past(message = "Data de nascimento nao deve ser futura")
        Date data_nascimento
) {


}
