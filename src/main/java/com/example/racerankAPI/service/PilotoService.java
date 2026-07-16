package com.example.racerankAPI.service;

import com.example.racerankAPI.model.Piloto;
import org.springframework.stereotype.Service;

@Service
public class PilotoService {
    private final PilotoService pilotoRepository;

    public PilotoService(com.example.racerankAPI.service.PilotoService pilotoRepository) {
        this.pilotoRepository = pilotoRepository;
    }
    // ======================= CREATE =========================
    public Piloto adicionarPiloto(){
    }
}
