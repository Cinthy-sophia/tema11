package com.cinthyasophia.tema11.Ejercicio07;

import java.util.Objects;

public class Entrada implements VIP {
    private static int id;
    private final double PRECIO_BASE= 30;

    protected int codEntrada;
    protected Partido partido;
    protected Asiento asiento;
    protected double precio;

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Entrada(Partido partido, Asiento asiento) {
        ++id;
        codEntrada=id;
        this.partido = partido;
        this.asiento = asiento;
        precio= PRECIO_BASE;

    }
    public Entrada(){
        ++id;
        codEntrada=id;
        this.partido = null;
        this.asiento = null;
        precio= PRECIO_BASE;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCodEntrada() {
        return codEntrada;
    }

    public Partido getPartido() {
        return partido;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    @Override
    public boolean equals(Object o) {
        Entrada entrada = (Entrada) o;
        return Double.compare(entrada.precio, precio) == 0 &&
                Objects.equals(partido, entrada.partido) &&
                Objects.equals(asiento, entrada.asiento);
    }

    @Override
    public String toString() {
        return String.format("Código: %-5s",codEntrada)+ partido.toString()+
                "\n"+asiento.toString()+ "\n\u001B[1mPrecio: "+precio+"\u001B[0m";
    }

    @Override
    public boolean isVIP() {
        return false;
    }
}
