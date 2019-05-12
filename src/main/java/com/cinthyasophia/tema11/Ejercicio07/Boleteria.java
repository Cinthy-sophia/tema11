package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.util.ArrayList;
import java.util.HashMap;

public class Boleteria {
    private Lib lib = new Lib();
    private ArrayList<Entrada> entradasVendidas;
    private ArrayList<GeneradorSorteo> generadorSorteo;

    public Boleteria() {
        entradasVendidas = new ArrayList<>();
        generadorSorteo = new ArrayList<>();

    }

    public Entrada agregarPrecioFinal(Entrada entrada) {

        if (entrada.getPartido().getTipo().equals(Partido.TipoPartido.ALTA_AFLUENCIA.name())) {
            entrada.setPrecio(entrada.getPrecio() * 130 / 100);
        } else if (entrada.getPartido().getTipo().equals(Partido.TipoPartido.BAJA_AFLUENCIA.name())) {
            entrada.setPrecio(entrada.getPrecio() * 75 / 100);
        }

        return entrada;
    }

    public Entrada venderEntrada(Partido p, Asiento a) {
        Entrada e;

        if (a.getZona().getTipo().toString().equalsIgnoreCase("vip")) {
            e = new EntradaVIP(p, a);
        } else {
            e = new EntradaNormal(p, a);
        }
        e = agregarPrecioFinal(e);
        e.getAsiento().setOcupado(true);
        entradasVendidas.add(e);
        e.getPartido().setRecaudacion('+', e.getPrecio());
        return e;
    }

    public boolean devolverEntrada(int codEntrada) {
        Partido p;
        for (Entrada e : entradasVendidas) {
            if (e.getCodEntrada() == codEntrada) {
                e.getAsiento().setOcupado(false);
                p = e.getPartido();
                p.setRecaudacion('-', e.getPrecio());
                return entradasVendidas.remove(e);
            }

        }
        return false;
    }

    public ArrayList<Entrada> getEntradasVendidas() {
        return entradasVendidas;
    }

}