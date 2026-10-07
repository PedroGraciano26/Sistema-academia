package com.unifacisa.academia.services;


import com.unifacisa.academia.entities.Alunos;
import com.unifacisa.academia.entities.Planos;
import com.unifacisa.academia.repositories.AlunosRepository;
import com.unifacisa.academia.repositories.PlanosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunosService {

    @Autowired
    private AlunosRepository alunoRepository;
    private PlanosRepository planosRepository;

    public Alunos cadastrarAluno(Alunos aluno) {

        if (aluno.getPlanos() != null) {

            Integer idPlano = aluno.getPlanos().getIdPlano();

            Planos plano = planosRepository.findById(idPlano)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Plano não encontrado"
                    ));

            aluno.setPlanos(plano);
        }

        return alunoRepository.save(aluno);
    }

    public List<Alunos> listarAlunos(){
        return alunoRepository.findAll();
    }

    public Alunos atualizarAluno(Integer id, Alunos dados){
        Alunos existente = alunoRepository.findById(id)
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
        Alunos aluno = alunoRepository.findById(id)
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
