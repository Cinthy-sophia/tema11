package com.cinthyasophia.tema11.Ejercicio07;

public class Zona {
    public enum TipoZona{A,B,C,D,E,VIP}

    protected final int CANTIDAD_ASIENTOS= 100;
    protected final int CANTIDAD_FILAS= 5;
    private static int id;

    protected int codZona;
    protected String tipo;
    protected Asiento[][] asientos;

    public Zona(){
        id++;
        codZona= id;
        asientos= new Asiento[CANTIDAD_FILAS][CANTIDAD_ASIENTOS/CANTIDAD_FILAS];
    }

    public String getTipo() {
        return tipo;
    }

    public int getCodZona() {
        return codZona;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }
}
