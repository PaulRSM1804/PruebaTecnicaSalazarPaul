package com.vehiculo.Vehiculo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PicoYPlacaController {

    @GetMapping("/canCirculate")
    public String canCirculate(
            @RequestParam String licensePlate, 
            @RequestParam String date, 
            @RequestParam String time) {

        Vehiculo vehiculo = new Vehiculo(licensePlate);
        boolean canCirculate = PicoYPlacaPredictor.canCirculate(vehiculo, date, time);
        String provincia = vehiculo.getProvincia();
        
        if (canCirculate) {
            return "El vehículo con placa: " + vehiculo.getPlaca() + " puede circular. Provincia: " + provincia;
        } else {
            return "El vehículo con placa: " + vehiculo.getPlaca() + " NO puede circular. Provincia: " + provincia;
        }
    }
}

