package com.cinthyasophia.tema11.Ejercicio04;

public class Electrodomestico {
    private enum Consumo{ A,B,C,D,E,F }
    private enum Color{ BLANCO,ROJO,NEGRO,AZUL,GRIS }

    protected static final double PRECIO_BASE=100;
    protected static final Color COLOR_DEFAULT= Color.BLANCO;
    protected static final Consumo CONSUMO_DEFAULT= Consumo.F;
    protected static final double PESO_DEFAULT= 5;

    protected Color color;
    protected Consumo consumoEnergetico;
    protected double peso;
    protected double precio;



}
