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

    /**
     * Obtiene un numero de la combinacion generada y lo devuelve.
     * @param codEntrada
     * @return int
     */
    protected int getNumSorteo(int codEntrada){
        return numerosSorteo.remove(codEntrada);

    }

    /**
     * Recibe el numero de sorteo de la entrada, lo comprueba y lo reingresa a la combinacion.
     * @param numSorteo
     * @return
     */
    protected boolean returnNumSorteo(int numSorteo){
        for (int i : numerosSorteo) {
            if (i== numSorteo || numSorteo<=0){
                return false;
            }

        }
        return numerosSorteo.add(numSorteo);
    }

}
