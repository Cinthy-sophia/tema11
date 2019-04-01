package com.cinthyasophia.tema11.Ejercicio05;

public class Espada extends Item{
    public Espada(){
        super();
        material= Materiales.HIERRO.name();
        durabilidad= Materiales.HIERRO.getDurabilidad();
    }
    @Override
    public boolean isApilable() {
        return super.isApilable();
    }

    public int getDurabilidad(){
        return durabilidad;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Espada{" +
                "material='" + material + '\'' +
                ", durabilidad=" + durabilidad +
                ", apilable=" + apilable +
                '}';
    }
}
