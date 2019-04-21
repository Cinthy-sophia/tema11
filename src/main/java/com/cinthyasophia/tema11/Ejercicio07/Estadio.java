package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;


public class Estadio {
    private Lib lib = new Lib();
    private ArrayList<Zona> zonas;
    private ArrayList<Partido> partidos;
    private Boleteria boleteria;

    public Estadio(){
        partidos= new ArrayList<>();
        zonas= new ArrayList<>();

        for (Zona.TipoZona z: Zona.TipoZona.values()) {
            zonas.add(new Zona(z.toString()));
        }

    }
    public String nuevoPartido(Partido p){
        int year= p.getFechaPartido().get(Calendar.YEAR);
        int month= p.getFechaPartido().get(Calendar.MONTH);
        int day= p.getFechaPartido().get(Calendar.DAY_OF_MONTH);

        LocalDate fechaPar= LocalDate.of(year,month,day);
        LocalDate now = LocalDate.now();

        if (fechaPar.isBefore(now)){
            return "La fecha del partido no es valida porque ya ha pasado.";
        }else{

            if (partidos.add(p)){
                return "Añadido correctamente.";

            }else{
                return "Ha ocurrido un error, vuelva a intentarlo.";

            }
        }
    }
    public ArrayList<Zona> getZonas() {
        return zonas;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    @Override
    public String toString() {
        return zonas +
                "\nPartidos:" + partidos.toString();
    }
}
