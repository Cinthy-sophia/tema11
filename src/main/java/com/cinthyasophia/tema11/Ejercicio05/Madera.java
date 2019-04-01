package com.cinthyasophia.tema11.Ejercicio05;

public class Madera extends Apilable{
    public Madera(){
        super();
        material= Materiales.MADERA.name();
        durabilidad= Materiales.MADERA.getDurabilidad();
    }
    @Override
    public int getDurabilidad(){
        return durabilidad;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Madera{" +
                "cantidadApilable=" + cantidadApilable +
                ", material='" + material + '\'' +
                ", durabilidad=" + durabilidad +
                ", apilable=" + apilable +
                '}';
    }
}
