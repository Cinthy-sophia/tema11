package com.cinthyasophia.tema11.Ejercicio06;


import com.cinthyasophia.tema11.Util.Lib;

import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class Multimedia implements Comparable<Multimedia>{
    protected Lib lib= new Lib();
    protected String titulo;
    protected String autor;
    protected String formato;
    protected int year;

    public Multimedia(String titulo, String autor, String formato, int year) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato ;
        this.year= year;
    }
    public Multimedia(String titulo,String autor){
        this(titulo,autor,null,0);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public abstract void setFechaAlquiler(String fecha);
    public abstract GregorianCalendar getFechaAlquiler();
    public abstract void setFechaDevolucion(String fecha);
    public abstract GregorianCalendar getFechaDevolucion();
    public abstract boolean isAlquilado();
    public abstract void setPrecio(int precio);
    public abstract int getPrecio();


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multimedia that = (Multimedia) o;
        return Objects.equals(titulo, that.titulo) &&
                Objects.equals(autor, that.autor);
    }

    @Override
    public String toString() {
        return  "\nTitulo:" + titulo +
                "\nAutor:" + autor +
                "\nFormato:" + formato +
                "\nAño:" + year;
    }

    @Override
    public int compareTo(Multimedia multimedia) {
        return this.getTitulo().compareTo(multimedia.getTitulo());
    }

    public static class ComparatorYear implements Comparator<Multimedia>{

        @Override
        public int compare(Multimedia multimedia, Multimedia t1) {
            return multimedia.getYear()-t1.getYear();
        }
    }
}
