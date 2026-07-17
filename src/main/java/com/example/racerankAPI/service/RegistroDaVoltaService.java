package com.example.racerankAPI.service;

import com.example.racerankAPI.model.RegistroDaVolta;
import com.example.racerankAPI.repository.RegistroDaVoltaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroDaVoltaService {

    @Autowired
    private RegistroDaVoltaRepository registroDaVoltaRepository;

    public RegistroDaVoltaService(RegistroDaVoltaRepository registroDaVoltaRepository) {
        this.registroDaVoltaRepository = registroDaVoltaRepository;
    }


    //Create
    public RegistroDaVolta salvar(RegistroDaVolta registroDaVolta) {

        return registroDaVoltaRepository.save(registroDaVolta);
    }

    //Read All
    public List<RegistroDaVolta> listarTodos() {
        return registroDaVoltaRepository.findAll();
    }

    //Read By ID
    public Optional<RegistroDaVolta> buscarPorId(Long id) {
        return registroDaVoltaRepository.findById(id);
    }

    //Read by PilotoId
    public List<RegistroDaVolta> buscarPorPiloto(Long pilotoId) {
        return registroDaVoltaRepository.findByPilotoId(pilotoId);
    }

    //Read BY PistaId
    public List<RegistroDaVolta> rankingDaPista(Long pistaId) {
        return registroDaVoltaRepository.findByPistaIdOrderByTempoMilissegundosAsc(pistaId);
    }

    //Delete
    public void delete(Long id) {
        registroDaVoltaRepository.deleteById(id);
    }
}
