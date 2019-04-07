package com.cinthyasophia.tema11.Ejercicio06;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Videoclub {
    private final int PERIODO_MAX_DIAS=3;
    private final int PRECIO_BASE=4;
    private final String REBAJA_PELICULA="2012";
    private final String REBAJA_VIDEOJUEGO="2010";

    private ArrayList<Pelicula> peliculasDisponibles;
    private ArrayList<Videojuego> videojuegosDisponibles;
    private ArrayList<Socio> socios;

    private HashMap<Integer,Multimedia> peliculasRentadas;
    private HashMap<Integer,Multimedia> videojuegosRentados;

    public Videoclub() {
        peliculas = new ArrayList<>();
        videojuegos = new ArrayList<>();
    }

    public void nuevaPelicula(Pelicula p){
        peliculas.add(p);
    }
    public void nuevoVideojuego(Videojuego v){
        videojuegos.add(v);
    }

    public int alquilar(Socio s, Multimedia m ){

        peliculasRentadas.put(s.getNif(),m);




    }
}
