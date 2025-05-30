package com.example.desafio_backend_jr.service;

import com.example.desafio_backend_jr.CarDto.CarDtoRequest;
import com.example.desafio_backend_jr.CarDto.CarDtoResponse;
import com.example.desafio_backend_jr.model.CarTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;

    }

    public CarTable getData(CarDtoRequest carDtoRequest){
        String placa = carDtoRequest.placa();
        String url = "https://my.api.mockaroo.com/veiculos?key=55ad1cd0&placa="+ placa;

        CarTable responseEntity = restTemplate.getForObject(url, CarTable.class);
        CarTable response = new CarTable();
        response.setId(carDtoRequest.id());
        response.setCpf(carDtoRequest.cpf());
        response.setProprietario(carDtoRequest.proprietario());
        response.setPlaca(carDtoRequest.placa());
        response.setMarca(responseEntity.getMarca());
        response.setModelo(responseEntity.getModelo());
        response.setChassi(responseEntity.getChassi());
        response.setLicenciado(responseEntity.getLicenciado());

        return response;
    }
}
