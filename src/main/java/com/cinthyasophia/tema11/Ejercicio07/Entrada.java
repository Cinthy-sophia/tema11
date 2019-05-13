package com.cinthyasophia.tema11.Ejercicio07;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Entrada implements VIP {
    private static int id;
    private final double PRECIO_BASE= 30;

    protected int codEntrada;
    protected GregorianCalendar fechaVenta;
    protected Partido partido;
    protected Asiento asiento;
    protected double precio;
    public Entrada(Partido partido, Asiento asiento) {
        ++id;
        codEntrada=id;
        this.partido = partido;
        this.asiento = asiento;
        precio= PRECIO_BASE;
        fechaVenta= new GregorianCalendar();

    }

    public Entrada(){
        ++id;
        codEntrada=id;
        this.partido = null;
        this.asiento = null;
        precio= PRECIO_BASE;
        fechaVenta= new GregorianCalendar();
    }

    public GregorianCalendar getFechaVenta() {
        return fechaVenta;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
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
        return  Objects.equals(partido, entrada.partido) &&
                Objects.equals(asiento, entrada.asiento);
    }

    @Override
    public String toString() {
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");

        return String.format("Numero identificador: %-5s",codEntrada)+ partido.toString()+
                "\n"+asiento.toString()+"\nFecha de venta: "+format.format(fechaVenta.getTime());
    }

    @Override
    public boolean isVIP() {
        return false;
    }
}
