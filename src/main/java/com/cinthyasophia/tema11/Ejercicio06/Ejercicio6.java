package com.cinthyasophia.tema11.Ejercicio06;
import com.cinthyasophia.tema11.Util.Lib;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

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
                    alquilarMultimedia();
                    break;
                case 3:
                    devolverMultimedia();
                    break;
                case 4:
                    listados();
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
                    altaPelicula();
                    break;
                case 2:
                    altaVideojuego();
                    break;
                case 3:
                    altaSocio();
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
    public void altaPelicula(){
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

        for (Multimedia m: videoclub.getMultimedia()) {
            if (m.equals(new Pelicula(titulo,autor))){
                System.out.println("Ya se encuentra en el inventario, intente con otro.");
                return;
            }
        }

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


        System.out.println(videoclub.nuevoMultimedia(new Pelicula(titulo, autor, formato, year, duracion, actorPrincipal,actrizPrincipal)));

    }

    public void altaVideojuego(){
        boolean validado;
        String titulo;
        String autor;
        String formato;
        int year;
        String plataforma;

        System.out.println("**NUEVO VIDEOJUEGO**");
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

        for (Multimedia m: videoclub.getMultimedia()) {
            if (m.equals(new Pelicula(titulo,autor))){
                System.out.println("Ya se encuentra en el inventario, intente con otro.");
                return;
            }
        }

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

        plataforma= menuPlataformas().name();

        System.out.println(videoclub.nuevoMultimedia(new Videojuego(titulo,autor,formato,year,plataforma)));

    }

    public void altaSocio(){
        boolean validado;
        String nombre;
        String fecha;
        String poblacion;

        System.out.println("**NUEVO SOCIO**");
        do {
            System.out.println("Indique el nombre: ");
            nombre= lector.nextLine();
            validado= nombre.length()>5;
            if (!validado){
                System.out.println("El nombre es muy corto, intente de nuevo.");
            }
        }while(!validado);
        do {
            System.out.println("Indique la fecha de nacimiento: ");
            fecha= lector.nextLine();
            validado= !fecha.isEmpty();
            if (!validado){
                System.out.println("La fecha es incorrecta.");
            }
        }while(!validado);

        do {
            System.out.println("Indique la poblacion donde vive: ");
            poblacion= lector.nextLine();
            validado= poblacion.length()>2;
            if (!validado){
                System.out.println("El nombre de la poblacion es muy corto, intente de nuevo.");
            }
        }while(!validado);


        if (videoclub.nuevoSocio(new Socio(nombre,fecha,poblacion))){
            System.out.println(nombre+" añadido/a correctamente.");
        } else{
            System.out.println(nombre+" no ha podido ser añadido.");
        }
    }

    public void alquilarMultimedia(){
        int nif;
        Socio socio= new Socio();
        String multimediaS;
        boolean validado=true;
        String titulo;
        String autor;
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar ahora = new GregorianCalendar();
        String fecha;

        System.out.println("**ALQUILAR MULTIMEDIA**");
        do {
            System.out.println("Indique el NIF de un socio:");
            nif= lector.nextInt();
            lector.nextLine();

            for (Socio s: videoclub.getSocios()) {
                validado=  nif!=0 && s.getNif() == nif;
                if (validado){
                    socio=s;
                }
            }

            if (!validado){
                System.out.println("Indique el NIF de un socio existente.");

            }else if(videoclub.comprobarSocio(socio.getNif())){
                System.out.println("El socio tiene un recargo pendiente por pagar.");
                return;

            }

        }while(!validado);

        do {
            System.out.println("Indique P si desea alquilar una pelicula, o V si desea alquilar un videojuego:");
            multimediaS= lector.nextLine();
            validado= multimediaS.equalsIgnoreCase("p") || multimediaS.equalsIgnoreCase("v");
            if (!validado){
                System.out.println("Opcion no valida.");

            }

        }while(!validado);

        do {
            System.out.println("Indique el titulo y el autor del multimedia que desea alquilar:");
            do {
                System.out.print("Titulo:");
                titulo= lector.nextLine();
                System.out.print("\nAutor:");
                autor= lector.nextLine();
                validado= autor.length()>5 && titulo.length()>1;
                if (!validado){
                    System.out.println("Datos incorrectos, es posible que el titulo o el autor sean muy cortos.");
                }
            }while(!validado);

            if (multimediaS.equalsIgnoreCase("p")){
                validado=videoclub.comprobarMultimedia(new Pelicula(titulo,autor));
            }else{
                validado=videoclub.comprobarMultimedia(new Videojuego(titulo,autor));
            }

            if (!validado){
                System.out.println("El multimedia no esta disponible, o no existe. Indique otro.");
            }
        }while(!validado);

        fecha= format.format(ahora.getTime());

       if (multimediaS.equalsIgnoreCase("p")){
            System.out.println(videoclub.alquilar(socio,new Pelicula(titulo,autor),fecha));
       }else{
            System.out.println(videoclub.alquilar(socio,new Videojuego(titulo,autor),fecha));
       }
    }

    public void devolverMultimedia(){
        String titulo;
        String autor;
        String multimediaS;
        boolean validado= true;
        int nif;

        System.out.println("**DEVOLVER MULTIMEDIA**");
        do {
            System.out.println("Indique el NIF de un socio:");
            nif= lector.nextInt();
            lector.nextLine();

            for (Socio s : videoclub.getSocios()) {
                validado =  nif!=0 && s.getNif() == nif ;

            }
            if (!validado){
                System.out.println("Indique el NIF de un socio existente.");
            }

        }while(!validado);

        do {
            System.out.println("Indique P si es una pelicula, o V si es un videojuego:");
            multimediaS= lector.nextLine();
            validado= multimediaS.equalsIgnoreCase("p") || multimediaS.equalsIgnoreCase("v");
            if (!validado){
                System.out.println("Opcion no valida.");

            }

        }while(!validado);

        do {
            System.out.println("Indique el titulo y el autor:");
            System.out.print("Titulo:");
            titulo= lector.nextLine();
            System.out.print("\nAutor:");
            autor= lector.nextLine();
            validado= autor.length()>5 && titulo.length()>1;
            if (!validado){
                System.out.println("Datos incorrectos, es posible que el titulo o el autor sean muy cortos.");
            }
        }while(!validado);

        if (multimediaS.equalsIgnoreCase("p")){
            System.out.println(videoclub.devolver(nif,new Pelicula(titulo,autor)));

        }else{
            System.out.println(videoclub.devolver(nif,new Pelicula(titulo,autor)));
        }

    }

    public Formato menuFormato(){
        int opcion;
        Formato opFormato;
        Formato[] formato=Formato.values();
        System.out.println("*FORMATOS*");

        for (int i = 0; i < formato.length; i++) {
            System.out.println(formato[i].ordinal()+". "+formato[i].name());
        }
        System.out.println("Selecciona el formato de la pelicula:");
        opcion= lib.validarOpcion(0,formato.length);

        opFormato= formato[opcion];

        return opFormato;
    }
    public Videojuego.Plataformas menuPlataformas(){
        int opcion;
        Videojuego.Plataformas opPlataforma;
        Videojuego.Plataformas[] plataformas= Videojuego.Plataformas.values();

        System.out.println("*PLATAFORMAS*");
        for (int i = 0; i < plataformas.length; i++) {
            System.out.println(plataformas[i].ordinal()+"."+plataformas[i].name());
        }
        System.out.println("Selecciona el formato de la pelicula:");
        opcion= lib.validarOpcion(0,plataformas.length);

        opPlataforma= plataformas[opcion];

        return opPlataforma;
    }

    public void listados(){
        int opcion;
        do {
            opcion= menuListados();
            switch (opcion){
                case 1:
                    listadoTodosLosMultimedias();
                    break;
                case 2:
                    listadoPeliculasPorTitulo();
                    break;
                case 3:
                    listadoVideojuegos();
                    break;
                case 4:
                    listadoHistoricoDeAlquileres();
                    break;
                case 5:
                    listadoAlquileresActualesSocio();
                    break;
                case 6:
                    listadoSociosRecargosPendientes();
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
    public void listadoTodosLosMultimedias(){
        for (Multimedia m: videoclub.getMultimedia()) {
            System.out.println(m.toString());
        }

    }
    public void listadoVideojuegos(){
        videoclub.getMultimedia().sort(new Multimedia.ComparatorYear());
        for (Multimedia m: videoclub.getMultimedia()) {
            if (m instanceof Videojuego){
                System.out.println(m.toString());

            }
        }

    }

    public void listadoPeliculasPorTitulo(){
        Collections.sort(videoclub.getMultimedia());

        for (Multimedia m: videoclub.getMultimedia()) {
            if (m instanceof Pelicula){
                System.out.println(m.toString());
            }

        }
    }

    public void listadoAlquileresActualesSocio(){
        int nif;
        boolean validado=true;
        do {
            System.out.println("Indique el NIF de un socio:");
            nif= lector.nextInt();
            lector.nextLine();

            for (Socio s: videoclub.getSocios()) {
                validado= s.getNif() == nif;

            }
            if (!validado){
                System.out.println("Indique el NIF de un socio existente.");
            }

        }while(!validado);

        for (Alquiler a : videoclub.getMultimediaRentado()) {
            if (a.getSocio().getNif()==nif){
                System.out.println(a.getMutimedia().toString()+"\nAlquilado a:"+a.getSocio().getNombre());
            }
        }
    }

    public void listadoSociosRecargosPendientes(){
        for (Alquiler a: videoclub.getMultimediaRentado()) {
            if (a.getMutimedia().getFechaDevolucion()!=null){
                if (videoclub.calcularRecargo(a.getMutimedia())!=0){
                    System.out.println(a.getSocio().toString()+"\nRecargo de:"+videoclub.calcularRecargo(a.getMutimedia())+"\nMultimedia alquilado:"+a.getMutimedia().getTitulo());
                }
            }
        }

    }
    public void listadoHistoricoDeAlquileres(){
        videoclub.getHistorialMultimediaRentado().sort(new Alquiler.ComparatorYear());

        for (Alquiler a: videoclub.getHistorialMultimediaRentado()) {
            System.out.println(a.toString());
        }
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
    public int menuListados(){
        System.out.println("**********");
        System.out.println("*LISTADOS*");
        System.out.println("**********");
        System.out.println("1. Listado de todos los multimedias.");
        System.out.println("2. Listado de todas las peliculas ordenadas por titulo.");
        System.out.println("3. Listado de todos los videojuegos ordenados por año.");
        System.out.println("4. Listado historico de los alquileres de un socio ordenados por fecha.");
        System.out.println("5. Listado de alquileres actuales de un socio.");
        System.out.println("6. Listado de los socios con recargos pendientes.");
        System.out.println("0. Volver al menu principal.");
        System.out.println("**************");
        System.out.println("Selecciona una opcion del menu: ");

        return lib.validarOpcion(0,6);
    }

}
