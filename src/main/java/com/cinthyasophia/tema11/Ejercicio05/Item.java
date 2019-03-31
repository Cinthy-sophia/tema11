package com.cinthyasophia.tema11.Ejercicio05;

public class Item {
    //public enum Colores{MARRON,GRIS,BLANCO}

    private String color;
    protected boolean apilable;


    public Item() {
        this.color="color";
        apilable=false;
    }

    public boolean isApilable() {
        return apilable;
    }

    public String getColor() {
        return color;
    }

}

