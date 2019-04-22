package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.util.HashMap;

public class Boleteria {
    private Lib lib = new Lib();
    private HashMap<Partido,Integer> recaudacion;
    private int cantidadEntradasVendidas;
    //todo Boleteria recibe la cantidad de entradas a vender por cada partido, y las genera antes de venderlas. Ademas de generar los codigos aleatorios para ambos tipos de entradas
    //

    public Boleteria(){
        recaudacion= new HashMap<>();
        cantidadEntradasVendidas= 0;
    }

    public Entrada agregarPrecioFinal(Entrada entrada){

        if (entrada.getPartido().getTipo().equals(Partido.TipoPartido.ALTA_AFLUENCIA.name())){
            entrada.setPrecio(entrada.getPrecio()*130/100);
        }else if(entrada.getPartido().getTipo().equals(Partido.TipoPartido.BAJA_AFLUENCIA.name())){
            entrada.setPrecio(entrada.getPrecio()*75/100);
        }

        return entrada;
    }

    public Entrada venderEntrada(int cantidadEntradas, Partido p, Asiento a){

        new Entrada(p,a);

    }
}
