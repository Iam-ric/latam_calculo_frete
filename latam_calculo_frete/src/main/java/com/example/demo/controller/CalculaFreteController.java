package com.example.demo.controller;

import com.example.demo.model.CalculaFreteDTO;
import com.example.demo.model.ValorFreteDTO;
import com.example.demo.service.CalculaFreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/frete")
public class CalculaFreteController {

    @Autowired
    private CalculaFreteService calculaFreteService;

    // Receber os dados de peso, distância e tipo de transporte via requisição HTTP
    @PostMapping("/calcular")
    public ValorFreteDTO calcularFrete(@RequestBody CalculaFreteDTO calculaFreteDTO) {
        double valor = calculaFreteService.calcularFrete(calculaFreteDTO);
        return new ValorFreteDTO(valor);
    }
}
