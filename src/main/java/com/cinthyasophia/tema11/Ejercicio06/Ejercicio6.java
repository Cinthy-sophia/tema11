package com.cinthyasophia.tema11.Ejercicio06;
import com.cinthyasophia.tema11.Util.Lib;

import java.util.Scanner;

public class Ejercicio6 {
    private Lib lib= new Lib();
    public Scanner lector= new Scanner(System.in);

    private Videoclub videoclub= new Videoclub();
    public Ejercicio6(){
        int opcion;
        do {
            opcion=menuPrincipal();
            switch (opcion){
                case 1:
                    altas();
                    break;
                case 2:
                    //todo alquilarSocios()
                    break;
                case 3:
                    //todo devolverMultimedia()
                    break;
                case 4:
                    //todo listados()
                    break;
                case 0:
                    System.out.println("Adios :)");
                    break;
                default:
                    System.out.println("Error");
                    break;
            }

        }while(opcion!=0);

    }
    public void altas(){
        int opcion;
        do {
            opcion=menuAltas();
            switch (opcion){
                case 1:
                    nuevaPelicula();
                    break;
                case 2:
                    nuevoVideojuego();
                    break;
                case 3:
                    //todo nuevoSocio()
                    break;
                case 0:
                    lib.volverMenu();
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }while(opcion!=0);
    }
    public void nuevaPelicula(){
        boolean validado;
        String titulo;
        String autor;
        String formato;
        int year;
        String actorPrincipal;
        String actrizPrincipal;
        String duracion;

        System.out.println("**NUEVA PELICULA**");
        do {
            System.out.println("Indique el titulo:");
            titulo= lector.nextLine();
            validado= titulo.length()>1;
            if (!validado){
                System.out.println("El titulo es muy corto, intente de nuevo.");
            }
        }while(!validado);

        do {
            System.out.println("Indique el autor/creador: ");
            autor= lector.nextLine();
            validado= autor.length()>5;
            if (!validado){
                System.out.println("El nombre es muy corto, intente de nuevo.");
            }
        }while(!validado);

        formato=menuFormato().name();

        do {
            System.out.println("Indica el año:");
            year= lector.nextInt();
            lector.nextLine();
            validado= year>=1950 && year<=2019;

            if (!validado){
                System.out.println("Año invalido, intente de nuevo.");
            }
        }while(!validado);

        do {
            System.out.println("Indique el actor principal: ");
            actorPrincipal= lector.nextLine();
            validado= actorPrincipal.length()>5;
            if (!validado){
                System.out.println("El nombre del actor es muy corto, intente de nuevo.");
            }
        }while(!validado);

        do {
            System.out.println("Indique el nombre de la actriz principal: ");
            actrizPrincipal= lector.nextLine();
            validado= actrizPrincipal.length()>5;
            if (!validado){
                System.out.println("El nombre de la actriz es muy corto, intente de nuevo.");
            }
        }while(!validado);

        do {
            System.out.println("Indique la duracion de la pelicula (Ejemplo: 1h 23m):");
            duracion= lector.nextLine();
            validado= duracion.length()>=2;
            if (!validado){
                System.out.println("Los datos son incorrectos");
            }
        }while(!validado);

        videoclub.nuevaPelicula(new Pelicula(titulo, autor, formato, duracion, actorPrincipal,actrizPrincipal, year));
    }

    public void nuevoVideojuego(){
        boolean validado;
        String titulo;
        String autor;
        String formato;
        int year;
        do {
            System.out.println("Indique el titulo:");
            titulo= lector.nextLine();
            validado= titulo.length()>1;
            if (!validado){
                System.out.println("El titulo es muy corto, intente de nuevo.");
            }
        }while(!validado);

        do {
            System.out.println("Indique el autor/creador: ");
            autor= lector.nextLine();
            validado= autor.length()>5;
            if (!validado){
                System.out.println("El nombre es muy corto, intente de nuevo.");
            }
        }while(!validado);

        formato=menuFormato().name();

        do {
            System.out.println("Indica el año:");
            year= lector.nextInt();
            lector.nextLine();
            validado= year>=1950 && year<=2019;

            if (!validado){
                System.out.println("Año invalido, intente de nuevo.");
            }
        }while(!validado);


    }
    public Formato menuFormato(){
        int opcion;
        Formato opFormato;
        Formato[] formato=Formato.values();
        System.out.println("*FORMATOS*");
        for (Formato f:formato) {
            System.out.println(f.ordinal()+"."+f.name());
        }
        System.out.println("Selecciona el formato de la pelicula:");
        opcion= lib.validarOpcion(0,formato.length);

        opFormato= formato[opcion];

        return opFormato;
    }

    public void devolverMultimedia(){
        //todo verificar la fecha de retorno y ver si hay que cobrar algun recargo al socio
    }
    public void listados(){
        int opcion;
        do {
            opcion= menuListados();
            switch (opcion){
                case 1:
                    //todo listadoTodosLosMultimedias()
                    break;
                case 2:
                    //todo listadoTodosLasPeliculasPorTitulo()
                    break;
                case 3:
                    //todo listadoTodosLosVideojuegosPorAño()
                    break;
                case 4:
                    //todo listadoAlquileresDeSocioPorFecha()
                    break;
                case 5:
                    //todo listadoSociosConRecargosPendientes()
                    break;
                case 0:
                    lib.volverMenu();
                    break;
                default:
                    System.out.println("Error");
                    break;

            }
        }while(opcion!=0);
    }
    public int menuListados(){
        System.out.println("**********");
        System.out.println("*LISTADOS*");
        System.out.println("**********");
        System.out.println("1. Listado de todos los multimedias.");
        System.out.println("2. Listado de todas las peliculas ordenadas por titulo.");
        System.out.println("3. Listado de todos los videojuegos ordenados por año.");
        System.out.println("4. Listado de alquileres de un socio ordenados por fecha.");
        System.out.println("5. Listado de alquileres actuales de un socio.");
        System.out.println("6. Listado de los socios con recargos pendientes.");
        System.out.println("0. Volver al menu principal.");
        System.out.println("**************");
        System.out.println("Selecciona una opcion del menu: ");

        return lib.validarOpcion(0,6);
    }
    public int menuPrincipal(){
        System.out.println("***********");
        System.out.println("*VIDEOCLUB*");
        System.out.println("***********");
        System.out.println("1. Altas...");
        System.out.println("2. Alquilar multimedia a socios.");
        System.out.println("3. Devolver multimedia.");
        System.out.println("4. Listados...");
        System.out.println("0. Salir.");
        System.out.println("**************");
        System.out.println("Selecciona una opcion del menu: ");

        return lib.validarOpcion(0,4);
    }
    public int menuAltas(){
        System.out.println("*******");
        System.out.println("*ALTAS*");
        System.out.println("*******");
        System.out.println("1. Alta de una nueva pelicula.");
        System.out.println("2. Alta de un nuevo videojuego.");
        System.out.println("3. Alta de un nuevo socio.");
        System.out.println("0. Volver al menu principal.");
        System.out.println("**************");
        System.out.println("Selecciona una opcion del menu: ");

        return lib.validarOpcion(0,3);
    }
}
