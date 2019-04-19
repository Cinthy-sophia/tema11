package com.cinthyasophia.tema11.Ejercicio07;

import java.util.ArrayList;

public class Estadio {
    private Zona[] zonas;
    private ArrayList<Partido> partidos;

    public Estadio(){
        zonas= new Zona[Zona.TipoZona.values().length];
        for (int i = 0; i < zonas.length; i++) {
            for (Zona.TipoZona z: Zona.TipoZona.values()) {
                zonas[i]= new Zona(z.toString());
            }
        }
    }


}
