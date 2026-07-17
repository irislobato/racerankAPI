package com.example.racerankAPI.controller;

import com.example.racerankAPI.dto.PilotoDto;
import com.example.racerankAPI.model.Piloto;
import com.example.racerankAPI.model.RegistroDaVolta;
import com.example.racerankAPI.service.PilotoService;
import com.example.racerankAPI.service.RegistroDaVoltaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piloto")
public class PilotoController {
   private final PilotoService pilotoService;
   private final RegistroDaVoltaService registroDaVoltaService;

   public PilotoController(PilotoService pilotoService, RegistroDaVoltaService registroDaVoltaService) {
       this.pilotoService = pilotoService;
       this.registroDaVoltaService = registroDaVoltaService;
   }
   @PostMapping
   public ResponseEntity<Piloto>adicionarPiloto(@RequestBody PilotoDto dto){
       Piloto pilotoCriado = pilotoService.adicionarPiloto(dto);
       return ResponseEntity.status(HttpStatus.CREATED).body(pilotoCriado);
   }
   @GetMapping
    public List<Piloto> buscarTodosPilotos(){
       return pilotoService.buscarTodosPilotos();
   }
   @GetMapping("/{id}")
    public Piloto buscarPilotoPorId(@PathVariable Long id){
       return pilotoService.buscarPilotoPorId(id);
   }
   @PutMapping("/{id}")
    public Piloto atualizarPiloto(@PathVariable Long id, @RequestBody PilotoDto dto){
       return pilotoService.atualizarPiloto(id, dto);
   }
   @DeleteMapping("/{id}")
    public void deletarPiloto(@PathVariable Long id){
       pilotoService.deletarPiloto(id);
   }
}
