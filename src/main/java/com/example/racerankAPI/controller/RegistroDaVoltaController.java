package com.example.racerankAPI.controller;

import com.example.racerankAPI.dto.RegistroDaVoltaDto;
import com.example.racerankAPI.model.RegistroDaVolta;
import com.example.racerankAPI.service.PilotoService;
import com.example.racerankAPI.service.PistaService;
import com.example.racerankAPI.service.RegistroDaVoltaService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro")
public class RegistroDaVoltaController {
    private final RegistroDaVoltaService registroDaVoltaService;
    private final PilotoService pilotoService;
    private final PistaService pistaService;


    public RegistroDaVoltaController(RegistroDaVoltaService registroDaVoltaService, PilotoService pilotoService, PistaService pistaService) {
        this.registroDaVoltaService = registroDaVoltaService;
        this.pilotoService = pilotoService;
        this.pistaService = pistaService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<RegistroDaVolta> registrarVolta(@RequestBody RegistroDaVoltaDto dto){
        RegistroDaVolta voltaRegistrada = registroDaVoltaService.registrarVolta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(voltaRegistrada);
    }

    @GetMapping
    public List<RegistroDaVolta> listarTodos(){
        return registroDaVoltaService.listarTodos();
    }
    @GetMapping("/{id}")
    public RegistroDaVolta buscarPorId(@PathVariable Long id){
        return registroDaVoltaService.buscarPorId(id);
    }
    @GetMapping("/piloto/{id}")
    public List<RegistroDaVolta> buscarPorPiloto(@PathVariable Long id){
        return registroDaVoltaService.buscarPorPiloto(id);
    }
    @GetMapping("/ranking/{pistaId}")
    public ResponseEntity<List<RegistroDaVolta>> rankingDaPista(@PathVariable Long pistaId){
        List<RegistroDaVolta> ranking = registroDaVoltaService.rankingDaPista(pistaId);

        return ResponseEntity.ok(ranking);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        registroDaVoltaService.delete(id);
    }
}
