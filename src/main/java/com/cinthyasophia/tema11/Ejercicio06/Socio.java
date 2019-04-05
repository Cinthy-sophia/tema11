package com.cinthyasophia.tema11.Ejercicio06;

import com.cinthyasophia.tema11.Util.Lib;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Socio {
    private Lib lib= new Lib();
    private int nif;
    private String nombre;
    private GregorianCalendar fechaNac;
    private String poblacion;
    private int edad;

    public Socio(int nif, String nombre, String fechaNac, String poblacion) {
        this.nif = nif;
        this.nombre = nombre;
        this.fechaNac = lib.getFecha(fechaNac);
        this.poblacion = poblacion;
        this.edad= getEdad(this.fechaNac);

    }

    public int getEdad(GregorianCalendar fechaNac){
        int year= fechaNac.get(Calendar.YEAR);
        int month= fechaNac.get(Calendar.MONTH);
        int day= fechaNac.get(Calendar.DAY_OF_MONTH);

        LocalDate birth= LocalDate.of(year,month,day);
        LocalDate now = LocalDate.now();
        Period p;
        p= Period.between(birth, now);

        if (birth.isBefore(now)){
            return p.getYears()-1;
        }else{
            return p.getYears();
        }
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
