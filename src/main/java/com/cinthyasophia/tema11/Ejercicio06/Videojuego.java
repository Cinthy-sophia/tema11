package com.cinthyasophia.tema11.Ejercicio06;


import java.util.GregorianCalendar;

public class Videojuego extends Alquilable {
    public enum Plataformas{PLAYSTATION_4,X_BOX,NINTENDO_SWITCH}

    private String plataforma;

    public Videojuego(String titulo, String autor, String formato, int year, String plataforma) {
        super(titulo, autor, formato, year);
        this.plataforma= plataforma;

    }

    public String getPlataforma() {
        return plataforma;
    }


    @Override
    public String toString() {
        return  super.toString()+
                "Plataforma:" + plataforma;
    }
}
