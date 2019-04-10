package com.cinthyasophia.tema11.Ejercicio06;


import com.cinthyasophia.tema11.Util.Lib;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class Videoclub {
    private final int PERIODO_MAX_DIAS=3;
    private final int PRECIO_BASE=4;
    private final int PRECIO_RECARGO=2;
    private final int MAYOR_EDAD=18;
    private final int REBAJA_PELICULA= 2012;
    private final int REBAJA_VIDEOJUEGO= 2010;
    private Lib lib;
    private ArrayList<Multimedia> multimedia;
    private ArrayList<Socio> socios;
    private HashMap<Multimedia,Socio> multimediaRentado;

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

    public HashMap<Multimedia, Socio> getMultimediaRentado() {
        return multimediaRentado;
    }

    public String nuevoMultimedia(Multimedia m){
        int precioTotal= PRECIO_BASE;
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

        if (multimedia.add(m)){
            return "Añadido correctamente.";

        }else{

            return "No ha podido ser añadido.";
        }

    }
    public boolean nuevoSocio(Socio s){
        if (s.getEdad()<MAYOR_EDAD){
            return false;
        } else {
            return socios.add(s);
        }
    }
    public boolean comprobarSocio(int nif){
        Set<Multimedia> multimedia= multimediaRentado.keySet();
        for (Multimedia m : multimedia) {
            if (multimediaRentado.get(m).getNif()==nif){
                if (lib.getDias(m.getFechaAlquiler())>PERIODO_MAX_DIAS){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean comprobarMultimedia(Multimedia m){
        for (Multimedia mul: multimedia) {
            if (mul.equals(m)){
                if (m.isAlquilado()){
                    return true;
                }
            }
        }
        return false;
    }
    public int calcularRecargo(Multimedia m){
        int cantidadRecargo=0;
        if (lib.getDias(m.getFechaAlquiler())>PERIODO_MAX_DIAS){
            cantidadRecargo = (lib.getDias(m.getFechaAlquiler()) - PERIODO_MAX_DIAS) * PRECIO_RECARGO;
        }

        return cantidadRecargo;
    }

    public String alquilar(Socio socio, Multimedia m, String fechaAl){
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar fechaDevolucion = new GregorianCalendar();

        for (Multimedia mul: multimedia) {
            if (mul.equals(m)){
                mul.setFechaAlquiler(fechaAl);
                fechaDevolucion= mul.getFechaAlquiler();
                fechaDevolucion.add(GregorianCalendar.DAY_OF_MONTH,PERIODO_MAX_DIAS);
                m.setFechaDevolucion(format.format(fechaDevolucion.getTime()));
                //todo verificar lo de los dias
                multimediaRentado.put(mul,socio);
            }
        }
        return "Multimedia rentado, fecha de devolucion:"+format.format(fechaDevolucion.getTime());
    }
    public void devolver(){

    }

    public void datosAleatorio(){
        Faker faker = new Faker(new Locale("es"));
        faker.book().title();
        faker.book().author();
    }
}
