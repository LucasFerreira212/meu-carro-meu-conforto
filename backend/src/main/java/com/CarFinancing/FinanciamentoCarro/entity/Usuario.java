package com.CarFinancing.FinanciamentoCarro.entity;

import com.CarFinancing.FinanciamentoCarro.enums.Papel;
import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Papel papel;
}
