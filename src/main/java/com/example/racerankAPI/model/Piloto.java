package com.example.racerankAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long piloto_id;
    private String nome;
    private String equipe;
    private LocalDateTime data_cadastro;
}
