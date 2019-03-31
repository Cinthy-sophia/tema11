package com.cinthyasophia.tema11.Ejercicio05;

public class Huevo extends Apilable {

    public Huevo(){
        super();
        cantidadApilable= CANTIDAD_DEFAULT_MIN;
    }

    @Override
    public int getCantidadApilable() {
        return this.cantidadApilable;
    }

    @Override
    public String toString() {
        return "Huevo{" +
                "cantidadApilable=" + cantidadApilable +
                ", apilable=" + apilable +
                '}';
    }
}
