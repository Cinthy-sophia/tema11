package com.cinthyasophia.tema11.Ejercicio06;

import com.cinthyasophia.tema11.Util.Lib;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Socio {
    private Lib lib= new Lib();
    private static int id;
    private int nif;
    private String nombre;
    private GregorianCalendar fechaNac;
    private String poblacion;
    private int edad;

    public Socio(String nombre, String fechaNac, String poblacion) {
        ++id;
        this.nif = id;
        this.nombre = nombre;
        this.fechaNac = lib.getFecha(fechaNac);
        this.poblacion = poblacion;
        this.edad= lib.getEdad(this.fechaNac);
    }

    public int getNif() {
        return nif;
    }
    public String getNombre() {
        return nombre;
    }

    public GregorianCalendar getFechaNac() {
        return fechaNac;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public int getEdad(){
        return edad;
    }

    @Override
    public String toString() {
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        return  "\nNIF:" + nif +
                "\nNombre:" + nombre +
                "\nFecha de nacimiento:" + format.format(fechaNac.getTime()) +
                "\nPoblacion:" + poblacion +
                "\nEdad:" + edad;
    }
}
