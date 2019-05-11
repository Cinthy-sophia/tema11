package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio7 {
    private Lib lib = new Lib();
    public Scanner lector= new Scanner(System.in);

    private Estadio estadio;
    private Boleteria boleteria;

    public Ejercicio7(){
        estadio= new Estadio();
        boleteria= new Boleteria();
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
        System.out.println("**NUEVO PARTIDO**");
        do {
            System.out.println("Indique la fecha del partido (dd/mm/yyyy):");
            fechaP= lector.nextLine();
            validado= fechaP.length() >= 10&& !lib.fechaIsBeforeNow(lib.getFecha(fechaP));

            if (!validado){
                System.out.println("Fecha no valida. Intente de nuevo y recuerde que el formato es dd/mm/yyyy.");
            }

        }while(!validado);

        tipoPartido= menuTipoPartido().name();

        do{
            System.out.println("Indique el equipo local:");
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
            validado= cantidadEntradas >= 1&& cantidadEntradas<= estadio.getCANTIDAD_TOTAL_ASIENTOS();

            if(!validado){
                System.out.println("Cantidad de entradas no valida. Intente de nuevo.");
            }
        }while(!validado);
        System.out.println(estadio.nuevoPartido(new Partido(tipoPartido,fechaP,equipoLocal,equipoVisitante,cantidadEntradas)));
    }

     public void gestionEntradas(){
        int idPartido;
        int opcion;
        Partido partido=null;
        boolean validado = false;

        if (!estadio.getPartidos().isEmpty()){
            for (Partido p: estadio.getPartidos()) {
                System.out.println(p.toString());
                System.out.println("Entradas disponibles: "+(p.getCantidadEntradas()-boleteria.getEntradasVendidas().size()));
            }

        }else{
            System.out.println("No existen partidos creados.");
        }


         do {
             System.out.println("Indica el numero del partido al que deseas asistir:");
             idPartido = lector.nextInt();
             lector.nextLine();

             for (Partido p: estadio.getPartidos()) {
                 if (p.getCodPartido() == idPartido){
                     partido=p;
                     if(lib.fechaIsBeforeNow(p.getFechaPartido())){
                         System.out.println("Ha escogido un partido anterior a la fecha actual, solo podrá verificar la recaudacion del partido.");
                     }
                     validado=true;
                 }
             }

             if (!validado) {
                 System.out.println("El partido no existe. Intente de nuevo.");
             }

        } while (!validado);

        do {
            opcion = menuGestionEntradas();
            switch (opcion) {
                case 1:
                    ventaEntradas(partido);
                    break;
                case 2:
                    devolverEntrada();
                    break;
                case 3:
                    listadoAsientos(true);
                    break;
                case 4:
                    listadoAsientos(false);
                    break;
                case 5:
                    recaudacionPartido(partido);
                    break;
                case 0:
                    System.out.println(lib.volverMenu());
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }
        } while (opcion != 0);
     }

     public void ventaEntradas(Partido partido){
        boolean validado;
        int cantidadEntradas;
        int opcionE;
        int fila;
        int numAsiento;
        Asiento asiento;
        Entrada entrada;
        int numE;

        do {
            System.out.println("Indique la cantidad de entradas que desea comprar:");
            cantidadEntradas= lector.nextInt();
            lector.nextLine();
            validado= cantidadEntradas>0;
        }while (!validado);

        for (int i = 0; i < cantidadEntradas ; i++) {
            numE=i;
            System.out.println("ENTRADA "+ ++numE +": ");
            opcionE= menuZonas();
            do {
                estadio.getZonas().get(opcionE).mostrarAsientos();
                System.out.println("Indique la fila que desea: ");
                fila= lector.nextInt();
                lector.nextLine();
                validado= fila > 0 && fila <= estadio.getZonas().get(opcionE).CANTIDAD_FILAS;
                if (!validado){
                    System.out.println("Numero de fila incorrecto.");
                }
            }while(!validado);

            do {
                System.out.println("Indique el numero de asiento que desea: ");
                numAsiento= lector.nextInt();
                lector.nextLine();
                validado= numAsiento >0 && numAsiento <= estadio.getZonas().get(opcionE).CANTIDAD_ASIENTOS && !estadio.getZonas().get(opcionE).getAsiento(numAsiento).isOcupado();
                if(!validado){
                    System.out.println("Numero de asiento incorrecto.");
                }
            }while(!validado);

            asiento=estadio.getZonas().get(opcionE).getAsiento(numAsiento);

            entrada= boleteria.venderEntrada(partido,asiento,partido.getCantidadEntradas());


            if (entrada!=null){
                System.out.println(entrada.toString());
            }else{
               System.out.println("La entrada no ha podido ser creada. Vuelva a intentarlo.");
            }
        }


     }
     public void devolverEntrada(){
         boolean validado;
         int numeroEntrada;

         do {
             System.out.println("Indique el numero identificador de la entrada que desea devolver:");
             numeroEntrada= lector.nextInt();
             lector.nextLine();
             validado=numeroEntrada<=estadio.getCANTIDAD_TOTAL_ASIENTOS();
             if (!validado){
                 System.out.println("Numero no valido. Intente de nuevo.");
             }
         }while (!validado);

         Entrada entrada=boleteria.devolverEntrada(numeroEntrada);

         if (entrada!= null){
             System.out.println(entrada.toString()+"\nDevuelta con éxito.");
         }else{
             System.out.println("No ha podido ser devuelta, intente de nuevo.");
         }
     }

     public int menuZonas(){
         int opcion;
         Zona.TipoZona[] tiposZonas= Zona.TipoZona.values();
         System.out.println("**ZONAS DEL ESTADIO**");

         for (int i = 0; i < tiposZonas.length; i++) {
             System.out.println(i+1 +". "+tiposZonas[i].name());
         }
         System.out.println("Selecciona la zona:");
         opcion= lib.validarOpcion(0,tiposZonas.length);

         return opcion;

     }
     public void listadoAsientos(boolean ocupado){
        int opcion;
        opcion= menuZonas();

        for (Asiento[] asiento : estadio.getZonas().get(opcion).getAsientos()) {//filas
            for (Asiento value : asiento) {//columnas
                if (value.isOcupado()==ocupado){
                    System.out.println(value.toString());
                }
            }
            System.out.println();
        }

     }

    public void recaudacionPartido(Partido partido){
         SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");

         System.out.println("El partido "+partido.getCodPartido()+" jugado en la fecha "+format.format(partido.getFechaPartido().getTime())+" ha recaudado: "+partido.getRecaudacion());

     }

    public Partido.TipoPartido menuTipoPartido(){
        int opcion;
        Partido.TipoPartido opTipoPartido;
        Partido.TipoPartido[] tiposPartido= Partido.TipoPartido.values();
        System.out.println("**TIPOS DE PARTIDO**");

        for (int i = 0; i < tiposPartido.length; i++) {
            System.out.println(i+1 +". "+tiposPartido[i].name());
        }
        System.out.println("Selecciona el tipo:");
        opcion= lib.validarOpcion(0,tiposPartido.length);

        opTipoPartido= tiposPartido[opcion];

        return opTipoPartido;
    }

    public int menuGestionEntradas(){
        int opcion;
        System.out.println("***********");
        System.out.println("*BOLETERIA*");
        System.out.println("***********");
        System.out.println("1.Venta de entradas.");
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
