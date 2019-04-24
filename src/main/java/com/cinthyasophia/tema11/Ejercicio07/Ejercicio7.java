package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Ejercicio7 {
    private Lib lib = new Lib();
    public Scanner lector= new Scanner(System.in);

    private Estadio estadio;
    private Boleteria boleteria;

    public Ejercicio7(){
        estadio= new Estadio();

        int opcion;
        do {
            opcion= menuPrincipal();
            switch (opcion){
                case 1:
                    nuevoPartido();
                    break;
                case 2:
                    gestionEntradas();
                    break;
                case 0:
                    System.out.println("Adios! :)");
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }
        }while(opcion!=0);
    }
    public void nuevoPartido(){
        int cantidadEntradas;
        String fechaP;
        String tipoPartido;
        String equipoLocal;
        String equipoVisitante;
        boolean validado;
        do {
            System.out.println("**NUEVO PARTIDO**");
            System.out.println("Indique la fecha del partido (dd/mm/yyyy):");
            fechaP= lector.nextLine();
            validado= fechaP.length() >= 10;//todo verificar fecha
            if (!validado){
                System.out.println("Fecha no valida. Intente de nuevo y recuerde que el formato es dd/mm/yyyy.");
            }
        }while(!validado);

        tipoPartido= menuTipoPartido().name();

        do{
            System.out.println("Indique el equipo local:");// todo enum de equipos disponibles
            equipoLocal= lector.nextLine();
            validado= equipoLocal.length()>= 5;
            if(!validado){
                System.out.println("Equipo no valido. Intente de nuevo.");
            }
        }while(!validado);
        do{
            System.out.println("Indique el equipo visitante:");
            equipoVisitante= lector.nextLine();
            validado= equipoVisitante.length()>= 5;
            if(!validado){
                System.out.println("Equipo no valido. Intente de nuevo.");
            }
        }while(!validado);

        do{
            System.out.println("Indique cuantas entradas se van a vender para este partido:");
            cantidadEntradas= lector.nextInt();
            lector.nextLine();
            validado= cantidadEntradas >= 1;
            if(!validado){
                System.out.println("Cantidad de entradas no valida. Intente de nuevo.");
            }
        }while(!validado);

        System.out.println(estadio.nuevoPartido(new Partido(tipoPartido,fechaP,equipoLocal,equipoVisitante),cantidadEntradas));
    }

     public void gestionEntradas(){
        int idPartido;
        Partido partido;
        for (Partido p: estadio.getPartidos()) {
            if (!lib.fechaIsBeforeNow(p.getFechaPartido()))
             System.out.println(p.toString());
        }

        System.out.println("Indica el numero del partido al que deseas asistir:");
        idPartido= lector.nextInt();
        lector.nextLine();


        for (Partido p: estadio.getPartidos()) {
            if (p.getCodPartido()==idPartido) {
                partido= p;
            }
        }


        int opcion;
        do {
            opcion= menuGestionEntradas();
            switch (opcion){
                case 1:
                    //todo ventaEntradas(partido);
                    break;
                case 2:
                    //todo devolverEntrada();
                    break;
                case 3:
                    //todo listadoAsientosOcupados();
                    break;
                case 4:
                    //todo listadoAsientosLibres();
                    break;
                case 5:
                    //todo recaudacionPartido();
                    break;
                case 0:
                    System.out.println(lib.volverMenu());
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }
        }while(opcion!=0);
     }

     public void ventaEntradas(Partido partido){
        boolean validado;
        int cantidadEntradas;
        int opcionE;
        int fila;
        int asiento;

        System.out.println("***********");
        System.out.println("*BOLETERIA*");
        System.out.println("***********");

        do {
            System.out.println("Indique la cantidad de entradas que desea comprar:");
            cantidadEntradas= lector.nextInt();
            lector.nextLine();
            validado= cantidadEntradas>0;
        }while (!validado);

        for (int i = 0; i < cantidadEntradas ; i++) {
            opcionE= menuZonas();
            do {
                estadio.getZonas().get(opcionE).mostrarAsientos();
                System.out.println("Indique la fila que desea: ");
                fila= lector.nextInt();
                lector.nextLine();
                validado= fila<= estadio.getZonas().get(opcionE).CANTIDAD_FILAS;
            }while(!validado);

            do {
                System.out.println("Indique el numero de asiento que desea: ");
                asiento= lector.nextInt();
                lector.nextLine();
                validado= asiento<= estadio.getZonas().get(opcionE).CANTIDAD_ASIENTOS;
            }while(!validado);

            estadio.getZonas().get(opcionE).getAsiento(asiento).setOcupado(true);

            System.out.println(estadio.nuevaEntrada(partido,estadio.getZonas().get(opcionE).getAsiento(asiento)));
        }


     }
     public int menuZonas(){
         int opcion;
         Zona.TipoZona[] tiposZonas= Zona.TipoZona.values();
         System.out.println("*ZONAS DEL ESTADIO*");

         for (int i = 0; i < tiposZonas.length; i++) {
             System.out.println(tiposZonas[i].ordinal()+". "+tiposZonas[i].name());
         }
         System.out.println("Selecciona la zona:");
         opcion= lib.validarOpcion(0,tiposZonas.length);

         return opcion;

     }
     public Partido.TipoPartido menuTipoPartido(){
        int opcion;
        Partido.TipoPartido opTipoPartido;
        Partido.TipoPartido[] tiposPartido= Partido.TipoPartido.values();
        System.out.println("*TIPOS DE PARTIDO*");

        for (int i = 0; i < tiposPartido.length; i++) {
            System.out.println(tiposPartido[i].ordinal()+". "+tiposPartido[i].name());
        }
        System.out.println("Selecciona el tipo:");
        opcion= lib.validarOpcion(0,tiposPartido.length);

        opTipoPartido= tiposPartido[opcion];

        return opTipoPartido;
     }

     public void listadoAsientosOcupados(){

     }

    public int menuGestionEntradas(){
        int opcion;
        System.out.println("*********************");
        System.out.println("*GESTION DE ENTRADAS*");
        System.out.println("*********************");
        System.out.println("1.Venta de entradas.");// todo muestra la matriz con los asientos disponibles y ocupados, y pide el numero deseado
        System.out.println("2.Devolver una entrada.");
        System.out.println("3.Listado de los asientos ocupados.");
        System.out.println("4.Listado de las asientos libres.");
        System.out.println("5.Mostrar recaudacion del partido.");
        System.out.println("0.Volver al menu principal.");
        System.out.println("****************");

        opcion= lib.validarOpcion(0,5);
        return opcion;
    }
    public int menuPrincipal(){
        int opcion;
        System.out.println("*********");
        System.out.println("*ESTADIO*");
        System.out.println("*********");
        System.out.println("1.Nuevo partido.");
        System.out.println("2.Gestion de entradas.");
        System.out.println("0.Salir.");
        System.out.println("****************");

        opcion= lib.validarOpcion(0,2);
        return opcion;
    }
}
