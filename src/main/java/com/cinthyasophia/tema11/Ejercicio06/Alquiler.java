package com.cinthyasophia.tema11.Ejercicio06;

import java.util.Comparator;


public class Alquiler {
    private Multimedia mutimedia;
    private Socio socio;

    public Alquiler(Multimedia mutimedia, Socio socio) {
        this.mutimedia = mutimedia;
        this.socio = socio;
    }

    public Multimedia getMutimedia() {
        return mutimedia;
    }

    public Socio getSocio() {
        return socio;
    }

    @Override
    public String toString() {
        return mutimedia.toString() +
               socio.toString();
    }

    public static class ComparatorYear implements Comparator<Alquiler> {
        @Override
        public int compare(Alquiler alquiler, Alquiler t1) {
            return alquiler.getMutimedia().getFechaAlquiler().compareTo(t1.getMutimedia().getFechaAlquiler());
        }
    }
}
