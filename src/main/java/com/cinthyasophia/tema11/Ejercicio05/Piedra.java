package com.cinthyasophia.tema11.Ejercicio05;

public class Piedra extends Apilable {
    public Piedra() {
        super();
        material= Materiales.PIEDRA.name();
        durabilidad= Materiales.PIEDRA.getDurabilidad();
    }

    @Override
    public int getDurabilidad() {
        return durabilidad;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Piedra{" +
                "cantidadApilable=" + cantidadApilable +
                ", material='" + material + '\'' +
                ", durabilidad=" + durabilidad +
                ", apilable=" + apilable +
                '}';
    }
}
