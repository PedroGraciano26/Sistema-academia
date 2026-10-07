package com.unifacisa.academia.controllers;

import com.unifacisa.academia.entities.Planos;
import com.unifacisa.academia.services.PlanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanosController {

    @Autowired
    private PlanosService planosService;

    @PostMapping
    public Planos salvar(@RequestBody Planos planos){
        return planosService.cadastrarPlanos(planos);
    }

    @GetMapping
    public List<Planos> listar(){
        return planosService.listarPlanos();
    }

    @PutMapping("/{id}")
    public Planos atualizar(@PathVariable Integer id, @RequestBody Planos planos){
        return planosService.atualizarPlanos(id, planos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        planosService.deletarPlano(id);
    }

}
