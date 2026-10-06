package com.unifacisa.academia.controllers;

import com.unifacisa.academia.entities.Alunos;
import com.unifacisa.academia.services.AlunosService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    private AlunosService alunoService;

    @PostMapping
    public Alunos cadastrarAluno(@RequestBody Alunos aluno){
        return alunoService.cadastrarAluno(aluno);
    }

    @GetMapping
    public List<Alunos> listar(){
        return alunoService.listarAlunos();
    }

    @PutMapping("/{id}")
    public Alunos atualizarCadastro(@PathVariable Integer id, @RequestBody Alunos alunos){
        return alunoService.atualizarAluno(id,alunos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCadastro(@PathVariable Integer id){
        alunoService.deletarAluno(id);

    }
}
