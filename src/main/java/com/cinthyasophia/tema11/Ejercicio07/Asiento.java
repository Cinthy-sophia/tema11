package com.cinthyasophia.tema11.Ejercicio07;

public class Asiento {
    private int numero;
    private String zona;
    private int fila;
    private boolean ocupado;

    public Asiento(int numero, String zona, int fila){
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

    public String getZona() {
        return zona;
    }

    @Override
    public String toString() {

        if (ocupado){
            return "\nAsiento: " + numero + " Z: " + zona + " F: " + fila + "\u001B[31mOCUPADO\u001B[0m";

        }else{
            return "\nAsiento: " + numero + " Z: " + zona + " F: " + fila + "\u001B[32mLIBRE\u001B[0m";
        }
    }
}
