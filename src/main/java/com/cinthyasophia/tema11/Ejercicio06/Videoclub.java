package com.cinthyasophia.tema11.Ejercicio06;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Videoclub {
    private final int PERIODO_MAX_DIAS=3;
    private final int PRECIO_BASE=4;
    private final int REBAJA_PELICULA= 2012;
    private final int REBAJA_VIDEOJUEGO= 2010;

    private ArrayList<Multimedia> multimediaDisponible;
    private ArrayList<Socio> socios;
    private HashMap<Integer,Multimedia> multimediaRentado;

    public Videoclub() {
        multimediaDisponible = new ArrayList<>();
        socios = new ArrayList<>();
        multimediaRentado= new HashMap<>();
    }

    public boolean nuevoMultimedia(Multimedia m){

        if (m instanceof Pelicula){
            if (m.year<REBAJA_PELICULA){
                m.setPrecio(PRECIO_BASE-1);
            }

        } else if(m instanceof Videojuego){
            if (m.year<REBAJA_VIDEOJUEGO){
                m.setPrecio(PRECIO_BASE-1);
            }

        } else {
            m.setPrecio(PRECIO_BASE);
        }
        return multimediaDisponible.add(m);

    }
    public boolean nuevoSocio(Socio s){
        if (s.getEdad()<18){
            return false;
        } else{
            return socios.add(s);
        }
    }

    public int alquilar(Socio s, Multimedia m ){

        return 0;
    }
}
