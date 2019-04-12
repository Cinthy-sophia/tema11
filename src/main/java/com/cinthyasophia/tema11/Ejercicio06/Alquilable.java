package com.cinthyasophia.tema11.Ejercicio06;

import java.text.SimpleDateFormat;
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
        setAlquilado(true);
    }
    public void setFechaDevolucion(String fecha) {
        this.fechaDevolucion= lib.getFecha(fecha);
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

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    public int getPrecio() {
        return precio;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public String toString() {
        String alquilado;
        String fechaAl;
        String fechaDev;
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");

        if (isAlquilado()){
            alquilado= "ALQUILADO";
            fechaAl=format.format(fechaAlquiler.getTime());
            fechaDev=format.format(fechaDevolucion.getTime());

        }else{
            alquilado= "DISPONIBLE";
            fechaAl= "";
            fechaDev= "";

        }


        return  super.toString()+
                "\n"+ alquilado +
                "\nPrecio: " + precio +
                "\nFecha de alquiler: " + fechaAl+
                "\nFecha de devolucion: " + fechaDev;
    }

}
