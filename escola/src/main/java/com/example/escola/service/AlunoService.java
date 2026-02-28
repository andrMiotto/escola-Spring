package com.example.escola.service;

import com.example.escola.dto.aluno.AlunoRequisicaoDTO;
import com.example.escola.dto.aluno.AlunoRespostaDTO;
import com.example.escola.mapper.AlunoMapper;
import com.example.escola.model.Aluno;
import com.example.escola.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    private final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    public AlunoRespostaDTO createAluno(AlunoRequisicaoDTO alunoRequisicaoDTO) throws SQLException {

        Aluno aluno = alunoMapper.paraEntidade(alunoRequisicaoDTO);
        Aluno salvo = alunoRepository.createAluno(aluno);

        return alunoMapper.paraRespostaDTO(salvo);


    }

    public List<AlunoRespostaDTO> listAll() throws SQLException {
        List<Aluno> alunos = alunoRepository.listAllAluno();

        return alunos.stream()
                .map(alunoMapper::paraRespostaDTO)
                .toList();
    }


    public AlunoRespostaDTO listId(int id) throws SQLException {
        Aluno aluno = alunoRepository.listAlunoId(id);
        return alunoMapper.paraRespostaDTO(aluno);


    }

    public void delete(int id) throws SQLException {
        alunoRepository.deleteAluno(id);

    }

    public AlunoRespostaDTO update(AlunoRequisicaoDTO alunoRequisicaoDTO, int id) throws SQLException {
        Aluno aluno = alunoMapper.paraEntidade(alunoRequisicaoDTO);
        aluno.setId(id);

        Aluno salvo = alunoRepository.updateAluno(aluno, aluno.getId());
        return alunoMapper.paraRespostaDTO(salvo);
    }
}
