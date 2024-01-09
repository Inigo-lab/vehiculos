package com.example.ejercicio3.Controllers;

import com.example.ejercicio3.Service.VehiculoService;
import com.example.ejercicio3.Vehiculo.VehiculoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin({"*"})
@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;

    @PostMapping()
    public VehiculoModel guardar(@RequestBody VehiculoModel vehiculoModel){
        return vehiculoService.guardarVehiculo(vehiculoModel);
    }

    @GetMapping("/by-marca/{marca}")
    public List<VehiculoModel> buscarMarca(@PathVariable String marca){
        return vehiculoService.buscarMarca(marca);
    }

    @GetMapping("/by-modelo/{modelo}")
    public List<VehiculoModel> buscarModelo(@PathVariable String modelo){
        return vehiculoService.buscarModelo(modelo);
    }

    @GetMapping("/{marca}/{modelo}")
    public List<VehiculoModel> buscarMarcaYModelo(@PathVariable String marca,@PathVariable String modelo){
        return vehiculoService.buscarMarcaModelo(marca,modelo);
    }

    @GetMapping("/less-than/{precioAlquiler}")
    public List<VehiculoModel> buscarPrecio(@PathVariable double precioAlquiler){
        return vehiculoService.buscarPrecioInferior(precioAlquiler);
    }

    @GetMapping("/importe-total/{precio}/{dias}")
    public double importe(@PathVariable double precio, @PathVariable double dias){
        return vehiculoService.calcularImporte(precio,dias);
    }

    @GetMapping("/todos")
    public List<VehiculoModel> todosVehiculos(){
        return vehiculoService.listarVehiculos();
    }

}
