package com.cinthyasophia.tema11.Ejercicio05;

public class Item {
    public enum Materiales{MADERA,HIERRO,PIEDRA,MINERAL,ORGANICO,DEFAULT}

    protected String material;
    protected boolean apilable;
    private final String NOMBRE= "Item";


    public Item() {
        this.material=Materiales.DEFAULT.name();
        apilable=false;

    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public boolean isApilable() {
        return apilable;
    }


    public String getMaterial() {
        return material;
    }

}

