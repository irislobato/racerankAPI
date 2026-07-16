package com.example.racerankAPI.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RegistroDaVolta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private Piloto piloto;

    @OneToMany
    private Pista pista;
    private Long tempo_milissegundos;
    private LocalDateTime data_volta;
}
