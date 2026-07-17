package com.example.racerankAPI.service;

import com.example.racerankAPI.dto.PistaDto;
import com.example.racerankAPI.exception.ArgumentoInvalidoException;
import com.example.racerankAPI.model.Pista;
import com.example.racerankAPI.repository.PistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
            throw new ArgumentoInvalidoException("O campo do nome deve ser preenchido!")
        }
        if(dto.getLocalizacao() == null || dto.getLocalizacao().isEmpty()){
            throw new ArgumentoInvalidoException("O campo da localização deve ser preenchido")
        }
        if(dto.getExtensaoMetros() <= 0){
            throw new ArgumentoInvalidoException("A extensão da pista deve ser maior do que 0 metros1")
        }

        //Se passou pelo tratamento de erros, cria uma nova pista
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
        pista.setExtensaoMetros(pistaAtualizada.getExtensaoMetros());

        return pistaRepository.save(pista);
    }

}