package com.cinthyasophia.tema11.Ejercicio06;


import com.cinthyasophia.tema11.Util.Lib;

import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Multimedia  implements Alquilar{
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

    public boolean equals(Object o) {
        Multimedia that = (Multimedia) o;
        return Objects.equals(titulo, that.titulo) &&
                Objects.equals(autor, that.autor);
    }

    @Override
    public String toString() {
        return  "\nTitulo: " + titulo +
                "\nAutor: " + autor +
                "\nFormato: " + formato +
                "\nAño: " + year;
    }

    @Override
    public void setFechaAlquiler(String fecha) {
    }

    @Override
    public GregorianCalendar getFechaAlquiler() {
        return null;
    }

    @Override
    public void setFechaDevolucion(String fecha) {
    }

    @Override
    public GregorianCalendar getFechaDevolucion() {
        return null;
    }

    @Override
    public boolean isAlquilado() {
        return false;
    }

    @Override
    public void setPrecio(int precio) {

    }

    @Override
    public int getPrecio() {
        return 0;
    }

    public static class ComparatorYear implements Comparator<Multimedia>{//Compara los multimedias por año.
        @Override
        public int compare(Multimedia multimedia, Multimedia t1) {
            return multimedia.getYear()-t1.getYear();
        }
    }
    public static class ComparatorTitulo implements Comparator<Multimedia>{//Compara los multimedia por titulo.
        @Override
        public int compare(Multimedia multimedia, Multimedia t1) {
            return multimedia.getTitulo().compareTo(t1.getTitulo());
        }
    }

}
