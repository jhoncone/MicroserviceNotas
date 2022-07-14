package com.example.arqui.NotasService.repository;

import com.example.arqui.NotasService.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
}
