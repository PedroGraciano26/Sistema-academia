package com.unifacisa.academia.services;


import com.unifacisa.academia.entities.Aluno;
import com.unifacisa.academia.entities.Plano;
import com.unifacisa.academia.repositories.AlunoRepository;
import com.unifacisa.academia.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    private PlanoRepository planosRepository;

    public Aluno cadastrarAluno(Aluno aluno) {

        if (aluno.getPlanos() != null) {

            Integer idPlano = aluno.getPlanos().getIdPlano();

            Plano plano = planosRepository.findById(idPlano)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Plano não encontrado"
                    ));

            aluno.setPlanos(plano);
        }

        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno atualizarAluno(Integer id, Aluno dados){
        Aluno existente = alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));

        if (dados.getNome() != null) {
            existente.setNome(dados.getNome());
        }
        if (dados.getTelefone() != null) {
            existente.setTelefone(dados.getTelefone());
        }
        if (dados.getEndereco() != null) {
            existente.setEndereco(dados.getEndereco());
        }
        return alunoRepository.save(existente);

    }

    public void deletarAluno(Integer id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aluno não encontrado"
                ));

        if (aluno.getPlanos() != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Aluno possui um plano vinculado ao seu cadastro. Remova o plano antes."
            );
        }

        alunoRepository.delete(aluno);
    }
}
