package com.cinthyasophia.tema11.Ejercicio06;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public abstract class Alquilable extends Multimedia {
    protected int precio;
    private GregorianCalendar fechaAlquiler;
    protected boolean alquilado;


    public Alquilable(String titulo, String autor, String formato, int year) {
        super(titulo, autor, formato, year);
        this.fechaAlquiler= null;
        this.precio= 0;
        this.alquilado= false;

    }

    public boolean setFechaAlquiler(String fecha) {
        if (fecha==null){
            alquilado= false;
        } else {
            this.fechaAlquiler= lib.getFecha(fecha);
            alquilado = true;
        }
        return alquilado;
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
                "\nFecha de alquiler:" + format.format(fechaAlquiler.getTime());
    }
}
