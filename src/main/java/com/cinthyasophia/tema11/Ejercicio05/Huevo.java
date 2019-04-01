package com.cinthyasophia.tema11.Ejercicio05;

public class Huevo extends Apilable {

    public Huevo(){
        super();
        material= Materiales.ORGANICO.name();
        durabilidad= Materiales.ORGANICO.getDurabilidad();
        cantidadApilable= CANTIDAD_DEFAULT_MIN;
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
    public int getDurabilidad() {
        return durabilidad;
    }

    @Override
    public String toString() {
        return "Huevo{" +
                "cantidadApilable=" + cantidadApilable +
                ", material='" + material + '\'' +
                ", durabilidad=" + durabilidad +
                ", apilable=" + apilable +
                '}';
    }
}
