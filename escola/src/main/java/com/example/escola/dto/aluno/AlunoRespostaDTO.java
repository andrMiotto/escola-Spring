package com.example.escola.dto.aluno;

import java.sql.Date;

public record AlunoRespostaDTO(
        int id,
        String nome,
        String email,
        int matricula,
        Date data_nascimento
) {
}
