package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.util.Scanner;

public class Ejercicio7 {
    private Lib lib = new Lib();
    public Scanner lector= new Scanner(System.in);

    private Estadio estadio;

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
            validado= cantidadEntradas >= 1&& cantidadEntradas<= estadio.getCantidadTotalDeAsientosPorZona();

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
        boolean partidoOld= false;
        String yaJugado= "Partido ya jugado, solo puede verificar la recaudacion.";

        if (!estadio.getPartidos().isEmpty()){
            for (Partido p: estadio.getPartidos()) {
                System.out.println(p.toString());
                System.out.println("Entradas a vender: " + p.getCantidadEntradas());
                System.out.println("Entradas disponibles: "+(p.getCantidadEntradas()-estadio.getEntradasVendidas().size()));
            }

        }else{
            System.out.println("No existen partidos creados.");
        }


         do {
             System.out.println("Indique el numero del partido al que desea gestionar:");
             idPartido = lector.nextInt();
             lector.nextLine();

             for (Partido p: estadio.getPartidos()) {
                 if (p.getCodPartido() == idPartido){
                     partido=p;
                     if(lib.fechaIsBeforeNow(p.getFechaPartido())){
                         System.out.println("Has escogido un partido anterior a la fecha actual, solo podrás verificar la recaudacion del partido.");
                        partidoOld=true;
                     }
                     validado=true;
                 }
             }

             if (!validado) {
                 System.out.println("El partido no existe. Intenta de nuevo.");
             }

        } while (!validado);

        do {
            opcion = menuGestionEntradas();
            switch (opcion) {
                case 1:
                    if (partidoOld){
                        System.out.println(yaJugado);
                    }else{
                        ventaEntradas(partido);
                    }
                    break;
                case 2:
                    if (partidoOld){
                        System.out.println(yaJugado);
                    }else{

                        devolverEntrada(partido);
                    }
                    break;
                case 3:
                    if (partidoOld){
                        System.out.println(yaJugado);
                    }else{
                        listadoAsientos(true);
                    }
                    break;
                case 4:
                    if (partidoOld){
                        System.out.println(yaJugado);
                    }else{
                        listadoAsientos(false);
                    }
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
        int numE;

        do {
            System.out.println("Indica la cantidad de entradas que deseas comprar:");
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
                System.out.println("Indica la fila que deseas: ");
                fila= lector.nextInt();
                lector.nextLine();
                validado= fila > 0 && fila <= estadio.getZonas().get(opcionE).CANTIDAD_FILAS;
                if (!validado){
                    System.out.println("Numero de fila incorrecto.");
                }
            }while(!validado);

            do {
                System.out.println("Indica el numero de asiento que deseas: ");
                numAsiento= lector.nextInt();
                lector.nextLine();
                validado= numAsiento > 0 && numAsiento <= estadio.getCantidadTotalDeAsientosPorZona() && estadio.getZonas().get(opcionE).getAsiento(numAsiento)!=null && !estadio.getZonas().get(opcionE).getAsiento(numAsiento).isOcupado();
                if(!validado){
                    System.out.println("Numero de asiento incorrecto.");
                }
            }while(!validado);

            asiento=estadio.getZonas().get(opcionE).getAsiento(numAsiento);

            System.out.println(estadio.venderEntrada(partido,asiento));

        }


     }
     public void devolverEntrada(Partido partido){
         boolean validado;
         int numeroEntrada;
         do {
             System.out.println("Indica el numero identificador de la entrada que deseas devolver:");
             numeroEntrada= lector.nextInt();
             lector.nextLine();
             validado=numeroEntrada<=partido.getCantidadEntradas();
             if (!validado){
                 System.out.println("Numero no valido. Intente de nuevo.");
             }
         }while (!validado);

         System.out.println(estadio.regresarEntrada(numeroEntrada));
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

         System.out.println(partido.toString()+"\nHa recaudado: "+Math.floor(partido.getRecaudacion()));

     }

    public int menuZonas(){
        int opcion;
        Zona.TipoZona[] tiposZonas= Zona.TipoZona.values();
        System.out.println("**ZONAS DEL ESTADIO**");

        for (int i = 0; i < tiposZonas.length; i++) {
            System.out.println(tiposZonas[i].ordinal()+". "+tiposZonas[i].name());
        }
        System.out.println("Selecciona la zona:");
        opcion= lib.validarOpcion(0,tiposZonas.length-1);

        return opcion;

    }

    public Partido.TipoPartido menuTipoPartido(){
        int opcion;
        Partido.TipoPartido opTipoPartido;
        Partido.TipoPartido[] tiposPartido= Partido.TipoPartido.values();
        System.out.println("**TIPOS DE PARTIDO**");

        for (int i = 0; i < tiposPartido.length; i++) {
            System.out.println(tiposPartido[i].ordinal()+". "+tiposPartido[i].name());
        }
        System.out.println("Selecciona el tipo:");
        opcion= lib.validarOpcion(0,tiposPartido.length-1);

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
