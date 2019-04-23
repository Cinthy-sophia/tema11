package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.util.Arrays;
import java.util.HashMap;

public class Boleteria {
    private final int COMBINACION_VIP_SIZE=5;
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

    public Entrada venderEntrada(Partido p, Asiento a){
        if (a.getZona().getTipo().equals("VIP")){
            EntradaVIP entrada=(EntradaVIP) agregarPrecioFinal(new EntradaVIP(p,a));
            entrada.setPasswordVIP(generarCodigoVIP());
        }else{
            EntradaNormal entrada;
        }

        return null;

    }

    public String generarCodigoVIP(){
        String letras= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder s;
        String combinacion = "";
        String combinacionFinal = "";
        int[] combinacionNum= lib.getCombinacion(9,COMBINACION_VIP_SIZE);
        int aleatorio;

        for (int i = 0; i < COMBINACION_VIP_SIZE; i++) {
            aleatorio= lib.aleatorio(0,9);
            s.append(lib.getCombinacion(9,1)).append(letras.charAt(aleatorio));
            combinacion=
        }
        combinacionFinal.concat(Arrays.toString(combinacionNum)).concat(combinacion);

        return combinacionFinal;
    }

    public int generarNumeroSorteo(int cantidadAsientos){
        return Integer.valueOf(Arrays.toString(lib.getCombinacion(cantidadAsientos,1)));

    }
}