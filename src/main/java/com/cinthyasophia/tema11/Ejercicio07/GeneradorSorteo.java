package com.cinthyasophia.tema11.Ejercicio07;

import java.util.ArrayList;

public class GeneradorSorteo extends Generador {
    private Partido partido;
    private ArrayList<Integer> numerosSorteo;
    //Generador generador;

    public GeneradorSorteo(Partido partido){
        this.partido= partido;
        numerosSorteo= new ArrayList<>();
        numerosSorteo= generarNumerosSorteo(partido.getCantidadEntradas(),partido.getCantidadEntradas()-1);
    }

    public Partido getPartido() {
        return partido;
    }

    protected int getNumSorteo(int codEntrada){
        return numerosSorteo.remove(codEntrada);

    }
    protected boolean returnNumSorteo(int numSorteo){
        for (int i:numerosSorteo) {
            if (i== numSorteo){
                return false;
            }

        }
        return numerosSorteo.add(numSorteo);
    }

}
