package com.example.escola.service;

import com.example.escola.dto.nota.NotaRequisicaoDTO;
import com.example.escola.dto.nota.NotaRespostaDTO;
import com.example.escola.mapper.NotaMapper;
import com.example.escola.model.Nota;
import com.example.escola.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    private final NotaMapper notaMapper;

    public NotaService(NotaRepository notaRepository, NotaMapper notaMapper) {
        this.notaRepository = notaRepository;
        this.notaMapper = notaMapper;
    }


    public NotaRespostaDTO create(NotaRequisicaoDTO notaRequisicaoDTO) throws SQLException {

        Nota nota = notaMapper.paraEntidade(notaRequisicaoDTO);
        Nota salvo = notaRepository.create(nota);

        String nomeAluno = notaRepository.findAlunoById(salvo.getAluno_id());
        String assuntoAula = notaRepository.findAssuntoById(salvo.getAula_id());

        return notaMapper.paraRespostaDTO(salvo, nomeAluno, assuntoAula);


    }

    public List<NotaRespostaDTO> listAll() throws SQLException {
        List<Nota> notas = notaRepository.listAll();

        return notas.stream()
                .map(nota -> {
                    try {
                        String nomeAluno = notaRepository.findAlunoById(nota.getAluno_id());
                        String assuntoAula = notaRepository.findAssuntoById(nota.getAula_id());
                        return notaMapper.paraRespostaDTO(nota, nomeAluno, assuntoAula);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                })

                .toList();
    }


    public NotaRespostaDTO listId(int id) throws SQLException {
        Nota nota = notaRepository.listId(id);
        String nomeAluno = notaRepository.findAlunoById(nota.getAluno_id());
        String assuntoAula = notaRepository.findAssuntoById(nota.getAula_id());

        return notaMapper.paraRespostaDTO(nota, nomeAluno, assuntoAula);
    }

    public void delete(int id) throws SQLException {
        notaRepository.delete(id);

    }

    public NotaRespostaDTO update(NotaRequisicaoDTO notaRequisicaoDTO, int id) throws SQLException {
        Nota nota = notaMapper.paraEntidade(notaRequisicaoDTO);
        nota.setId(id);

        Nota salvo = notaRepository.update(nota, nota.getId());
        String nomeAluno = notaRepository.findAlunoById(nota.getAluno_id());
        String assuntoAula = notaRepository.findAssuntoById(nota.getAula_id());

        return notaMapper.paraRespostaDTO(salvo, nomeAluno, assuntoAula);
    }

}
