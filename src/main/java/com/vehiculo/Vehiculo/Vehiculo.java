package com.vehiculo.Vehiculo;

import java.util.HashMap;
import java.util.Map;

public class Vehiculo {
    private String placa;
    private static final Map<Character, String> provinciaMap = new HashMap<>();

    static {
        provinciaMap.put('A', "Azuay");
        provinciaMap.put('B', "Bolívar");
        provinciaMap.put('U', "Cañar");
        provinciaMap.put('C', "Carchi");
        provinciaMap.put('H', "Chimborazo");
        provinciaMap.put('X', "Cotopaxi");
        provinciaMap.put('O', "El Oro");
        provinciaMap.put('E', "Esmeraldas");
        provinciaMap.put('W', "Galápagos");
        provinciaMap.put('G', "Guayas");
        provinciaMap.put('I', "Imbabura");
        provinciaMap.put('L', "Loja");
        provinciaMap.put('R', "Los Ríos");
        provinciaMap.put('M', "Morona Santiago");
        provinciaMap.put('N', "Napo");
        provinciaMap.put('O', "Orellana");
        provinciaMap.put('P', "Pichincha");
        provinciaMap.put('S', "Pastaza");
        provinciaMap.put('Y', "Santa Elena");
        provinciaMap.put('J', "Santo Domingo");
        provinciaMap.put('V', "Sucumbíos");
        provinciaMap.put('T', "Tungurahua");
        provinciaMap.put('Z', "Zamora Chinchipe");
    }

    // Constructor

    public Vehiculo() {
    }

    public Vehiculo(String placa) {
        this.placa = placa;
    }

    // Getters and Setters

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public int getUltimoDigito() {
        char ultimoCaracter = placa.charAt(placa.length() - 1);
        return Character.getNumericValue(ultimoCaracter);
    }

    public String getProvincia() {
        char primeraLetra = placa.charAt(0);
        return provinciaMap.getOrDefault(primeraLetra, "Desconocida");
    }
}
