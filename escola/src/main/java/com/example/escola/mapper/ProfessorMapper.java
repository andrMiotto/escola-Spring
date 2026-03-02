package com.example.escola.mapper;

import com.example.escola.dto.aluno.AlunoRequisicaoDTO;
import com.example.escola.dto.aluno.AlunoRespostaDTO;
import com.example.escola.dto.professor.ProfessorRequiscaoDTO;
import com.example.escola.dto.professor.ProfessorRespostaDTO;
import com.example.escola.model.Aluno;
import com.example.escola.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public Professor paraEntidade(ProfessorRequiscaoDTO professorRequiscaoDTO) {
        return new Professor(professorRequiscaoDTO.nome(), professorRequiscaoDTO.email(), professorRequiscaoDTO.disciplina());
    }


    public ProfessorRespostaDTO paraRespostaDTO(Professor professor) {
        return new ProfessorRespostaDTO(professor.getId(), professor.getNome(), professor.getEmail(), professor.getDisciplina());
    }


}
