package com.example.desafio_backend_jr.repository;

import com.example.desafio_backend_jr.model.CarTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarTable, Long> {
}
