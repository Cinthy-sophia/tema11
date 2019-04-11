package com.cinthyasophia.tema11.Ejercicio06;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.GregorianCalendar;

public abstract class Alquilable extends Multimedia {
    protected int precio;
    private GregorianCalendar fechaAlquiler;
    private GregorianCalendar fechaDevolucion;
    protected boolean alquilado;


    public Alquilable(String titulo, String autor, String formato, int year) {
        super(titulo, autor, formato, year);
        this.fechaDevolucion= null;
        this.fechaAlquiler= null;
        this.precio= 0;
        this.alquilado= false;

    }

    public void setFechaAlquiler(String fecha) {
        this.fechaAlquiler= lib.getFecha(fecha);
        alquilado = true;
    }
    public void setFechaDevolucion(String fecha) {
        this.fechaDevolucion= lib.getFecha(fecha);
        alquilado = false;
    }

    public GregorianCalendar getFechaDevolucion(){
        return fechaDevolucion;
    }
    public GregorianCalendar getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setPrecio(int precio) {
        this.precio= precio;
    }

    public int getPrecio() {
        return precio;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public String toString() {
        String alquilado;
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");

        if (isAlquilado()){
            alquilado= "ALQUILADO";
        }else{
            alquilado= "DISPONIBLE";

        }

        return  super.toString()+
                "\n"+ alquilado +
                "\nPrecio:" + precio +
                "\nFecha de alquiler:" + format.format(fechaAlquiler.getTime())+
                "\nFecha de devolucion:" + format.format(fechaDevolucion.getTime());
    }
    public static class ComparatorFecha implements Comparator<Alquilable> {


        @Override
        public int compare(Alquilable alquilable, Alquilable t1) {
            return alquilable.fechaAlquiler.compareTo(t1.fechaAlquiler);
        }
    }
}
