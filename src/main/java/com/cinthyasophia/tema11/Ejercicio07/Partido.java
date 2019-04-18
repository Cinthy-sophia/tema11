package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.util.GregorianCalendar;

public class Partido {
    public enum Tipo {BAJA_AFLUENCIA, ALTA_AFLUENCIA, MEDIA_AFLUENCIA}

    private Lib lib= new Lib();
    private static int id;
    private int codPartido;
    private String tipo;
    private GregorianCalendar fechaPartido;
    private String equipoLocal;
    private String equipoVisitante;

    public Partido(String tipo, String fechaPartido, String equipoLocal, String equipoVisitante) {
        this.tipo = tipo;
        this.fechaPartido = lib.getFecha(fechaPartido);
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public static int getId() {
        return id;
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
}
