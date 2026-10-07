package com.unifacisa.academia.controllers;

import com.unifacisa.academia.entities.Aluno;
import com.unifacisa.academia.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno){
        return alunoService.cadastrarAluno(aluno);
    }

    @GetMapping
    public List<Aluno> listar(){
        return alunoService.listarAlunos();
    }

    @PutMapping("/{id}")
    public Aluno atualizarCadastro(@PathVariable Integer id, @RequestBody Aluno alunos){
        return alunoService.atualizarAluno(id,alunos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCadastro(@PathVariable Integer id){
        alunoService.deletarAluno(id);

    }
}
