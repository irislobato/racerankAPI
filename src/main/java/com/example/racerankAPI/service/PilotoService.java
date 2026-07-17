package com.example.racerankAPI.service;
import com.example.racerankAPI.dto.PilotoDto;
import com.example.racerankAPI.model.Piloto;
import com.example.racerankAPI.repository.PilotoRepository;
import com.example.racerankAPI.repository.RegistroDaVoltaRepository;
import org.springframework.stereotype.Service;

@Service
public class PilotoService {
    private final PilotoRepository pilotoRepository;
    private final RegistroDaVoltaRepository registroDaVoltaRepository;


    public PilotoService(PilotoService pilotoRepository, RegistroDaVoltaRepository registroDaVoltaRepository) {
        this.pilotoRepository = pilotoRepository;
        this.registroDaVoltaRepository = registroDaVoltaRepository;
    }
}
// ======================= CREATE =========================
public Piloto adicionarPiloto(PilotoDto dto){
    if(dto.getNome() == null || dto.getNome().isEmpty())
        throw new IllegalArgumentException("O campo do nome do piloto deve ser preenchido.");
    if(dto.getNome() == null || dto.getNome().isEmpty())
        throw new IllegalArgumentException("O campo do nome do piloto deve ser preenchido.");
}
}

