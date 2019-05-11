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

    protected void setOcupado(boolean ocupado) {
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
        String ocupadoS = this.ocupado ? "\u001B[31m [OCUPADO] \u001B[0m" : "\u001B[32m [LIBRE] \u001B[0m";
        return String.format("Asiento: \u001B[1m%02d\u001B[0m ",numero)+" Zona:" + "\u001B[1m "+zona.getTipo()+"\u001B[0m" + " Fila:" + "\u001B[1m "+fila+"\u001B[0m"+ ocupadoS;
    }
}
