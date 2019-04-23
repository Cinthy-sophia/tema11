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
    private final int CANTIDAD_TOTAL_ASIENTOS;

    public Estadio(){
        partidos= new HashMap<>();
        zonas= new ArrayList<>();
        CANTIDAD_TOTAL_ASIENTOS= zonas.get(0).CANTIDAD_ASIENTOS*zonas.size();

        for (Zona.TipoZona z: Zona.TipoZona.values()) {
            zonas.add(new Zona(z.toString()));
        }

    }
    public String nuevoPartido(Partido p, int cantidadEntradas){

        if (lib.fechaIsBeforeNow(p.getFechaPartido())){
            return "La fecha del partido no es valida porque ya ha pasado, intente de nuevo.";
        }else {

            if (cantidadEntradas>CANTIDAD_TOTAL_ASIENTOS) {
                return "La cantidad de entradas a vender es mayor que la cantidad de asientos disponibles, intente de nuevo.";
            } else{
                partidos.put(p,cantidadEntradas);
                return "Añadido correctamente.";
            }
        }
    }
    public String nuevaEntrada(Entrada e){


    }

    public ArrayList<Zona> getZonas() {
        return zonas;
    }

    public HashMap<Partido,Integer> getPartidosYEntradasVendidas() {
        return partidos;
    }

    public Set<Partido> getPartidos(){
        return partidos.keySet();
    }

    @Override
    public String toString() {
        return zonas +
                "\nPartidos:" + partidos.toString();
    }
}
