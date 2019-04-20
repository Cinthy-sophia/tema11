package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

import java.util.Scanner;

public class Ejercicio7 {
    private Lib lib = new Lib();
    public Scanner lector= new Scanner(System.in);

    public Ejercicio7(){
        int opcion;
        do {
            opcion= menuPrincipal();
            switch (opcion){
                case 1:
                    //todo nuevoPartido();
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
        String fechaP;
        boolean validado;
        do {
            System.out.println("**NUEVO PARTIDO**");
            System.out.println("Indique la fecha del partido: (dd/mm/yyyy)");
            fechaP= lector.nextLine();
            validado= fechaP.length()>10;//todo verificar fecha
            if (!validado){
                System.out.println("Error de datos.");
            }
        }while(!validado);
    }
     public void gestionEntradas(){
        int opcion;
        do {
            opcion= menuGestionEntradas();
            switch (opcion){
                case 1:
                    //todo ventaEntradas();
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
