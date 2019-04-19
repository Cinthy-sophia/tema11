package com.cinthyasophia.tema11.Ejercicio07;

public class EntradaVIP extends Entrada implements VIP {
    protected boolean vip;

    public EntradaVIP(Partido partido, Asiento asiento) {
        super(partido, asiento);
    }
    /*public int[] getCombinacion() {
        int aux;
        int cont;
        //llena el array fichas de numeros aleatorios entre en 1 y el 49
        for (int i = 0; i < fichas.length ; i++) {
            fichas[i]= i+1;
        }

        cont= fichas.length-1;

        for (int i = 0; i <combinacion.length ; i++) {

            numAl= rnd.nextInt(cont);
            combinacion[i] = fichas[numAl];
            aux=fichas[numAl];
            fichas[numAl]= fichas[cont];
            fichas[cont]=aux;
            cont--;

        }
        combinacion=lib.ordernarCombinacion(combinacion);
        return combinacion;//Devuelve el vector ordenado

    }*/

    @Override
    public boolean isVIP() {
        return vip;
    }
}
