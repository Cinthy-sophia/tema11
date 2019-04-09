package com.cinthyasophia.tema11.Ejercicio06;


import com.cinthyasophia.tema11.Util.Lib;
import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class Multimedia {
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

    public abstract boolean setFechaAlquiler(String fecha);
    public abstract GregorianCalendar getFechaAlquiler();
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
}
