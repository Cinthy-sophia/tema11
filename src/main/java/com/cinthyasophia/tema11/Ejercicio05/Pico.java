package com.cinthyasophia.tema11.Ejercicio05;

public class Pico extends Item {

    public Pico() {
        super();
        material= Materiales.HIERRO.name();
        durabilidad= Materiales.HIERRO.getDurabilidad();
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
    public int getDurabilidad() {
        return durabilidad;
    }

    @Override
    public String toString() {
        return "Pico{" +
                "material='" + material + '\'' +
                ", durabilidad=" + durabilidad +
                ", apilable=" + apilable +
                '}';
    }
}
