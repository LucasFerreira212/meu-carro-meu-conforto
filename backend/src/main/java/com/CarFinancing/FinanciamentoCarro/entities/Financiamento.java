package com.CarFinancing.FinanciamentoCarro.entities;

import com.CarFinancing.FinanciamentoCarro.enums.StatusFinanciamento;
import jakarta.persistence.*;

@Entity
public class Financiamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario cliente;

    @ManyToOne
    private Usuario funcionario;

    @ManyToOne
    private Usuario gerente;

    private double valorEntrada;
    private int quantidadeParcelas;
    private double taxaJuros;
    private double valorFinal;

    @Enumerated(EnumType.STRING)
    private StatusFinanciamento status;
}
