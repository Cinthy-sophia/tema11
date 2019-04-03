package com.cinthyasophia.tema11.Ejercicio05;

public class Pico extends Item {
    private final String NOMBRE= "PICO";

    public Pico() {
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
        return "Pico{" +
                "material='" + material + '\'' +
                ", apilable=" + apilable +
                '}';
    }
}
