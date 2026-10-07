package com.unifacisa.academia.controllers;

import com.unifacisa.academia.entities.Plano;
import com.unifacisa.academia.services.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PostMapping
    public Plano salvar(@RequestBody Plano planos){
        return planoService.cadastrarPlanos(planos);
    }

    @GetMapping
    public List<Plano> listar(){
        return planoService.listarPlanos();
    }

    @PutMapping("/{id}")
    public Plano atualizar(@PathVariable Integer id, @RequestBody Plano planos){
        return planoService.atualizarPlanos(id, planos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        planoService.deletarPlano(id);
    }

}
