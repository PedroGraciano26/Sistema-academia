package com.unifacisa.academia.services;

import com.unifacisa.academia.entities.Planos;
import com.unifacisa.academia.repositories.PlanosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlanosService {

    @Autowired
    private PlanosRepository planoRepository;

    public Planos cadastrarPlanos(Planos plano){
        return planoRepository.save(plano);
    }

    public List<Planos> listarPlanos(){
        return planoRepository.findAll();
    }

    public Planos atualizarPlanos(Integer id, Planos dados){
        Planos existente = planoRepository.findById(id)
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
