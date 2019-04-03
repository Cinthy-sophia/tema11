package com.cinthyasophia.tema11.Ejercicio05;

public class Huevo extends Apilable {
    private final String NOMBRE= "HUEVO";

    public Huevo(){
        super();
        material= Materiales.ORGANICO.name();
        cantidadApilable= CANTIDAD_DEFAULT_MIN;
    }

    @Override
    public String getNOMBRE() {
        return NOMBRE;
    }

    @Override
    public int getCantidadApilable() {
        return cantidadApilable;
    }

    @Override
    public String getMaterial() {
        return material;
    }


    @Override
    public String toString() {
        return "Huevo{" +
                "cantidadApilable=" + cantidadApilable +
                ", material='" + material + '\'' +
                ", apilable=" + apilable +
                '}';
    }
}
