package com.example.escola.dto.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record ProfessorRequiscaoDTO(
        @NotBlank(message = "Nome deve ser preenchido")
        String nome,
        @Size(min = 3, max = 100, message = "Email deve ter pelo menos 3 caracteres e no maximo 100")
        @NotBlank(message = "Email deve ser obrigario o preenchimento")
        @Email(message = "Email digitado de forma incorreta")
        String email,
        @NotBlank(message = "Disciplina deve ser preenchido")
        String disciplina


) {


}
