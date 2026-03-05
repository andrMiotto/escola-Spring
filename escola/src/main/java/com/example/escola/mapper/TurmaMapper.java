package com.example.escola.mapper;

import com.example.escola.dto.turma.TurmaRequisicaoDTO;
import com.example.escola.dto.turma.TurmaRespostaDTO;
import com.example.escola.model.Turma;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TurmaMapper {

    public Turma paraEntidade(TurmaRequisicaoDTO turmaRequisicaoDTO) {
        return new Turma(turmaRequisicaoDTO.nome(), turmaRequisicaoDTO.curso_id(), turmaRequisicaoDTO.professor_id());
    }


    public TurmaRespostaDTO paraRespostaDTO(Turma turma, List<String> nomesAlunos) {
        return new TurmaRespostaDTO(turma.getId(), turma.getNome(), turma.getCurso_id(), turma.getProfessor_id(), nomesAlunos);
    }


}
