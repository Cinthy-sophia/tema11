package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Estadio {
    private Lib lib = new Lib();
    private ArrayList<Zona> zonas;
    private HashMap<Partido,Integer> partidos;//Muestra todos los partidos que se han jugado y las entradas que se deben vender para cada uno.
    private Boleteria boleteria;
    private final int CANTIDAD_TOTAL_ASIENTOS;

    public Estadio(){
        partidos = new HashMap<>();
        zonas= new ArrayList<>();

        for (Zona.TipoZona z: Zona.TipoZona.values()) {
            zonas.add(new Zona(z.toString()));
        }
        CANTIDAD_TOTAL_ASIENTOS= zonas.get(0).CANTIDAD_ASIENTOS*zonas.size();

    }


    public String nuevoPartido(Partido p, int cantidadEntradas){

        if (cantidadEntradas>CANTIDAD_TOTAL_ASIENTOS) {
            return "La cantidad de entradas a vender es mayor que la cantidad de asientos disponibles, intente de nuevo.";
        } else{
            partidos.put(p,cantidadEntradas);
            return "Añadido correctamente.";
        }

    }

    public String regresarEntrada(int numeroEntrada){
        Entrada entrada=boleteria.devolverEntrada(numeroEntrada);
        if (entrada!= null){
            return entrada.toString()+"\nDevuelta con éxito";
        }
        return "No ha podido ser devuelta";
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
        return  zonas +
                "\nPartidos:" + partidos.toString();
    }
}

