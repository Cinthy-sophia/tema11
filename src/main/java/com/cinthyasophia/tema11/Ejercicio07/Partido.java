package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Partido {
    public enum TipoPartido {BAJA_AFLUENCIA, ALTA_AFLUENCIA, MEDIA_AFLUENCIA}

    private Lib lib= new Lib();
    private static int id;
    private int codPartido;
    private String tipo;
    private GregorianCalendar fechaPartido;
    private String equipoLocal;
    private String equipoVisitante;

    public Partido(String tipo, String fechaPartido, String equipoLocal, String equipoVisitante) {
        ++id;
        codPartido= id;
        this.tipo = tipo;
        this.fechaPartido = lib.getFecha(fechaPartido);
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }


    public int getCodPartido() {
        return codPartido;
    }

    public String getTipo() {
        return tipo;
    }

    public GregorianCalendar getFechaPartido() {
        return fechaPartido;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    @Override
    public String toString() {
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        return  "Numero de partido: " + codPartido +
                "\nTipo:" + tipo +
                "\tFecha:" + format.format(fechaPartido.getTime()) +
                "\nEquipo Local: " + equipoLocal+
                "\nEquipo Visitante:" + equipoVisitante;
    }
}
