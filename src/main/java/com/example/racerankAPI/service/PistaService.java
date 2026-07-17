package com.example.racerankAPI.service;

import com.example.racerankAPI.dto.PistaDto;
import com.example.racerankAPI.exception.ArgumentoInvalidoException;
import com.example.racerankAPI.exception.RecursoNaoEncontradoException;
import com.example.racerankAPI.model.Pista;
import com.example.racerankAPI.repository.PistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  PistaService {

    private final PistaRepository pistaRepository;

    public PistaService(PistaRepository pistaRepository) {
        this.pistaRepository = pistaRepository;
    }

    //Create
    public Pista adicionarPista(PistaDto dto) {

        //Tratamento de erros
        if(dto.getNome() == null || dto.getNome().isEmpty()){
            throw new ArgumentoInvalidoException("O campo do nome deve ser preenchido!");
        }
        if(dto.getLocalizacao() == null || dto.getLocalizacao().isEmpty()){
            throw new ArgumentoInvalidoException("O campo da localização deve ser preenchido!");
        }
        if(dto.getExtensaoMetros() <= 0){
            throw new ArgumentoInvalidoException("A extensão da pista deve ser maior do que 0 metros!");
        }

        //Se passou pelo tratamento de erros, cria uma nova pista
        Pista novaPista = new Pista();

        novaPista.setNome(dto.getNome().trim().toUpperCase());
        novaPista.setLocalizacao(dto.getLocalizacao().trim().toUpperCase());
        novaPista.setExtensaoMetros(dto.getExtensaoMetros());

        return pistaRepository.save(novaPista);
    }

    //Read all
    public List<Pista> listarPistas() {
        return pistaRepository.findAll();
    }

    //Read by ID
    public Pista buscarPistaPorId(Long id) {
        return pistaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("A pista com id " + id + " não foi encontrada."));
    }

    //Update
    public Pista uptadeAndCreatePista(Long id, Pista pistaAtualizada) {
        Optional<Pista> pistaBuscando = pistaRepository.findById(id);


        //Se a pista com o ID fornecido não existir, throw error
        if(pistaBuscando.isEmpty()){
            throw new RecursoNaoEncontradoException("A pista com id " + id + " não foi encontrada.");
        }

        Pista pistaExistente = pistaBuscando.get();

        //Atualização parcial dos campos
        if(pistaAtualizada.getNome() != null && !pistaAtualizada.getNome().trim().isEmpty()){
            pistaExistente.setNome(pistaAtualizada.getNome().toUpperCase().trim());
        }

        if(pistaAtualizada.getLocalizacao() != null && !pistaAtualizada.getLocalizacao().trim().isEmpty()){
            pistaExistente.setLocalizacao(pistaAtualizada.getLocalizacao().toUpperCase().trim());
        }

        if(pistaAtualizada.getExtensaoMetros() > 0){
            pistaExistente.setExtensaoMetros(pistaAtualizada.getExtensaoMetros());
        }

        return pistaRepository.save(pistaExistente);
    }

}