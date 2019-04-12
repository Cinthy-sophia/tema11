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
    private Lib lib= new Lib();
    private ArrayList<Multimedia> multimedia;
    private ArrayList<Socio> socios;
    private ArrayList<Alquiler> multimediaRentado;
    private ArrayList<Alquiler> historialMultimediaRentado;

    public Videoclub() {
        multimedia = datosAleatoriosMultimedia(10,15);
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
                if (lib.obtenerDias(a.getMutimedia().getFechaAlquiler())>PERIODO_MAX_DIAS){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean comprobarMultimedia(Multimedia m){
        for (Multimedia mul: multimedia) {
            if (mul.equals(m)&& !m.isAlquilado()){
                return true;

            }
        }
        return false;
    }

    public int calcularRecargo(Multimedia m){
        int cantidadRecargo=0;
        if (lib.obtenerDias(m.getFechaAlquiler())>PERIODO_MAX_DIAS){
            cantidadRecargo = (lib.obtenerDias(m.getFechaAlquiler()) - PERIODO_MAX_DIAS) * PRECIO_RECARGO;
        }
        return cantidadRecargo;
    }

    public String alquilar(int nif, Multimedia m){
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar fechaDevolucion = new GregorianCalendar();
        GregorianCalendar fechaAl = new GregorianCalendar();
        Socio socio= new Socio();

        for (Socio s: socios) {
            if (nif == s.getNif()){
                socio= s;
            }
        }
        for (Multimedia mul: multimedia) {
            if (mul.equals(m)){
                mul.setFechaAlquiler(format.format(fechaAl.getTime()));
                fechaDevolucion= fechaAl;
                fechaDevolucion.add(GregorianCalendar.DAY_OF_MONTH,PERIODO_MAX_DIAS);
                multimediaRentado.add(new Alquiler(mul,socio));
            }
        }
        return "Multimedia rentado por: "+socio.getNombre()+", fecha maxima de devolucion :"+format.format(fechaDevolucion.getTime());
    }
    public String devolver(int nif, Multimedia m){
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        Socio socio;
        Multimedia multi;
        Alquiler alquiler = null;
        GregorianCalendar fechaDevolucion = new GregorianCalendar();

        for (Alquiler a: multimediaRentado) {

                if (a.getMutimedia().equals(m)&& a.getSocio().getNif()==nif){
                    multi=a.getMutimedia();

                    System.out.println("\nTitulo:"+multi.getTitulo()+"\nAlquilado a:"+a.getSocio().getNombre());

                    multi.setPrecio(multi.getPrecio()+calcularRecargo(multi));

                    System.out.println("Recargo:"+calcularRecargo(multi));

                    System.out.println("Precio final:"+multi.getPrecio());

                    multi.setFechaDevolucion(format.format(fechaDevolucion.getTime()));

                    System.out.println("Fecha de devolucion:"+multi.getPrecio());

                    socio= a.getSocio();

                    historialMultimediaRentado.add(new Alquiler(multi,socio));

                    alquiler=a;

                }
        }

        if(multimediaRentado.remove(alquiler)){
            return "Devuelto con exito. Hasta la proxima!";

        }else{
            return "No ha podido ser retornado.";
        }

    }
    public ArrayList<Multimedia> datosAleatoriosMultimedia(int cantidadP, int cantidadV){
        Faker faker = new Faker(new Locale("es"));
        ArrayList<Multimedia> multimedia= new ArrayList<>();
        String[] duraciones= {"1h","2h 30m","1h 15m","2h","2h 27m","1h 03m","1h 45m"};
        String titulo;
        String autor;
        String formato;
        int year;
        int precioTotal;
        String duracion;
        String actorP;
        String actrizP;
        String plataforma;

        for (int i = 0; i < cantidadP; i++) {
            titulo= faker.book().title();
            autor= faker.book().author();
            formato= Formato.values()[lib.aleatorio(0,Formato.values().length-1)].name();
            year= lib.aleatorio(1950,2019);
            duracion= duraciones[lib.aleatorio(0,duraciones.length-1)];
            actorP= faker.gameOfThrones().character();
            actrizP= faker.lordOfTheRings().character();
            multimedia.add(new Pelicula(titulo,autor,formato,year,duracion,actorP,actrizP));
        }

        for (int i = 0; i <cantidadV ; i++) {
            titulo= faker.esports().game();
            autor= faker.funnyName().name();
            formato= Formato.values()[lib.aleatorio(0,Formato.values().length-1)].name();
            year=lib.aleatorio(1970,2019);
            plataforma=Videojuego.Plataformas.values()[lib.aleatorio(0,Videojuego.Plataformas.values().length-1)].name();
            multimedia.add(new Videojuego(titulo,autor,formato,year,plataforma));
        }

        for (Multimedia m : multimedia) {
            precioTotal= PRECIO_BASE;
            if (m instanceof Pelicula){
                if (m.year < REBAJA_PELICULA){
                    precioTotal-=1;
                }

            } else if(m instanceof Videojuego){
                if (m.year < REBAJA_VIDEOJUEGO){
                    precioTotal-=1;
                }
            }

            m.setPrecio(precioTotal);
        }

        return multimedia;
    }

    public ArrayList<Socio> datosAleatoriosSocio(int cantidad){
        Faker faker = new Faker(new Locale("es"));
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Socio> socios= new ArrayList<>();
        String nombre;
        GregorianCalendar fechaNac;
        String fecha;
        String poblacion;

        for (int i = 0; i <cantidad ; i++) {
            nombre= faker.name().name();
            fechaNac = new GregorianCalendar(lib.aleatorio(1940,1999),lib.aleatorio(1,11),lib.aleatorio(1,28));
            fecha= format.format(fechaNac.getTime());
            poblacion= faker.gameOfThrones().city();

            socios.add(new Socio(nombre,fecha,poblacion));
        }

        return socios;
    }


}
