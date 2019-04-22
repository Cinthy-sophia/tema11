package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;


public class Estadio {
    private Lib lib = new Lib();
    private ArrayList<Zona> zonas;
    private HashMap<Partido,Integer> partidos;
    private Boleteria boleteria;

    public Estadio(){
        partidos= new HashMap<>();
        zonas= new ArrayList<>();

        for (Zona.TipoZona z: Zona.TipoZona.values()) {
            zonas.add(new Zona(z.toString()));
        }

    }
    public String nuevoPartido(Partido p, int cantidadEntradas){
        int year= p.getFechaPartido().get(Calendar.YEAR);
        int month= p.getFechaPartido().get(Calendar.MONTH);
        int day= p.getFechaPartido().get(Calendar.DAY_OF_MONTH);

        LocalDate fechaPar= LocalDate.of(year,month,day);
        LocalDate now = LocalDate.now();


        if (fechaPar.isBefore(now)){
            return "La fecha del partido no es valida porque ya ha pasado, intente de nuevo.";
        }else {

            if (cantidadEntradas>zonas.get(0).CANTIDAD_ASIENTOS*zonas.size()) {
                return "La cantidad de entradas a vender es mayor que la cantidad de asientos disponibles, intente de nuevo.";
            } else{
                partidos.put(p,cantidadEntradas);
                return "Añadido correctamente.";

            }
        }
    }

    public ArrayList<Zona> getZonas() {
        return zonas;
    }

    public HashMap<Partido,Integer> getPartidosYEntradas() {
        return partidos;
    }

    public Set getPartidos(){
        return partidos.keySet();
    }

    @Override
    public String toString() {
        return zonas +
                "\nPartidos:" + partidos.toString();
    }
}
