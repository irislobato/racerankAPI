package com.example.racerankAPI.repository;

import com.example.racerankAPI.model.RegistroDaVolta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Todo o CRUD é criado por padrão
public interface RegistroDaVoltaRepository extends JpaRepository<RegistroDaVolta, Long> {

    //Buscar todas as voltas de um piloto em específico
    List<RegistroDaVolta> findByPilotoId(Long pilotoId);

    //Busca a lista dos tempos das corridas em determinada pista da menor para a maior
    List<RegistroDaVolta> findByPistaIdOrderByTempoMilissegundosAsc(Long pistaId);
}
