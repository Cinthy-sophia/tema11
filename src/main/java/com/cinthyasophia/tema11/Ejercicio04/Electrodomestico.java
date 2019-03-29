package com.cinthyasophia.tema11.Ejercicio04;


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
                precio= precioPeso(precio);
            break;

            case 'B':
                precio+=80;
                precio= precioPeso(precio);
            break;

            case 'C':
                precio+=60;
                precio= precioPeso(precio);
            break;

            case 'D':
                precio+=50;
                precio= precioPeso(precio);
            break;

            case 'E':
                precio+=30;
                precio= precioPeso(precio);
            break;

            case 'F':
                precio+=10;
                precio= precioPeso(precio);
            break;

            default:
                System.out.println("Error");
            break;

        }

        return precio;
    }
    private double precioPeso(double p){
        double precio=0;

        if (getPeso()>=0&& getPeso()<=19){
            precio= p+10;

        }else if(getPeso()<=49){
            precio= p+50;

        }else if (getPeso()<=79){
            precio = p+80;
        }else if (getPeso()>=80){
            precio = p+100;
        }

        return precio;

    }

    @Override
    public String toString() {
        return "\nElectrodomestico:" +
                "\nColor: " + color +
                ".\nConsumo energetico: " + consumoEnergetico +
                ".\nPeso: " + peso +
                "kg.\nPrecio: " + precio +
                "€.";
    }
}
