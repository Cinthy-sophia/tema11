package com.cinthyasophia.tema11.Ejercicio07;

public class GeneradorVIP extends Generador {
    private final int CANTIDAD_FICHAS=100;
    private final int COMBINACION_VIP_SIZE=5;

    public GeneradorVIP(){
       super();
    }
    protected String generarCodigoVIP(){
        int aleatorioL;
        String letra;
        int[] numeros= new int[COMBINACION_VIP_SIZE];
        StringBuilder s;
        String cod;

        s= new StringBuilder();
        aleatorioL= lib.aleatorio(65,90);
        letra=String.valueOf(Character.toChars(aleatorioL));
        numeros=lib.getCombinacion(CANTIDAD_FICHAS,numeros.length-1);

        for (int numero : numeros) {
            s.append(numero);
        }
        s.append(letra);
        cod= s.toString();

        return cod;
    }
}
