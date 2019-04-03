package com.cinthyasophia.tema11.Ejercicio05;

public class Espada extends Item{
    private final String NOMBRE="ESPADA";

    public Espada(){
        super();
        material= Materiales.HIERRO.name();
    }

    @Override
    public String getNOMBRE() {
        return NOMBRE;
    }

    @Override
    public boolean isApilable() {
        return super.isApilable();
    }


    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Espada:" +
                "material:" + material +
                "apilable:" + apilable;
    }
}
