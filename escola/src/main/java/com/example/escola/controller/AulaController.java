package com.example.escola.controller;

import com.example.escola.dto.aluno.AlunoRequisicaoDTO;
import com.example.escola.dto.aluno.AlunoRespostaDTO;
import com.example.escola.service.AlunoService;
import com.example.escola.service.AulaService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/aula")
public class AulaController {


    private final AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }
/*

    @PostMapping
    public AlunoRespostaDTO createAluno(@RequestBody AlunoRequisicaoDTO alunoRequisicaoDTO) throws SQLException {
        return alunoService.createAluno(alunoRequisicaoDTO);

    }


    @GetMapping("/listarTodos")
    public List<AlunoRespostaDTO> listAllAlunos() throws SQLException {
        return alunoService.listAll();

    }

    @GetMapping("/listarPorId/{id}")
    public AlunoRespostaDTO listAlunoId(@PathVariable("id") int id) throws SQLException {
        return alunoService.listId(id);

    }

    @PutMapping("/atualizar/{id}")
    public AlunoRespostaDTO update(@RequestBody AlunoRequisicaoDTO alunoRequisicaoDTO, @PathVariable("id")int id)throws SQLException{
        return alunoService.update(alunoRequisicaoDTO, id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteAluno(@PathVariable("id")int id) throws SQLException {
        alunoService.delete(id);
    }*/

}
