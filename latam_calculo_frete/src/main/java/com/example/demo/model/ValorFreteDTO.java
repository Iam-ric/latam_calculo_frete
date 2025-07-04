package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ValorFreteDTO {

    private double valorFrete;

    public ValorFreteDTO(double valorFrete) {
        this.valorFrete = valorFrete;
    }
}
