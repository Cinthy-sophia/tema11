package com.cinthyasophia.tema11.Ejercicio05;

public class Madera extends Apilable{
    private final String NOMBRE= "MADERA";

    public Madera(){
        super();
        material= Materiales.MADERA.name();
    }

    @Override
    public String getNOMBRE() {
        return NOMBRE;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Madera:" +
                "material:" + material  +
                "apilable:" + apilable;
    }
}
