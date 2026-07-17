package com.example.racerankAPI.service;

import com.example.racerankAPI.dto.PistaDto;
import com.example.racerankAPI.model.Pista;
import com.example.racerankAPI.repository.PistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  PistaService {

    private final PistaRepository pistaRepository;

    public PistaService(PistaRepository pistaRepository) {
        this.pistaRepository = pistaRepository;
    }

    public Pista adicionarPista(PistaDto dto) {
        Pista novaPista = new Pista();

        novaPista.setNome(dto.getNome().trim().toUpperCase());
        novaPista.setLocalizacao(dto.getLocalizacao().trim().toUpperCase());
        novaPista.setExtensaoMetros(dto.getExtensaoMetros());

        return pistaRepository.save(novaPista);
    }

    public List<Pista> listarPistas() {
        return pistaRepository.findAll();
    }

    public Pista buscarPistaPorId(Long id) {
        return pistaRepository.findById(id).orElse(null);
    }

    public Pista atualizarPista(Long id, Pista pistaAtualizada) {

        Pista pista = buscarPistaPorId(id);

        if (pista == null) {
            return null;
        }

        pista.setNome(pistaAtualizada.getNome());
        pista.setLocalizacao(pistaAtualizada.getLocalizacao());
        pista.setExtensao_metros(pistaAtualizada.getExtensao_metros());

        return pistaRepository.save(pista);
    }

}