package com.cinthyasophia.tema11.Ejercicio05;

public abstract class Apilable extends Item{
    protected static final int CANTIDAD_DEFAULT_MAX= 64;
    protected static final int CANTIDAD_DEFAULT_MIN=16;

    protected int cantidadApilable;

    public Apilable() {
        apilable= true;
        cantidadApilable= CANTIDAD_DEFAULT_MAX;
    }

    @Override
    public boolean isApilable() {
        return apilable;
    }


    public int getCantidadApilable() {
        return cantidadApilable;
    }
}
