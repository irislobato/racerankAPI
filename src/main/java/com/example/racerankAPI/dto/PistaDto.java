package com.example.racerankAPI.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PistaDto {
    private String nome;
    private String localizacao;
    private double extensaoMetros;
}
