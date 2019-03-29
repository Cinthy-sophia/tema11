package com.cinthyasophia.tema11.Ejercicio04;

public class Lavadora extends Electrodomestico {

    private static final double CARGA_DEFAULT=5;
    protected double carga;

    public Lavadora(){
        super();
        this.carga = CARGA_DEFAULT;
    }

    public Lavadora(double precio, double peso){
        super(peso,precio);
        this.carga= CARGA_DEFAULT;

    }

    public Lavadora(String color, char consumoEnergetico, double peso, double precio, double carga){
        super(color,consumoEnergetico,peso,precio);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }


    @Override
    public double precioFinal() {
        this.precio=super.precioFinal();

        if (getCarga()>30){
            this.precio+=50;
        }

        return this.precio ;
    }

    @Override
    public String toString() {
        return "\nLavadora:" +
                "\nCarga: " + carga +
                " kg.\nColor: " + color +
                ".\nConsumo energetico: " + consumoEnergetico +
                ".\nPeso: " + peso +
                " kg.\nPrecio: " + precio +
                " €.";
    }
}
