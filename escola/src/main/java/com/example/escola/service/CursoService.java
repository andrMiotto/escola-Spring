package com.example.escola.service;

import com.example.escola.dto.curso.CursoRequisicaoDTO;
import com.example.escola.dto.curso.CursoRespostaDTO;
import com.example.escola.dto.professor.ProfessorRequiscaoDTO;
import com.example.escola.dto.professor.ProfessorRespostaDTO;
import com.example.escola.mapper.CursoMapper;
import com.example.escola.mapper.ProfessorMapper;
import com.example.escola.model.Curso;
import com.example.escola.model.Professor;
import com.example.escola.repository.CursoRepository;
import com.example.escola.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CursoService {


    private final CursoRepository cursoRepository;

    private final CursoMapper cursoMapper;

    public CursoService(CursoRepository cursoRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }


    public CursoRespostaDTO create(CursoRequisicaoDTO cursoRequisicaoDTO) throws SQLException {

        Curso curso = cursoMapper.paraEntidade(cursoRequisicaoDTO);
        Curso salvo = cursoRepository.create(curso);

        List<String> professores = cursoRepository.findProfessorByCursoID(salvo.getId());

        return cursoMapper.paraRespostaDTO(salvo, professores);


    }

    public List<CursoRespostaDTO> listAll() throws SQLException {
        List<Curso> cursos = cursoRepository.listAll();

        return cursos.stream()
                .map(curso -> {
                    try {
                        List<String> professores = cursoRepository.findProfessorByCursoID(curso.getId());
                        return cursoMapper.paraRespostaDTO(curso, professores);
                    } catch (SQLException e) {
                        throw new RuntimeException("Erro ao buscar professores do curso: " + curso.getId());
                    }
                })
                .toList();
    }


    public CursoRespostaDTO listId(int id) throws SQLException {
        Curso curso = cursoRepository.listId(id);
        List<String> professores = cursoRepository.findProfessorByCursoID(curso.getId());


        return cursoMapper.paraRespostaDTO(curso, professores);
    }

    public void delete(int id) throws SQLException {
        cursoRepository.delete(id);

    }

    public CursoRespostaDTO update(CursoRequisicaoDTO cursoRequisicaoDTO, int id) throws SQLException {
        Curso curso = cursoMapper.paraEntidade(cursoRequisicaoDTO);
        curso.setId(id);

        Curso salvo = cursoRepository.update(curso, curso.getId());
        List<String> professores = cursoRepository.findProfessorByCursoID(curso.getId());

        return cursoMapper.paraRespostaDTO(salvo,professores);
    }

}
