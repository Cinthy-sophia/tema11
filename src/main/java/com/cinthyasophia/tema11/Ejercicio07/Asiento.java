package com.cinthyasophia.tema11.Ejercicio07;

public class Asiento {
    private int numero;
    private Zona zona;
    private int fila;
    private boolean ocupado;

    public Asiento(int numero, Zona zona, int fila){
        this.numero= numero;
        this.fila= fila;
        this.zona= zona;
        ocupado= false;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getNumero() {
        return numero;
    }

    public int getFila() {
        return fila;
    }

    public Zona getZona() {
        return zona;
    }

    @Override
    public String toString() {

        if (ocupado){
            return String.format("\nAsiento: %02d", numero) + " Zona: " + zona.getTipo() + " Fila: " + fila + "\u001B[31m OCUPADO \u001B[0m";

        }else{
            return String.format("\nAsiento: %02d",numero)+ " Zona: " + zona.getTipo() + " Fila: " + fila + "\u001B[31m LIBRE \u001B[0m";
        }
    }
}
