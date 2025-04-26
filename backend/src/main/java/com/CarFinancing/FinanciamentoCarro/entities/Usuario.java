package com.CarFinancing.FinanciamentoCarro.entities;

import com.CarFinancing.FinanciamentoCarro.enums.Papel;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Papel papel;

    @OneToMany(mappedBy = "cliente")
    private List<Financiamento> financiamentosSolicitados;

    @OneToMany(mappedBy = "funcionario")
    private List<Financiamento> financiamentosAnalisados;

    @OneToMany(mappedBy = "gerente")
    private List<Financiamento> financiamentosAnalisadosPeloGerente;
}
