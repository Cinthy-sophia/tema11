package com.cinthyasophia.tema11.Ejercicio07;

import java.util.ArrayList;

public class Estadio {
    private ArrayList<Zona> zonas;
    private ArrayList<Partido> partidos;

    public Estadio(){
        partidos= new ArrayList<>();
        zonas= new ArrayList<>();
        for (int i = 0; i < Zona.TipoZona.values().length; i++) {
            for (Zona.TipoZona z: Zona.TipoZona.values()) {
                zonas.add(new Zona(z.toString()));
            }
        }

    }

    public ArrayList<Zona> getZonas() {
        return zonas;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
}
