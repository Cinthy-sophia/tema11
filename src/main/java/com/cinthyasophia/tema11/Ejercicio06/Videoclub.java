package com.cinthyasophia.tema11.Ejercicio06;

import java.util.ArrayList;
import java.util.HashMap;

public class Videoclub {
    private final int PERIODO_MAX_DIAS=3;
    private final int PRECIO_BASE=4;
    private final int MAYOR_EDAD=18;
    private final int REBAJA_PELICULA= 2012;
    private final int REBAJA_VIDEOJUEGO= 2010;

    private ArrayList<Multimedia> multimedia;
    private ArrayList<Socio> socios;
    private HashMap<Integer,Integer> multimediaRentado;

    public Videoclub() {
        multimedia = new ArrayList<>();
        socios = new ArrayList<>();
        multimediaRentado= new HashMap<>();
    }

    public ArrayList<Multimedia> getMultimedia() {
        return multimedia;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public boolean nuevoMultimedia(Multimedia m){
        int precioTotal= PRECIO_BASE;

        if (m instanceof Pelicula){
            if (m.year<REBAJA_PELICULA){
                precioTotal-=1;
            }

        } else if(m instanceof Videojuego){
            if (m.year<REBAJA_VIDEOJUEGO){
                precioTotal-=1;
            }
        }

        m.setPrecio(precioTotal);

        return multimedia.add(m);

    }
    public boolean nuevoSocio(Socio s){
        if (s.getEdad()<MAYOR_EDAD){
            return false;
        } else{
            return socios.add(s);
        }
    }
    public void listadoSocios(){

    }

    public boolean alquilar(int nif, int cod){

        return true;
    }
}
