package com.cinthyasophia.tema11.Ejercicio05;

public class Item {
    protected static final int CANTIDAD_DEFAULT_MAX= 64;
    protected static final int CANTIDAD_DEFAULT_MIN=16;

    protected String color;
    protected int cantidadApilable;

    public Item(String color) {
        this.color=color;
        cantidadApilable= CANTIDAD_DEFAULT_MAX;

    }
}
