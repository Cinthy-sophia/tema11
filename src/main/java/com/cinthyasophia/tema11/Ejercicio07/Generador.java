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

    private int[] bombo(int numFichas, int tamCombinacion){
        return lib.getCombinacion(numFichas,tamCombinacion);
    }

    protected ArrayList<Integer> generarNumerosSorteo(int cantidadEntradasPorPartido, int sizeCombinacion){
        int[] num;
        num= bombo(cantidadEntradasPorPartido,sizeCombinacion);

        for (int n: num) {
            numerosSorteo.add(n);
        }
        return numerosSorteo;
    }


}
