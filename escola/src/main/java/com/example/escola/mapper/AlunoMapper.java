package com.example.escola.mapper;

import com.example.escola.dto.aluno.AlunoRequisicaoDTO;
import com.example.escola.dto.aluno.AlunoRespostaDTO;
import com.example.escola.model.Aluno;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
@Component
public class AlunoMapper {


    public Aluno paraEntidade(AlunoRequisicaoDTO alunoRequisicaoDTO) {
        return new Aluno(alunoRequisicaoDTO.nome(), alunoRequisicaoDTO.email(), alunoRequisicaoDTO.matricula(), alunoRequisicaoDTO.data_nascimento());
    }


    public AlunoRespostaDTO paraRespostaDTO(Aluno aluno) {
        return new AlunoRespostaDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getMatricula(), aluno.getDataNascimento());
    }


}
