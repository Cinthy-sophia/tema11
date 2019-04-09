package com.cinthyasophia.tema11.Ejercicio06;


import com.cinthyasophia.tema11.Util.Lib;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.text.SimpleDateFormat;
import java.util.*;

public class Videoclub {
    private final int PERIODO_MAX_DIAS=3;
    private final int PRECIO_BASE=4;
    private final int MAYOR_EDAD=18;
    private final int REBAJA_PELICULA= 2012;
    private final int REBAJA_VIDEOJUEGO= 2010;
    private Lib lib;
    private ArrayList<Multimedia> multimedia;
    private ArrayList<Socio> socios;
    private HashMap<Multimedia,Integer> multimediaRentado;

    public Videoclub() {
        multimedia = new ArrayList<>();
        socios = new ArrayList<>();
        multimediaRentado= new HashMap<>();
    }

    public ArrayList<Multimedia> getMultimedia() {
        return multimedia;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public String nuevoMultimedia(Multimedia m){
        int precioTotal= PRECIO_BASE;

        for (Multimedia multimedia: multimedia) {
            if (m.equals(multimedia)){
                return "Ya se encuentra en el inventario.";
            }
        }

        if (m instanceof Pelicula){
            if (m.year<REBAJA_PELICULA){
                precioTotal-=1;
            }

        } else if(m instanceof Videojuego){
            if (m.year<REBAJA_VIDEOJUEGO){
                precioTotal-=1;
            }
        }
        m.setPrecio(precioTotal);
        multimedia.add(m);
        return "Añadido correctamente";

    }
    public boolean nuevoSocio(Socio s){
        if (s.getEdad()<MAYOR_EDAD){
            return false;
        } else {
            return socios.add(s);
        }
    }
    public boolean comprobarSocio(int nif){
        Collection<Integer> socios= multimediaRentado.values();
        Set<Multimedia> multimedia= multimediaRentado.keySet();

        for (int i : socios){
            if (nif== i){
                for (Multimedia m : multimedia) {
                    if (lib.getDias(m.getFechaAlquiler())>3){
                        return false;

                    }

                }
            }

        }
        return true;
    }

    public String alquilar(int nif, Multimedia m, String fechaAl){
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar fechaDevolucion;

        if (m.isAlquilado()){
            return "El multimedia ya se encuentra alquilado, no esta disponible.";
        }else{
            m.setFechaAlquiler(fechaAl);
            fechaDevolucion= m.getFechaAlquiler();
            fechaDevolucion.add(GregorianCalendar.DAY_OF_MONTH,3);
            multimediaRentado.put(m,nif);
            return "Multimedia rentado, fecha de devolucion:"+format.format(fechaDevolucion.getTime());
        }
    }

    public void devolver(){

    }
}
