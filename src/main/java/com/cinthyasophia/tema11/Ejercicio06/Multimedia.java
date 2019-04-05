package com.cinthyasophia.tema11.Ejercicio06;


import com.cinthyasophia.tema11.Util.Lib;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Multimedia {
    protected Lib lib= new Lib();
    protected String titulo;
    protected String autor;
    protected String formato;
    protected String year;

    public Multimedia(String titulo, String autor, Formato formato, String fecha) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato.name();
        setYear(fecha);
        this.year = getYear();
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

    public String getYear() {
        return year;
    }

    public void setYear(GregorianCalendar fecha) {
        SimpleDateFormat fechaFormat = new SimpleDateFormat("yyyy");
        this.year = fechaFormat.format(fecha);
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
