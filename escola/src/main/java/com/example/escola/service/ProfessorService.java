package com.example.escola.service;

import com.example.escola.dto.professor.ProfessorRequiscaoDTO;
import com.example.escola.dto.professor.ProfessorRespostaDTO;
import com.example.escola.mapper.ProfessorMapper;
import com.example.escola.model.Professor;
import com.example.escola.repository.ProfessorRepository;

import java.sql.SQLException;
import java.util.List;

public class ProfessorService {

    private final ProfessorRepository professorRepository;

    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    public ProfessorRespostaDTO createAluno(ProfessorRequiscaoDTO professorRequiscaoDTO) throws SQLException {

        Professor professor = professorMapper.paraEntidade(professorRequiscaoDTO);
        Professor salvo = professorRepository.create(professor);

        return professorMapper.paraRespostaDTO(salvo);


    }

    public List<ProfessorRespostaDTO> listAll() throws SQLException {
        List<Professor> professores = professorRepository.listAll();

        return professores.stream()
                .map(professorMapper::paraRespostaDTO)
                .toList();
    }


    public ProfessorRespostaDTO listId(int id) throws SQLException {
        Professor professor = professorRepository.listId(id);
        return professorMapper.paraRespostaDTO(professor);
    }

    public void delete(int id) throws SQLException {
        professorRepository.delete(id);

    }

    public ProfessorRespostaDTO update(ProfessorRequiscaoDTO professorRequiscaoDTO, int id) throws SQLException {
        Professor professor = professorMapper.paraEntidade(professorRequiscaoDTO);
        professor.setId(id);

        Professor salvo = professorRepository.update(professor, professor.getId());
        return professorMapper.paraRespostaDTO(salvo);
    }


}
