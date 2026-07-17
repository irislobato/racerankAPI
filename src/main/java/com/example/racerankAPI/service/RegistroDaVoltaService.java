package com.example.racerankAPI.service;

import com.example.racerankAPI.dto.RegistroDaVoltaDto;
import com.example.racerankAPI.exception.ArgumentoInvalidoException;
import com.example.racerankAPI.exception.RecursoNaoEncontradoException;
import com.example.racerankAPI.exception.TempoInvalidoException;
import com.example.racerankAPI.model.Piloto;
import com.example.racerankAPI.model.Pista;
import com.example.racerankAPI.model.RegistroDaVolta;
import com.example.racerankAPI.repository.PilotoRepository;
import com.example.racerankAPI.repository.PistaRepository;
import com.example.racerankAPI.repository.RegistroDaVoltaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroDaVoltaService {

    @Autowired
    private final RegistroDaVoltaRepository registroDaVoltaRepository;
    private final PilotoRepository pilotoRepository;
    private final PistaRepository pistaRepository;

    public RegistroDaVoltaService(RegistroDaVoltaRepository registroDaVoltaRepository, PilotoRepository pilotoRepository, PistaRepository pistaRepository) {
        this.registroDaVoltaRepository = registroDaVoltaRepository;
        this.pilotoRepository = pilotoRepository;
        this.pistaRepository = pistaRepository;
    }

    //Create
    public RegistroDaVolta registrarVolta(RegistroDaVoltaDto dto) {
        if(dto.getTempoMilissegundos() == null || dto.getTempoMilissegundos() < 0){
            throw new TempoInvalidoException("O tempo de volta deve ser maior do que zero.");
        }
        Piloto piloto = pilotoRepository.findById(dto.getPilotoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Piloto com este ID não foi encontrado"));
        Pista pista = pistaRepository.findById(dto.getPistaId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("A pista com este ID não foi encontrada, "));

        RegistroDaVolta novaVolta = new RegistroDaVolta();
        novaVolta.setPiloto(piloto);
        novaVolta.setPista(pista);
        novaVolta.setTempoMilissegundos(dto.getTempoMilissegundos());
        novaVolta.setDataVolta(LocalDateTime.now());


        return registroDaVoltaRepository.save(novaVolta);
    }

    //Read All
    public List<RegistroDaVolta> listarTodos() {
        return registroDaVoltaRepository.findAll();
    }

    //Read By ID
    public RegistroDaVolta buscarPorId(Long id) {
        return registroDaVoltaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("O registro de volta de ID" + id + "não foi encontrado."));
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
        RegistroDaVolta volta = buscarPorId(id);
        registroDaVoltaRepository.deleteById(id);
    }
}
