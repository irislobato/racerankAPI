package com.example.racerankAPI.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PilotoDto {
    private String nome;
    private String equipe;
    private LocalDateTime dataCadastro;
}
