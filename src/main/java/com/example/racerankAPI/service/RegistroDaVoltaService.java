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

    public RegistroDaVolta salvar(RegistroDaVolta registroDaVolta) {
        return registroDaVoltaRepository.save(registroDaVolta);
    }

    public List<RegistroDaVolta> listarTodos() {
        return registroDaVoltaRepository.findAll();
    }

    public Optional<RegistroDaVolta> buscarPorId(Long id) {
        return registroDaVoltaRepository.findById(id);
    }

    public List<RegistroDaVolta> buscarPorPiloto(Long pilotoId) {
        return registroDaVoltaRepository.findByPilotoId(pilotoId);
    }

    public List<RegistroDaVolta> rankingDaPista(Long pistaId) {
        return registroDaVoltaRepository.findByPistaIdOrderByTempoMilissegundosAsc(pistaId);
    }

    public void excluir(Long id) {
        registroDaVoltaRepository.deleteById(id);
    }
}
