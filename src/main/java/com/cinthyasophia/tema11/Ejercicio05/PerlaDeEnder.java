package com.cinthyasophia.tema11.Ejercicio05;

public class PerlaDeEnder extends Apilable {

    public PerlaDeEnder(){
        super();
        cantidadApilable= CANTIDAD_DEFAULT_MIN;
        material= Materiales.MINERAL.name();
        durabilidad= Materiales.MINERAL.getDurabilidad();
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
    public int getCantidadApilable() {
        return cantidadApilable;
    }

    @Override
    public String toString() {
        return "PerlaDeEnder{" +
                "cantidadApilable=" + cantidadApilable +
                ", material='" + material + '\'' +
                ", durabilidad=" + durabilidad +
                ", apilable=" + apilable +
                '}';
    }
}
