package com.cinthyasophia.tema11.Ejercicio06;

import java.time.Period;
import java.util.GregorianCalendar;

public class Multimedia {

    protected String titulo;
    protected String autor;
    protected String formato;
    protected Period duracion;
    protected GregorianCalendar year;

    public Multimedia(String titulo, String autor, String formato, Period duracion, GregorianCalendar year) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.duracion = duracion;
        this.year = year;
    }
}
