package com.example.desafio_backend_jr.controller;

import com.example.desafio_backend_jr.CarDto.CarDtoRequest;
import com.example.desafio_backend_jr.model.CarTable;
import com.example.desafio_backend_jr.repository.CarRepository;
import com.example.desafio_backend_jr.service.ApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class CarController {

    private CarRepository carRepository;
    private ApiService apiService;

    public CarController(CarRepository carRepository, ApiService apiService){
        this.apiService = apiService;
        this.carRepository = carRepository;
    }

    @PostMapping
    public ResponseEntity<String> postCar(@RequestBody CarDtoRequest dtoRequest){
        CarTable response = apiService.getData(dtoRequest);

        carRepository.save(response);
        return ResponseEntity.ok("Carro cadastrado com sucesso");
    }

}
