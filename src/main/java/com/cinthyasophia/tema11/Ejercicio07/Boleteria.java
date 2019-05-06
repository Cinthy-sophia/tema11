package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.util.ArrayList;
import java.util.HashMap;

public class Boleteria {
    private final int COMBINACION_VIP_SIZE=5;
    private final int COMBINACION_SORTEO_SIZE=2;
    private Lib lib = new Lib();
    private HashMap<Partido,Double> recaudacion;
    private ArrayList<Entrada> entradasVendidas;

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

    public Entrada venderEntrada(Partido p, Asiento a, int cantidadEntradas){
        Zona zona= a.getZona();
        zona.setCantidadAsientosD(zona.getCantidadAsientosD()-1);
        a.getZona().getAsiento(a.getNumero()).setOcupado(true);

        if (a.getZona().getTipo().toString().equalsIgnoreCase("vip")){
            EntradaVIP entradaV= (EntradaVIP) agregarPrecioFinal(new EntradaVIP(p,a));
            entradaV.setPasswordVIP(generarCodigoVIP());
            entradasVendidas.add(entradaV);
            recaudacion.put(p, entradaV.getPrecio());
            return entradaV;
        }else{
            EntradaNormal entradaN = (EntradaNormal) agregarPrecioFinal(new EntradaNormal(p,a));
            entradaN.setCodPremio(generarNumerosSorteo(cantidadEntradas));
            entradasVendidas.add(entradaN);
            recaudacion.put(p,entradaN.getPrecio());
            return agregarPrecioFinal(new EntradaNormal(p,a));
        }
    }

    public HashMap<Partido, Double> getRecaudacion() {
        return recaudacion;
    }

    public Entrada devolverEntrada(int codEntrada){
        for (Entrada e: entradasVendidas) {
            if (e.getCodEntrada()== codEntrada){
                e.getAsiento().setOcupado(false);
                recaudacion.replace(e.getPartido(),recaudacion.get(e.getPartido()),(recaudacion.get(e.getPartido())-e.getPrecio()));
                return entradasVendidas.remove(codEntrada);
            }

        }
        return null;
    }

    public ArrayList<Entrada> getEntradasVendidas() {
        return entradasVendidas;
    }

    private String generarCodigoVIP(){
       EntradaVIP prueba;
       int aleatorioL;
       String letra;
       int[] numeros= new int[COMBINACION_VIP_SIZE];
       StringBuilder s;
       String cod;
       boolean validado= true;
       do {
           s= new StringBuilder();
           aleatorioL= lib.aleatorio(65,90);
           letra=String.valueOf(Character.toChars(aleatorioL));
           numeros=lib.getCombinacion(100,numeros.length-1);

           for (int numero : numeros) {
               s.append(numero);
           }
           s.append(letra);
           cod= s.toString();

           for (Entrada vip: entradasVendidas) {
               if (vip.isVIP()){
                   prueba= (EntradaVIP) vip;
                   if (prueba.getPasswordVIP().equals(cod)){
                       validado= false;

                   }

               }
           }
       }while(!validado);
       return cod;
    }

    private int generarNumerosSorteo(int cantidadEntradasPorPartido){
        EntradaNormal p;
        boolean validado= true;
        int num;
        do {
            num=lib.getCombinacion(cantidadEntradasPorPartido,COMBINACION_SORTEO_SIZE)[0];
            for (Entrada normal: entradasVendidas) {
                if (!normal.isVIP()){
                    p= (EntradaNormal) normal;
                    if (p.getCodPremio()==num){
                        validado= false;

                    }

                }
            }
        }while(!validado);

        return num;

    }
}
