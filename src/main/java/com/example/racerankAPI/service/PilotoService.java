package com.example.racerankAPI.service;

import com.example.racerankAPI.dto.PilotoDto;
import com.example.racerankAPI.exception.ArgumentoInvalidoException;
import com.example.racerankAPI.exception.ConflitoDeRecursoException;
import com.example.racerankAPI.exception.RecursoNaoEncontradoException;
import com.example.racerankAPI.model.Piloto;
import com.example.racerankAPI.model.Pista;
import com.example.racerankAPI.repository.PilotoRepository;
import com.example.racerankAPI.repository.RegistroDaVoltaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


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
        if (dto.getNome() == null || dto.getNome().trim().isEmpty()) {
            throw new ArgumentoInvalidoException("O campo do nome do piloto deve ser preenchido.");
        }
        if (dto.getEquipe() == null || dto.getEquipe().trim().isEmpty()) {
            throw new ArgumentoInvalidoException("O campo do equipe do piloto deve ser preenchido.");
        }

        Piloto novoPiloto = new Piloto();

        novoPiloto.setNome(dto.getNome().trim().toUpperCase());
        novoPiloto.setEquipe(dto.getEquipe().trim().toUpperCase());
        novoPiloto.setDataCadastro(LocalDateTime.now());

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
    public Piloto atualizarPiloto(Long id, PilotoDto pilotoAtualizado){

        Optional<Piloto> pilotoBuscando = pilotoRepository.findById(id);

        //Se o piloto com ID fornecido não existir, throw error
        if(pilotoBuscando.isEmpty()){
            throw new RecursoNaoEncontradoException("O piloto com id " + id + " não foi encontrado");
        }

        Piloto pilotoExistente = pilotoBuscando.get();

        //Atualização parcial dos campos
        if(pilotoAtualizado.getNome() != null && !pilotoAtualizado.getNome().trim().isEmpty()){
            pilotoExistente.setNome(pilotoAtualizado.getNome().toUpperCase().trim());
        }

        if(pilotoAtualizado.getEquipe() != null && !pilotoAtualizado.getEquipe().trim().isEmpty()){
            pilotoExistente.setEquipe(pilotoAtualizado.getEquipe().toUpperCase().trim());
        }

        return pilotoRepository.save(pilotoExistente);
    }

    // ========================== DELETE ===========================
    public void deletarPiloto(Long id){
        Piloto piloto = buscarPilotoPorId(id);

        if (!registroDaVoltaRepository.findByPilotoId(id).isEmpty()) {
        throw new ConflitoDeRecursoException("Não é possível excluir o piloto. Ele possui tempos de volta registrados no histórico.");
    }
        pilotoRepository.delete(piloto);
    }
}