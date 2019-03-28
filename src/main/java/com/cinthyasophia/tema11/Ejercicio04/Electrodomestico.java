package com.cinthyasophia.tema11.Ejercicio04;


import java.util.HashMap;

public class Electrodomestico {
    public enum Consumo {A,B,C,D,E,F}
    public enum Color {BLANCO,ROJO,NEGRO,AZUL,GRIS}

    private static final double PRECIO_BASE=100;
    private static final String COLOR_DEFAULT= Color.BLANCO.toString();
    private static final char CONSUMO_DEFAULT= Consumo.F.toString().charAt(0);
    private static final double PESO_DEFAULT= 5;



    protected String color;
    protected char consumoEnergetico;
    protected double peso;
    protected double precio;

    public Electrodomestico(String color, char consumoEnergetico, double peso, double precio) {
        this.color = comprobarColor(color);
        this.consumoEnergetico = compobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
        this.precio = precio;
    }

    public Electrodomestico() {
        this(COLOR_DEFAULT,CONSUMO_DEFAULT,PESO_DEFAULT,PRECIO_BASE);
    }

    public Electrodomestico(double peso, double precio) {
        this(COLOR_DEFAULT,CONSUMO_DEFAULT,peso,precio);
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    public double getPrecio() {
        return precio;
    }

    private char compobarConsumoEnergetico(char letra){
        char consum= ' ';
        for (Consumo consumo: Consumo.values()) {
           if (consumo.toString().charAt(0)==letra){
               consum=consumo.toString().charAt(0);
           }

        }
        if (Character.isWhitespace(consum)){
            consum= CONSUMO_DEFAULT;
        }
        return consum;
    }
    private String comprobarColor(String color){
        String colorEl= null;
        for (Color c: Color.values()) {
           if (c.toString().equalsIgnoreCase(color)){
               colorEl=c.toString();
           }

        }
        if (colorEl==null){
            colorEl= COLOR_DEFAULT;
        }
        return colorEl;
    }
    public double precioFinal(){

        switch (consumoEnergetico){
            case 'A':
                precio+=100;
            break;

            case 'B':

        }

        return precio;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "color='" + color + '\'' +
                ", consumoEnergetico=" + consumoEnergetico +
                ", peso=" + peso +
                ", precio=" + precio +
                '}';
    }
}
