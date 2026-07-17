package com.example.racerankAPI.controller;

import com.example.racerankAPI.dto.PistaDto;
import com.example.racerankAPI.model.Pista;
import com.example.racerankAPI.service.PistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pista")
public class PistaController {
    private final PistaService pistaService;


    public PistaController(PistaService pistaService) {
        this.pistaService = pistaService;
    }

    @PostMapping
    public ResponseEntity<Pista> adicionarPista(@RequestBody PistaDto dto) {
        Pista pistaCriada = pistaService.adicionarPista(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pistaCriada);
    }

    @GetMapping
    public List<Pista> listarPistas(){
        return pistaService.listarPistas();
    }

    @GetMapping("/{id}")
    public Pista buscarPistaPorId(@PathVariable Long id){
        return pistaService.buscarPistaPorId(id);
    }

    @PutMapping("/{id}")
    public Pista atualizarPista(@PathVariable Long id, @RequestBody PistaDto dto){
        return pistaService.updateAndCreatePista(id, dto);
    }
}
