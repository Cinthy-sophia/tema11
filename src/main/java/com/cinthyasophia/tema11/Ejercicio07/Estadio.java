package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class Estadio {
    private Lib lib = new Lib();
    private ArrayList<Zona> zonas;
    private HashMap<Partido,Integer> partidos;//Muestra todos los partidos que se han jugado y las entradas que se deben vender para cada uno.
    private final int CANTIDAD_TOTAL_ASIENTOS;

    public Estadio(){
        zonas= new ArrayList<>();

        for (Zona.TipoZona z: Zona.TipoZona.values()) {
            zonas.add(new Zona(z.toString()));
        }
        CANTIDAD_TOTAL_ASIENTOS= zonas.get(0).CANTIDAD_ASIENTOS*zonas.size();
        partidos = datosAleatoriosPartidos(10);

    }


    public String nuevoPartido(Partido p, int cantidadEntradas){

        partidos.put(p,cantidadEntradas);
        return "Añadido correctamente.";

    }

    public int getCANTIDAD_TOTAL_ASIENTOS() {
        return CANTIDAD_TOTAL_ASIENTOS;
    }

    public ArrayList<Zona> getZonas() {
        return zonas;
    }

    public HashMap<Partido,Integer> getPartidosYEntradas() {
        return partidos;
    }

    public Set<Partido> getPartidos(){
        return partidos.keySet();
    }


    @Override
    public String toString() {
        return  "Zonas: "+zonas +
                "\nPartidos:" + partidos.toString();
    }

    public HashMap<Partido,Integer> datosAleatoriosPartidos(int cant){
        HashMap<Partido,Integer> p= new HashMap<>();

        Faker faker = new Faker(new Locale("es"));
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        String tipo;
        GregorianCalendar fechaP;
        String fechaPartido;
        String equipoLocal;
        String equipoVisitante;

        for (int i = 0; i < cant; i++) {
            tipo= Partido.TipoPartido.values()[lib.aleatorio(0, Partido.TipoPartido.values().length-1)].name();
            fechaP= new GregorianCalendar(lib.aleatorio(2010,2025),lib.aleatorio(1,11),lib.aleatorio(1,28));
            fechaPartido=format.format(fechaP.getTime());
            equipoLocal= faker.team().sport();
            equipoVisitante= faker.team().sport();
            p.put(new Partido(tipo,fechaPartido,equipoLocal,equipoVisitante),lib.aleatorio(150,CANTIDAD_TOTAL_ASIENTOS));
        }
        return p;
    }
}

