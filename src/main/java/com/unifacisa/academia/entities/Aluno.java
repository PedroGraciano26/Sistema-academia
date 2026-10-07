package com.unifacisa.academia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aluno")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAluno;

    @Column(nullable = false)
    private String nome;
    private String telefone;
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano planos;

//    @OneToMany(mappedBy = "aluno")
//    private List<Treino> treinos = new ArrayList<>();
//
//        @ManyToMany
//        @JoinTable(
//            name = "aluno_professor",
//            joinColumns = @JoinColumn(name = "aluno_id"),
//            inverseJoinColumns = @JoinColumn(name = "professor_id")
//        )
//        private List<Professor> professores = new ArrayList<>();


}
