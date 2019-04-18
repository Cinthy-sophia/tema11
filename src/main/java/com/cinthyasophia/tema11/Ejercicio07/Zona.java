package com.cinthyasophia.tema11.Ejercicio07;

public class Zona {
    protected final int CANTIDAD_ASIENTOS= 100;
    protected final int CANTIDAD_FILAS= 5;

    private static int id;
    protected int codZona;
    protected Asiento[][] asientos;

    public Zona(){
        id++;
        codZona= id;
        asientos= new Asiento[CANTIDAD_FILAS][CANTIDAD_ASIENTOS/CANTIDAD_FILAS];
    }

    public int getCodZona() {
        return codZona;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }
}
