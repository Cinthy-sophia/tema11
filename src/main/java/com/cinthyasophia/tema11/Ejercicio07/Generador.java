package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.util.ArrayList;

public class Generador {
    Lib lib;
    private ArrayList<Integer> numerosSorteo;

    public Generador(){
        lib=new Lib();
        numerosSorteo= new ArrayList<>();
    }

    /**
     * Recibe la cantidad de fichas entre las que se hará el sorteo, y el tamano de la combinacion que se desea devolver.
     * Devuelve un array con la combinacion del sorteo.
     * @param numFichas
     * @param tamCombinacion
     * @return int[]
     */
    int[] bombo(int numFichas, int tamCombinacion){
        return lib.getCombinacion(numFichas,tamCombinacion);
    }

    /**
     * Recibe la cantidad de entradas que se venderan por partido, y el tamaño de la combinacion que se desea.
     * Devuelve un ArrayList de enteros con los numeros del sorteo.
     * @param cantidadEntradasPorPartido
     * @param sizeCombinacion
     * @return ArrayList<Integer>
     */
    protected ArrayList<Integer> generarNumerosSorteo(int cantidadEntradasPorPartido, int sizeCombinacion){
        int[] num;
        num= bombo(cantidadEntradasPorPartido,sizeCombinacion);

        for (int n: num) {
            numerosSorteo.add(n);
        }
        return numerosSorteo;
    }


}
