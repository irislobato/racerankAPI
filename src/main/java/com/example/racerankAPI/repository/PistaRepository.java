package com.example.racerankAPI.repository;

import com.example.racerankAPI.model.Pista;
import org.springframework.data.jpa.repository.JpaRepository;

//Todo o CRUD é criado por padrão
public interface PistaRepository extends JpaRepository<Pista, Long> {
}
