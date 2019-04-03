package com.cinthyasophia.tema11.Ejercicio05;

public class Piedra extends Apilable {
    private final String NOMBRE="PIEDRA";

    public Piedra() {
        super();
        material= Materiales.PIEDRA.name();
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
        return "Piedra{" +
                "cantidadApilable=" + cantidadApilable +
                ", material='" + material + '\'' +
                ", apilable=" + apilable +
                '}';
    }
}
