package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.util.ArrayList;

public class Generador {
    Lib lib;
    private ArrayList<Integer> numerosSorteo;

    public Generador(){
        lib=new Lib();
    }
    private int[] bombo(int numFichas, int tamCombinacion){
        return lib.getCombinacion(numFichas,tamCombinacion);
    }
    protected ArrayList<Integer> generarNumerosSorteo(int cantidadEntradasPorPartido, int sizeCombinacion){
        int[] num;
        ArrayList<Integer> numerosSorteo= new ArrayList<>();
        num=lib.getCombinacion(cantidadEntradasPorPartido,sizeCombinacion);

        for (int n: num) {
            numerosSorteo.add(n);
        }
        return numerosSorteo;
    }

    protected String generarCodigoVIP(){
        EntradaVIP prueba;
        int aleatorioL;
        String letra;
        int[] numeros= new int[COMBINACION_VIP_SIZE];
        StringBuilder s;
        String cod;
        boolean validado= true;
        do {
            s= new StringBuilder();
            aleatorioL= lib.aleatorio(65,90);
            letra=String.valueOf(Character.toChars(aleatorioL));
            numeros=lib.getCombinacion(CANTIDAD_FICHAS,numeros.length-1);

            for (int numero : numeros) {
                s.append(numero);
            }
            s.append(letra);
            cod= s.toString();

            for (Entrada vip: entradasVendidas) {
                if (vip.isVIP()){
                    prueba= (EntradaVIP) vip;
                    if (prueba.getPasswordVIP().equals(cod)){
                        validado= false;

                    }

                }
            }
        }while(!validado);
        return cod;
    }

}
