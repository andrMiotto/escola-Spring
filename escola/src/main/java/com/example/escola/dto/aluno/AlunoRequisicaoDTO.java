package com.example.escola.dto.aluno;

import java.sql.Date;

public record AlunoRequisicaoDTO(
        String nome,
        String email,
        int matricula,
        Date data_nascimento
) {


}
