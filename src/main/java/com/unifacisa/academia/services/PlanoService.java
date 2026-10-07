package com.unifacisa.academia.services;

import com.unifacisa.academia.entities.Plano;
import com.unifacisa.academia.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public Plano cadastrarPlanos(Plano plano){
        return planoRepository.save(plano);
    }

    public List<Plano> listarPlanos(){
        return planoRepository.findAll();
    }

    public Plano atualizarPlanos(Integer id, Plano dados){
        Plano existente = planoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano não encontrado"));
        if (dados.getNome() != null) {
            existente.setNome(dados.getNome());
        }
        if (dados.getDuracao() != null) {
            existente.setDuracao(dados.getDuracao());
        }
        if (dados.getValor() != null) {
            existente.setValor(dados.getValor());
        }
        return planoRepository.save(existente);
    }

    public void deletarPlano(Integer id){
        if (!planoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prontuário não encontrado");
        }
        planoRepository.deleteById(id);
    }

}
