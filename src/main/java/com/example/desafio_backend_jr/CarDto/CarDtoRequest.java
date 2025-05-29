package com.example.desafio_backend_jr.CarDto;

import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;


public record CarDtoRequest(Long id,String proprietario, String cpf, String placa) {

}
