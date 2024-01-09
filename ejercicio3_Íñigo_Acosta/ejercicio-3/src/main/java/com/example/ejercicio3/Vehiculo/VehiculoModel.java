package com.example.ejercicio3.Vehiculo;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
public class VehiculoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private Double precioAlquiler;

    public VehiculoModel(){}

    public VehiculoModel(Long id, String marca, String modelo, Double precioAlquiler) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precioAlquiler = precioAlquiler;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(Double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
}
