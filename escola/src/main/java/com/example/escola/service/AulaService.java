package com.example.escola.service;

import com.example.escola.dto.aula.AulaRequisicaoDTO;
import com.example.escola.dto.aula.AulaRespostaDTO;
import com.example.escola.mapper.AulaMapper;
import com.example.escola.model.Aula;
import com.example.escola.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AulaService {


    private final AulaRepository aulaRepository;

    private final AulaMapper aulaMapper;

    public AulaService(AulaRepository aulaRepository, AulaMapper aulaMapper) {
        this.aulaRepository = aulaRepository;
        this.aulaMapper = aulaMapper;
    }


    public AulaRespostaDTO create(AulaRequisicaoDTO aulaRequisicaoDTO) throws SQLException {

        Aula aula = aulaMapper.paraEntidade(aulaRequisicaoDTO);
        Aula salvo = aulaRepository.create(aula);

        String nomeTurma = aulaRepository.findTurmaById(salvo.getTurma_id());

        return aulaMapper.paraRespostaDTO(salvo, nomeTurma);


    }

    public List<AulaRespostaDTO> listAll() throws SQLException {
        List<Aula> aulas = aulaRepository.listAll();

        return aulas.stream()
                .map(aula -> {
                    try {
                        String nomeTurma = aulaRepository.findTurmaById(aula.getTurma_id());
                        return aulaMapper.paraRespostaDTO(aula, nomeTurma);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                })

                .toList();
    }


    public AulaRespostaDTO listId(int id) throws SQLException {
        Aula aula = aulaRepository.listId(id);
        String nomeTurma = aulaRepository.findTurmaById(aula.getTurma_id());


        return aulaMapper.paraRespostaDTO(aula, nomeTurma);


    }

    public void delete(int id) throws SQLException {
        aulaRepository.delete(id);

    }

    public AulaRespostaDTO update(AulaRequisicaoDTO aulaRequisicaoDTO, int id) throws SQLException {
        Aula aula = aulaMapper.paraEntidade(aulaRequisicaoDTO);
        aula.setId(id);

        Aula salvo = aulaRepository.update(aula, aula.getId());
        String nomeTurma = aulaRepository.findTurmaById(aula.getTurma_id());

        return aulaMapper.paraRespostaDTO(salvo, nomeTurma);
    }
}
