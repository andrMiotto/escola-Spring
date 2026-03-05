package com.example.escola.service;

import com.example.escola.dto.professor.ProfessorRequiscaoDTO;
import com.example.escola.dto.professor.ProfessorRespostaDTO;
import com.example.escola.dto.turma.TurmaRequisicaoDTO;
import com.example.escola.dto.turma.TurmaRespostaDTO;
import com.example.escola.mapper.TurmaMapper;
import com.example.escola.model.Professor;
import com.example.escola.model.Turma;
import com.example.escola.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    private final TurmaMapper turmaMapper;


    public TurmaService(TurmaRepository turmaRepository, TurmaMapper turmaMapper) {
        this.turmaRepository = turmaRepository;
        this.turmaMapper = turmaMapper;
    }

    public TurmaRespostaDTO create(TurmaRequisicaoDTO turmaRequisicaoDTO) throws SQLException {

        Turma turma = turmaMapper.paraEntidade(turmaRequisicaoDTO);
        Turma salvo = turmaRepository.create(turma);
        List<String> alunos = turmaRepository.findNomesById(salvo.getId());

        return turmaMapper.paraRespostaDTO(salvo, alunos);


    }

    public List<TurmaRespostaDTO> listAll() throws SQLException {
        List<Turma> turmas = turmaRepository.listAll();

        return turmas.stream()
                .map(turma -> {
                    try {
                        List<String> alunos = turmaRepository.findNomesById(turma.getId());
                        return turmaMapper.paraRespostaDTO(turma, alunos);
                    } catch (SQLException e) {
                        throw new RuntimeException("Erro ao buscar professores do curso: " + turma.getId());
                    }
                })
                .toList();
    }


    public TurmaRespostaDTO listId(int id) throws SQLException {
        Turma turma = turmaRepository.listId(id);
        List<String> alunos = turmaRepository.findNomesById(turma.getId());

        return turmaMapper.paraRespostaDTO(turma, alunos);
    }

    public void delete(int id) throws SQLException {
        turmaRepository.delete(id);

    }

    public TurmaRespostaDTO update(TurmaRequisicaoDTO turmaRequisicaoDTO, int id) throws SQLException {
        Turma turma = turmaMapper.paraEntidade(turmaRequisicaoDTO);
        turma.setId(id);

        Turma salvo = turmaRepository.update(turma, turma.getId());
        List<String> alunos = turmaRepository.findNomesById(turma.getId());

        return turmaMapper.paraRespostaDTO(salvo, alunos);
    }

}
