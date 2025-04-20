package com.CarFinancing.FinanciamentoCarro.entity;

import com.CarFinancing.FinanciamentoCarro.enums.StatusFinanciamento;
import jakarta.persistence.*;

@Entity
public class Financiamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Usuario cliente;

    private Usuario funcionario;

    private Usuario gerente;

    private double valorEntrada;
    private int quantidadeParcelas;
    private double taxaJuros;
    private double valorFinal;

    @Enumerated(EnumType.STRING)
    private StatusFinanciamento status;
}
