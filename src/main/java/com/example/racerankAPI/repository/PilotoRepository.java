package com.example.racerankAPI.repository;

import com.example.racerankAPI.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;

//Todo o CRUD é criado por padrão
public interface PilotoRepository extends JpaRepository<Piloto, Long> {
}
