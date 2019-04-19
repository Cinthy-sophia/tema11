package com.cinthyasophia.tema11.Ejercicio07;

public class Asiento {
    private int numero;
    private String zona;
    private int fila;

    public Asiento(int numero, String zona, int fila){
        this.numero= numero;
        this.fila= fila;
        this.zona= zona;
    }

    public int getNumero() {
        return numero;
    }

    public int getFila() {
        return fila;
    }

    public String getZona() {
        return zona;
    }
}
