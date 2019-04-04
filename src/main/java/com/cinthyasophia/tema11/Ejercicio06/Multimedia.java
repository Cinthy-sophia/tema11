package com.cinthyasophia.tema11.Ejercicio06;


import java.util.GregorianCalendar;
import java.util.Objects;

public class Multimedia {

    protected String titulo;
    protected String autor;
    protected String formato;
    protected GregorianCalendar year;

    public Multimedia(String titulo, String autor, Formato formato, GregorianCalendar year) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato.name();
        this.year = year;
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

    public GregorianCalendar getYear() {
        return year;
    }

    public void setYear(GregorianCalendar year) {
        this.year = year;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multimedia that = (Multimedia) o;
        return Objects.equals(titulo, that.titulo) &&
                Objects.equals(autor, that.autor);
    }

    @Override
    public String toString() {
        return "\nTitulo:" + titulo +
                "\nAutor:" + autor +
                "\nFormato:" + formato +
                "\nAño:" + year;
    }
}
