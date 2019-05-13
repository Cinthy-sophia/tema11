package com.cinthyasophia.tema11.Ejercicio07;

import java.util.ArrayList;

public class Boleteria {
    private ArrayList<Entrada> entradasVendidas;

    public Boleteria() {
        entradasVendidas = new ArrayList<>();
    }

    /**
     * Se encarga de agregarle el precio final a las entradas segun el tipo de partido que se juega.
     * Recibe una entrada y regresa la misma con el precio anadido.
     * @param entrada
     * @return entrada
     */
    public Entrada agregarPrecioFinal(Entrada entrada) {

        if (entrada.getPartido().getTipo().equals(Partido.TipoPartido.ALTA_AFLUENCIA.name())) {
            entrada.setPrecio(entrada.getPrecio() * 130 / 100);
        } else if (entrada.getPartido().getTipo().equals(Partido.TipoPartido.BAJA_AFLUENCIA.name())) {
            entrada.setPrecio(entrada.getPrecio() * 75 / 100);
        }

        return entrada;
    }

    /**
     * Recibe el partido y el asiento y regresa la entrada segun la zona del asiento.
     * Tambien la guarda como entrada vendida.
     * @param p
     * @param a
     * @return Entrada
     */
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

    /**
     * Recibe el codigo de la entrada y si se encuentra entre las entradas vendidas, le resta a la recaudacion del partido y la retira de las entradas vendidas.
     * @param codEntrada
     * @return boolean
     */
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