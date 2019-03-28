package com.cinthyasophia.tema11.Ejercicio04;

public class Electrodomestico {
    private static final double PRECIO_BASE=100;
    private static final String COLOR_DEFAULT= Color.BLANCO.getColor();
    private static final char CONSUMO_DEFAULT= Consumo.F.getLetra();
    private static final double PESO_DEFAULT= 5;

    protected String color;
    protected char consumoEnergetico;
    protected double peso;
    protected double precio;

    public Electrodomestico(String color, char consumoEnergetico, double peso, double precio) {
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
        this.precio = precio;
    }

    public Electrodomestico() {
        this.color = COLOR_DEFAULT;
        this.consumoEnergetico = CONSUMO_DEFAULT;
        this.peso = PESO_DEFAULT;
        this.precio = PRECIO_BASE;
    }

    public Electrodomestico(double peso, double precio) {
        this.peso = peso;
        this.precio = precio;
    }

}
