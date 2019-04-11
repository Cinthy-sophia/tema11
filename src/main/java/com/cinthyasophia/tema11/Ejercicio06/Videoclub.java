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
    private ArrayList<Alquiler> multimediaRentado;
    private ArrayList<Alquiler> historialMultimediaRentado;

    public Videoclub() {
        multimedia = new ArrayList<>();
        socios = datosAleatoriosSocio(20);
        multimediaRentado= new ArrayList<>();
        historialMultimediaRentado= new ArrayList<>();
    }

    public ArrayList<Multimedia> getMultimedia() {
        return multimedia;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public ArrayList<Alquiler> getMultimediaRentado() {
        return multimediaRentado;
    }

    public ArrayList<Alquiler> getHistorialMultimediaRentado() {
        return historialMultimediaRentado;
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
        for (Alquiler a: multimediaRentado) {
            if (a.getSocio().getNif()==nif){
                if (lib.getDias(a.getMutimedia().getFechaAlquiler())>PERIODO_MAX_DIAS){
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
        if (m.getFechaAlquiler()!=null && lib.getDias(m.getFechaAlquiler())>PERIODO_MAX_DIAS){
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
                multimediaRentado.add(new Alquiler(mul,socio));
            }
        }
        return "Multimedia rentado, fecha de devolucion:"+format.format(fechaDevolucion.getTime());
    }
    public String devolver(int nif, Multimedia m){
        Socio socio;
        Multimedia multi;
        Alquiler alquiler = null;
        for (Alquiler a: multimediaRentado) {
            if (a.getMutimedia().getClass().equals(m.getClass())){
                if (a.getMutimedia().equals(m)){
                    multi=a.getMutimedia();
                    if (a.getSocio().getNif()==nif){
                        System.out.println(multi.toString()+"\nAlquilado a:"+a.getSocio().getNombre());
                        multi.setPrecio(calcularRecargo(multi));
                        System.out.println("Recargo:"+multi.getPrecio());
                        System.out.println("Precio final:"+multi.getPrecio());
                        socio= a.getSocio();
                        historialMultimediaRentado.add(new Alquiler(multi,socio));
                        alquiler=a;
                    }
                }
            }

        }

        if(multimediaRentado.remove(alquiler)){
            return "Devuelto con exito. Hasta la proxima!";

        }else{
            return "No ha podido ser retornado.";
        }

    }
    public void datosAleatoriosMultimedia(){
        Faker faker = new Faker(new Locale("es"));
        faker.book().title();
        faker.book().author();
    }
    public ArrayList<Socio> datosAleatoriosSocio(int cantidad){
        Faker faker = new Faker(new Locale("es"));
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Socio> socios= new ArrayList<>();
        String nombre;
        GregorianCalendar fechaNac= new GregorianCalendar();
        String fecha;
        String poblacion;

        for (int i = 0; i <cantidad ; i++) {
            nombre=faker.name().name();
            fechaNac.set(lib.aleatorio(1999,1940),lib.aleatorio(1,11),lib.aleatorio(1,29));
            fecha= format.format(fechaNac.getTime());
            poblacion= faker.pokemon().location();
            socios.add(new Socio(nombre,fecha,poblacion));
        }

        return socios;
    }


}
