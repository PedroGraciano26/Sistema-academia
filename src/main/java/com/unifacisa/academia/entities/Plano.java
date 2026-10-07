package com.unifacisa.academia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="planos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPlano;

    @Column
    private String nome;
    private Double valor;
    private String duracao;

    @OneToMany(mappedBy = "planos")
    @JsonIgnore
    private List<Aluno> alunos = new ArrayList<>();
}
