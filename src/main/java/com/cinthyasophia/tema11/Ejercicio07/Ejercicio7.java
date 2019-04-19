package com.cinthyasophia.tema11.Ejercicio07;

import com.cinthyasophia.tema11.Util.Lib;

public class Ejercicio7 {
    private Lib lib = new Lib();

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
