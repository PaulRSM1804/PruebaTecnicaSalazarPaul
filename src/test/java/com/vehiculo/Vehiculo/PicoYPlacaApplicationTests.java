package com.vehiculo.Vehiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PicoYPlacaApplicationTests {

    @Test
    public void testCanCirculate() {
        Vehiculo vehiculo1 = new Vehiculo("ABC1231"); // Placa terminada en 1, provincia Azuay
        Vehiculo vehiculo2 = new Vehiculo("GBC1235"); // Placa terminada en 5, provincia Guayas
        
        // Lunes, placa terminada en 1, dentro del horario de restricción
        boolean result = PicoYPlacaPredictor.canCirculate(vehiculo1, "2024-09-30", "07:30");
        assertEquals(false, result);
        assertEquals("Azuay", vehiculo1.getProvincia());

        // Lunes, placa terminada en 1, fuera del horario de restricción
        result = PicoYPlacaPredictor.canCirculate(vehiculo1, "2024-09-30", "10:00");
        assertEquals(true, result);

        // Miércoles, placa terminada en 5, dentro del horario de restricción
        result = PicoYPlacaPredictor.canCirculate(vehiculo2, "2024-10-02", "08:30");
        assertEquals(false, result);
        assertEquals("Guayas", vehiculo2.getProvincia());
    }
}

