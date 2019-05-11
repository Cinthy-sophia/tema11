package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class Estadio {
    private Lib lib = new Lib();
    private ArrayList<Zona> zonas;
    private ArrayList<Partido> partidos;//Muestra todos los partidos que se han jugado y las entradas que se deben vender para cada uno.
    private final int CANTIDAD_TOTAL_ASIENTOS;

    public Estadio(){
        zonas= new ArrayList<>();

        for (Zona.TipoZona z: Zona.TipoZona.values()) {
            zonas.add(new Zona(z.toString()));
        }
        CANTIDAD_TOTAL_ASIENTOS= zonas.get(0).CANTIDAD_ASIENTOS*zonas.size();
        partidos = datosAleatoriosPartidos(10);

    }


    public String nuevoPartido(Partido p){

        partidos.add(p);
        return "Añadido correctamente.";

    }

    public int getCANTIDAD_TOTAL_ASIENTOS() {
        return CANTIDAD_TOTAL_ASIENTOS;
    }

    public ArrayList<Zona> getZonas() {
        return zonas;
    }

    public ArrayList<Partido> getPartidos(){
        return partidos;
    }


    @Override
    public String toString() {
        return  "Zonas: "+zonas +
                "\nPartidos:" + partidos.toString();
    }

    public ArrayList<Partido> datosAleatoriosPartidos(int cant){
        ArrayList<Partido> p= new ArrayList<>();

        Faker faker = new Faker(new Locale("es"));
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        String tipo;
        GregorianCalendar fechaP;
        String fechaPartido;
        String equipoLocal;
        String equipoVisitante;
        int cantidadEntradas;
        Partido part;

        for (int i = 0; i < cant; i++) {
            tipo= Partido.TipoPartido.values()[lib.aleatorio(0, Partido.TipoPartido.values().length-1)].name();
            fechaP= new GregorianCalendar(lib.aleatorio(2010,2025),lib.aleatorio(1,11),lib.aleatorio(1,28));
            fechaPartido=format.format(fechaP.getTime());
            equipoLocal= faker.team().sport();
            equipoVisitante= faker.team().sport();
            cantidadEntradas=lib.aleatorio(150,CANTIDAD_TOTAL_ASIENTOS);
            part=new Partido(tipo,fechaPartido,equipoLocal,equipoVisitante,lib.aleatorio(150,CANTIDAD_TOTAL_ASIENTOS));
            if (lib.fechaIsBeforeNow(fechaP)){
                part.setRecaudacion('+',lib.aleatorio(50.0, (double) cantidadEntradas));
            }
            p.add(part);
        }
        return p;
    }
}

