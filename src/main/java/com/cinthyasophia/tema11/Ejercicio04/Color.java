package com.cinthyasophia.tema11.Ejercicio04;

public enum Color {
    BLANCO("Blanco"),ROJO("Rojo"),NEGRO("Negro"),AZUL("Azul"),GRIS("Gris");
    private String color;

    Color(String color){
        this.color= color;
    }

    public String getColor() {
        return color;
    }
}
