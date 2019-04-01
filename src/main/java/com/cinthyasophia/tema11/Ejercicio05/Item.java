package com.cinthyasophia.tema11.Ejercicio05;

public class Item {
    public enum Materiales{MADERA(59),HIERRO(250),PIEDRA(59),MINERAL(561),ORGANICO(1),DEFAULT(50);
        private int durabilidad;

        Materiales(int durabilidad){
            this.durabilidad=durabilidad;
        }
        public int getDurabilidad() {
            return durabilidad;
        }
    }

    protected String material;
    protected int durabilidad;
    protected boolean apilable;


    public Item() {
        this.material=Materiales.DEFAULT.name();
        apilable=false;
        durabilidad=Materiales.DEFAULT.getDurabilidad();
    }

    public boolean isApilable() {
        return apilable;
    }

    public int getDurabilidad() {
        return durabilidad;
    }

    public String getMaterial() {
        return material;
    }

}

