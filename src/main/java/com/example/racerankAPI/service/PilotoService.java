package com.example.racerankAPI.service;

import com.example.racerankAPI.dto.PilotoDto;
import com.example.racerankAPI.exception.ArgumentoInvalidoException;
import com.example.racerankAPI.exception.RecursoNaoEncontradoException;
import com.example.racerankAPI.model.Piloto;
import com.example.racerankAPI.repository.PilotoRepository;
import com.example.racerankAPI.repository.RegistroDaVoltaRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PilotoService {
    private final PilotoRepository pilotoRepository;
    private final RegistroDaVoltaRepository registroDaVoltaRepository;

    public PilotoService(PilotoRepository pilotoRepository, RegistroDaVoltaRepository registroDaVoltaRepository) {
            this.pilotoRepository = pilotoRepository;
            this.registroDaVoltaRepository = registroDaVoltaRepository;
        }

    // ======================= CREATE =========================
    public Piloto adicionarPiloto(PilotoDto dto) {
        if (dto.getNome() == null || dto.getNome().isEmpty())
            throw new ArgumentoInvalidoException("O campo do nome do piloto deve ser preenchido.");
        if (dto.getEquipe() == null || dto.getNome().isEmpty())
            throw new ArgumentoInvalidoException("O campo do equipe do piloto deve ser preenchido.");

        Piloto novoPiloto = new Piloto();

        novoPiloto.setNome(dto.getNome());
        novoPiloto.setEquipe(dto.getEquipe());

        return pilotoRepository.save(novoPiloto);
    }
    // ========================= READ ============================
    public List<Piloto> buscarTodosPilotos(){
        return pilotoRepository.findAll();
    }
    public Piloto buscarPilotoPorId(Long id){
        return pilotoRepository.findById(id).
                orElseThrow(() -> new RecursoNaoEncontradoException("O piloto de ID" + id + "não foi encontrado."));
    }
    // ========================== UPDATE ============================
    public Piloto atualizarPiloto(Long id, PilotoDto dto){
        Piloto pilotoBuscado = pilotoRepository.findById(id).
                orElseThrow(() -> new RecursoNaoEncontradoException("O piloto de ID" + id + "não foi encontrado."));

        if (dto.getNome() == null || dto.getNome().isEmpty())
            throw new ArgumentoInvalidoException("O campo do nome do piloto deve ser preenchido.");
        if (dto.getEquipe() == null || dto.getNome().isEmpty())
            throw new ArgumentoInvalidoException("O campo do equipe do piloto deve ser preenchido.");

        pilotoBuscado.setNome(dto.getNome());
        pilotoBuscado.setEquipe(dto.getEquipe());

        return pilotoRepository.save(pilotoBuscado);
    }
    // ========================== DELETE ===========================
    public void deletarPiloto(Long id){
        pilotoRepository.deleteById(id);
    }
}