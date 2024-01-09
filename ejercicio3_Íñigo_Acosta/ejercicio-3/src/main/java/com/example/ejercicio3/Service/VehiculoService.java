package com.example.ejercicio3.Service;

import com.example.ejercicio3.Repository.VehiculoRepository;
import com.example.ejercicio3.Vehiculo.VehiculoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;


    //Guardar vehiculos
    public VehiculoModel guardarVehiculo(VehiculoModel vehiculoModel){
        return vehiculoRepository.save(vehiculoModel);
    }

    //Buscar por marca
    public List<VehiculoModel> buscarMarca(String marca){
        return vehiculoRepository.findByMarca(marca);
    }

    //Buscar por modelo
    public List<VehiculoModel> buscarModelo(String modelo){
        return vehiculoRepository.findByModelo(modelo);
    }

    //Buscar por marca y modelo
    public List<VehiculoModel> buscarMarcaModelo(String marca,String modelo){
        return vehiculoRepository.findByMarcaAndModelo(marca,modelo);
    }

    //Buscar precios de alquiler de coches inferiores al precio
    public List<VehiculoModel> buscarPrecioInferior(double precioAlquiler){
        return vehiculoRepository.findByPrecioAlquilerLessThan(precioAlquiler);
    }

    public double calcularImporte(double precio,double dias){
        double total = precio*dias;
        return total;
    }

    public List<VehiculoModel> listarVehiculos(){
        return vehiculoRepository.findAll();
    }
}
