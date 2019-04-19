package com.cinthyasophia.tema11.Ejercicio07;

public class Entrada {
    private static int id;
    private final double PRECIO_BASE= 30;

    protected int codEntrada;
    protected Partido partido;
    protected Asiento asiento;
    protected double precio;

    public Entrada(Partido partido, Asiento asiento) {
        ++id;
        codEntrada=id;
        this.partido = partido;
        this.asiento = asiento;
        precio= PRECIO_BASE;
        if (partido.getTipo().equals(Partido.TipoPartido.ALTA_AFLUENCIA.name())){
            precio *= 130/100;
        }else if(partido.getTipo().equals(Partido.TipoPartido.BAJA_AFLUENCIA.name())){
            precio *= 75/100;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public int getCodEntrada() {
        return codEntrada;
    }

    public Partido getPartido() {
        return partido;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    @Override
    public String toString() {
        return "Codigo:" + codEntrada +"\t"+ partido.toString() +
                asiento.toString();
    }
}
