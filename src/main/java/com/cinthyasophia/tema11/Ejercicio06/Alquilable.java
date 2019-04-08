package com.cinthyasophia.tema11.Ejercicio06;

import java.util.GregorianCalendar;

public abstract class Alquilable extends Multimedia {
    private int precio;
    private GregorianCalendar fechaAlquiler;

    public Alquilable(String titulo, String autor, String formato, int year) {
        super(titulo, autor, formato, year);
        this.fechaAlquiler= null;
        this.precio= 0;

    }

    @Override
    public void setFechaAlquiler(String fecha) {
        this.fechaAlquiler= lib.getFecha(fecha);
    }

    @Override
    public GregorianCalendar getFechaAlquiler() {
        return fechaAlquiler;
    }

    @Override
    public void setPrecio(int precio) {
        this.precio= precio;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "\nPrecio:" + precio +
                "\nFechaAlquiler:" + fechaAlquiler;
    }
}
