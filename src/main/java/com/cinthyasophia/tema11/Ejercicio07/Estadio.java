package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class Estadio {
    private Lib lib = new Lib();
    private Boleteria boleteria;
    private ArrayList<Zona> zonas;
    private GeneradorVIP generadorCodigo;
    private ArrayList<GeneradorSorteo> sorteosDePartidos;
    private ArrayList<Partido> partidos;//Muestra todos los partidos que se han jugado y las entradas que se deben vender para cada uno.

    public Estadio(){
        zonas= new ArrayList<>();

        for (Zona.TipoZona z: Zona.TipoZona.values()) {
            zonas.add(new Zona(z.toString()));
        }
        partidos = datosAleatoriosPartidos(10);
        boleteria= new Boleteria();
        sorteosDePartidos= new ArrayList<>();

        for (Partido p: partidos) {
            sorteosDePartidos.add(new GeneradorSorteo(p));
        }
        generadorCodigo= new GeneradorVIP();
    }


    public String nuevoPartido(Partido p){
        partidos.add(p);
        sorteosDePartidos.add(new GeneradorSorteo(p));
        return "Añadido correctamente.";

    }
    public String venderEntrada(Partido p, Asiento a){
        Entrada e;
        int numSorteo=0;
        e= boleteria.venderEntrada(p,a);

        for (GeneradorSorteo g : sorteosDePartidos) {
            if (g.getPartido().getCodPartido()== p.getCodPartido()){
                numSorteo= g.getNumSorteo(e.codEntrada);
            }
        }

        if (e!=null){
            if (e instanceof EntradaNormal){
                ((EntradaNormal) e).setCodPremio(numSorteo);
            }else if (e instanceof EntradaVIP){
                ((EntradaVIP) e).setPasswordVIP(generadorCodigo.generarCodigoVIP());
            }
            return e.toString();
        }else{
            return "La entrada no ha podido ser creada. Vuelve a intentarlo.";
        }
    }
    public String regresarEntrada(int codEntrada){
        int codSorteo=0;
        Entrada entrada= null;
        for (Entrada e: boleteria.getEntradasVendidas()) {
            if(e.getCodEntrada()== codEntrada){
                if (e instanceof EntradaNormal){
                    entrada= e;
                    codSorteo= ((EntradaNormal) e).getCodPremio();
                }
            }
        }
        if (boleteria.devolverEntrada(codEntrada)){
            for (GeneradorSorteo g: sorteosDePartidos) {
                if (entrada!=null && entrada.getPartido().getCodPartido()== g.getPartido().getCodPartido()){
                    if(g.returnNumSorteo(codSorteo)){
                        return "La entrada con el codigo: "+codEntrada +" devuelta con éxito.";

                    }

                }

            }
        }
        return "No ha podido ser devuelta, intente de nuevo.";
    }
    public ArrayList<Entrada> getEntradasVendidas() {
        return boleteria.getEntradasVendidas();

    }

    public int getCantidadTotalDeAsientosPorZona() {
        return zonas.get(0).CANTIDAD_ASIENTOS*zonas.size();
    }

    public ArrayList<Zona> getZonas() {
        return zonas;
    }

    public ArrayList<Partido> getPartidos(){
        return partidos;
    }


    @Override
    public String toString() {
        return  "Zonas: "+zonas +
                "\nPartidos:" + partidos.toString();
    }

    public ArrayList<Partido> datosAleatoriosPartidos(int cant){
        ArrayList<Partido> p= new ArrayList<>();

        Faker faker = new Faker(new Locale("es"));
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        String tipo;
        GregorianCalendar fechaP;
        String fechaPartido;
        String equipoLocal;
        String equipoVisitante;
        int cantidadEntradas;
        Partido part;

        for (int i = 0; i < cant; i++) {
            tipo= Partido.TipoPartido.values()[lib.aleatorio(0, Partido.TipoPartido.values().length-1)].name();
            fechaP= new GregorianCalendar(lib.aleatorio(2010,2025),lib.aleatorio(1,11),lib.aleatorio(1,28));
            fechaPartido=format.format(fechaP.getTime());
            equipoLocal= faker.team().sport();
            equipoVisitante= faker.team().sport();
            cantidadEntradas=lib.aleatorio(150,getCantidadTotalDeAsientosPorZona());
            part=new Partido(tipo,fechaPartido,equipoLocal,equipoVisitante,lib.aleatorio(150,getCantidadTotalDeAsientosPorZona()));
            if (lib.fechaIsBeforeNow(fechaP)){
                part.setRecaudacion('+',lib.aleatorio(50.0, (double) cantidadEntradas));
            }
            p.add(part);
        }
        return p;
    }
}

