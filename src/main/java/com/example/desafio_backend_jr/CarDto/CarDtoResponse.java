package com.example.desafio_backend_jr.CarDto;

public record CarDtoResponse(Long id,
                             String propretario,
                             String cpf,
                             String placa,
                             String marca,
                             String modelo,
                             String chassi,
                             Boolean licenciado
                             ) {
}
