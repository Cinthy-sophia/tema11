package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.util.ArrayList;
import java.util.HashMap;

public class Boleteria {
    private final int COMBINACION_VIP_SIZE=5;
    private final int COMBINACION_SORTEO_SIZE=1;
    private final int CANTIDAD_FICHAS=100;
    private Lib lib = new Lib();
    private ArrayList<Entrada> entradasVendidas;
    private ArrayList<GeneradorSorteo> generadorSorteo;

    public Boleteria(){
        entradasVendidas= new ArrayList<>();
        generadorSorteo= new ArrayList<>();

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
        Zona zona= a.getZona();
        zona.setCantidadAsientosD(p.getCantidadEntradas());
        a.setOcupado(true);
        GeneradorSorteo gS;
        for (GeneradorSorteo g: generadorSorteo) {
            if (g.getPartido().getCodPartido()== p.getCodPartido()){

            }else{
                generadorSorteo=new GeneradorSorteo(p);

            }
        }

        if (zona.getTipo().toString().equalsIgnoreCase("vip")){
            EntradaVIP entradaV= (EntradaVIP) agregarPrecioFinal(new EntradaVIP(p,a));
            entradaV.setPasswordVIP(generarCodigoVIP());
            entradasVendidas.add(entradaV);
            p.setRecaudacion('+',entradaV.getPrecio());
            return entradaV;
        }else{
            EntradaNormal entradaN = (EntradaNormal) agregarPrecioFinal(new EntradaNormal(p,a));
            entradaN.setCodPremio(generadorSorteo.getNumSorteo(entradaN.getCodEntrada()));
            entradasVendidas.add(entradaN);
            p.setRecaudacion('+',entradaN.getPrecio());
            return entradaN;
        }
    }

    public Entrada devolverEntrada(int codEntrada){
        Partido p;
        for (Entrada e: entradasVendidas) {
            if (e.getCodEntrada()== codEntrada){
                e.getAsiento().setOcupado(false);
                p= e.getPartido();
                p.setRecaudacion('-',e.getPrecio());
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
           numeros=lib.getCombinacion(CANTIDAD_FICHAS,numeros.length-1);

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
