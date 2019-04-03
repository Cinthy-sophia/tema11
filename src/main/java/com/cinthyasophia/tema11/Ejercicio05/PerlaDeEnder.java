package com.cinthyasophia.tema11.Ejercicio05;

public class PerlaDeEnder extends Apilable {
    public final String NOMBRE= "PERLA DE ENDER";

    public PerlaDeEnder(){
        super();
        cantidadApilable= CANTIDAD_DEFAULT_MIN;
        material= Materiales.MINERAL.name();
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
    public int getCantidadApilable() {
        return cantidadApilable;
    }

    @Override
    public String toString() {
        return "PerlaDeEnder{" +
                "cantidadApilable=" + cantidadApilable +
                ", material='" + material + '\'' +
                ", apilable=" + apilable +
                '}';
    }
}
