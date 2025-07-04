package com.example.demo.service;

import com.example.demo.exception.ExceptionCalculoFrete;
import com.example.demo.model.CalculaFreteDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculaFreteService {

    public double calcularFrete(CalculaFreteDTO request) {
        double peso = request.getPeso();
        double distancia = request.getDistancia();
        String tipo = request.getTipoTransporte();

        if (peso <= 0 || distancia <= 0) {
            throw new ExceptionCalculoFrete("Peso e distância devem ser positivos.");
        }

        return switch (tipo.toLowerCase()) {
            //Transporte Normal Valor base: R$ 5,00. Adicionar R$ 0,50 por quilômetro. Adicionar R$ 2,00 por quilo.
            case "normal" -> 5.00 + (0.50 * distancia) + (2.00 * peso);

            //Transporte Expresso Valor base: R$ 10,00. Adicionar R$ 1,00 por quilômetro. Adicionar R$ 5,00 por quilo.
            case "expresso" -> 10.00 + (distancia) + (5.00 * peso);
            //Caso os dados fornecidos sejam inválidos (ex.: peso ou distância negativos), retornar uma mensagem de erro apropriada.
            default -> throw new ExceptionCalculoFrete("Tipo de transporte inválido.");
        };
    }
}
