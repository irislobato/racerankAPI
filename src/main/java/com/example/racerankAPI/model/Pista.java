package com.example.racerankAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Pista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pista_id;
    private String nome;
    private String localizacao;
    private double extensao_metros;
}
