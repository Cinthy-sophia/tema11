package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Boleteria {
    private final int COMBINACION_VIP_SIZE=5;
    private Lib lib = new Lib();
    private Estadio estadio;
    private HashMap<Partido,Double> recaudacion;
    private ArrayList<Entrada> entradasVendidas;
    //todo Boleteria recibe la cantidad de entradas a vender por cada partido, y las genera antes de venderlas. Ademas de generar los codigos aleatorios para ambos tipos de entradas
    //

    public Boleteria(){
        recaudacion= new HashMap<>();
        entradasVendidas= new ArrayList<>();
    }

    public Entrada agregarPrecioFinal(Entrada entrada){

        if (entrada.getPartido().getTipo().equals(Partido.TipoPartido.ALTA_AFLUENCIA.name())){
            entrada.setPrecio(entrada.getPrecio()*130/100);
        }else if(entrada.getPartido().getTipo().equals(Partido.TipoPartido.BAJA_AFLUENCIA.name())){
            entrada.setPrecio(entrada.getPrecio()*75/100);
        }

        return entrada;
    }

    public Entrada venderEntrada(int idPartido, Asiento a){
        Zona zona= estadio.getZonas().get(a.getNumero());

        for (Partido partido: estadio.getPartidos()) {
            if (partido.getCodPartido()==idPartido){
                zona.setCantidadAsientosD(zona.getCantidadAsientosD()-1);
                a.getZona().getAsiento(a.getNumero()).setOcupado(true);

                if (a.getZona().getTipo().equals("VIP")){
                    EntradaVIP entradaV= (EntradaVIP) agregarPrecioFinal(new EntradaVIP(partido,a));
                    entradaV.setPasswordVIP(generarCodigoVIP());
                    entradasVendidas.add(entradaV);
                    recaudacion.put(partido, entradaV.getPrecio());
                    return entradaV;
                }else{
                    EntradaNormal entradaN = (EntradaNormal) agregarPrecioFinal(new EntradaNormal(partido,a));
                    entradaN.setCodPremio(generarNumeroSorteo(estadio.getCANTIDAD_TOTAL_ASIENTOS()));
                    entradasVendidas.add(entradaN);
                    recaudacion.put(partido,entradaN.getPrecio());
                    return agregarPrecioFinal(new EntradaNormal(partido,a));
                }
            }
        }
        return null;
    }

    public HashMap<Partido, Double> getRecaudacion() {
        return recaudacion;
    }

    public Entrada devolverEntrada(int codEntrada){
        for (Entrada e:entradasVendidas) {
            if (e.getCodEntrada()== codEntrada){
                e.getAsiento().setOcupado(false);
                recaudacion.replace(e.getPartido(),recaudacion.get(e.getPartido()),(recaudacion.get(e.getPartido())-e.getPrecio()));
                return entradasVendidas.remove(codEntrada);
            }

        }
        return null;
    }

    private String generarCodigoVIP(){//todo con el codigo ascii
        String letras= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder s = null;
        String combinacion = "";
        String combinacionFinal = "";
        int[] combinacionNum= lib.getCombinacion(9,COMBINACION_VIP_SIZE);
        int aleatorio;

        for (int i = 0; i < COMBINACION_VIP_SIZE; i++) {
            aleatorio= lib.aleatorio(0,9);
            s.append(lib.getCombinacion(9,1)).append(letras.charAt(aleatorio));

        }
        combinacionFinal.concat(Arrays.toString(combinacionNum)).concat(combinacion);

        return combinacionFinal;
    }

    public ArrayList<Entrada> getEntradasVendidas() {
        return entradasVendidas;
    }

    private int generarNumeroSorteo(int cantidadAsientos){
        return Integer.valueOf(Arrays.toString(lib.getCombinacion(cantidadAsientos,1)));

    }
}
