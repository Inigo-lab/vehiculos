package com.example.ejercicio3.Repository;


import com.example.ejercicio3.Vehiculo.VehiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoModel,Long> {

    List<VehiculoModel> findByMarca(String marca);
    List<VehiculoModel> findByModelo(String modelo);
    List<VehiculoModel> findByMarcaAndModelo(String marca, String modelo);
    List<VehiculoModel> findByPrecioAlquilerLessThan(double precioAlquiler);
}
