package com.example.racerankAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RegistroDaVoltaDto {

    @JsonProperty("piloto_id")
    private Long pilotoId;

    @JsonProperty("pista_id")
    private Long pistaId;

    private Long tempoMilissegundos;
    private LocalDateTime dataVolta;
}