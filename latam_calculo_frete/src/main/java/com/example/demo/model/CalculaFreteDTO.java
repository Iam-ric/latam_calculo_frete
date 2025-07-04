package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CalculaFreteDTO {

    private double peso;
    private double distancia;
    private String tipoTransporte;

    // Getters e setters
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getDistancia() { return distancia; }
    public void setDistancia(double distancia) { this.distancia = distancia; }

    public String getTipoTransporte() { return tipoTransporte; }
    public void setTipoTransporte(String tipoTransporte) { this.tipoTransporte = tipoTransporte; }
}
