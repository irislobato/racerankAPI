package com.example.racerankAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistroDaVoltaDto {

    @JsonProperty("piloto_id")
    private Long pilotoId;

    @JsonProperty("pista_id")
    private Long pistaId;

    private Long tempoMilissegundos;
}