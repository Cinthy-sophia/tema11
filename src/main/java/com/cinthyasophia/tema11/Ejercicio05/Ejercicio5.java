package com.cinthyasophia.tema11.Ejercicio05;
import com.cinthyasophia.tema11.Util.Lib;
import java.util.Scanner;

public class Ejercicio5 {
    public Scanner lector = new Scanner(System.in);
    private Lib lib = new Lib();
    private final int INVENTARIO_SIZE=7;
    private Casilla[] inventario;

    public Ejercicio5(){
        int opcion;
        do {
            opcion= menuPrincipal();
            switch (opcion){
                case 1:
                    //todo agregarItem()
                    //verificar la cantidad de items apilables
                    break;

                case 2:
                    //todo eliminarItem()
                    break;

                case 3:
                    //todo mostrarInventario()
                    break;

                case 0:
                    System.out.println("Adios. :)");
                    break;

                default:
                    System.out.println("Error");
                    break;
            }

        }while (opcion!=0);

    }
    public void agregarItem(){
        int opcion;
        do {
            opcion=listaItems();
            switch (opcion){
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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

    public void eliminarItem(){
        int opcion;
        do {
            opcion=listaItems();
            switch (opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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

    public int menuPrincipal(){
        int opcion;
        System.out.println("************");
        System.out.println("*INVENTARIO*");
        System.out.println("************");
        System.out.println("1. Añadir al inventario.");
        System.out.println("2. Eliminar del inventario.");
        System.out.println("3. Mostrar inventario.");
        System.out.println("************");
        System.out.println("0. Salir.");
        System.out.print("Elige una opcion del menu:");

        opcion= lib.validarOpcion(0,3);

        return opcion;

    }
    public int listaItems(){
        int opcion;
        System.out.println("*************");
        System.out.println("****ITEMS****");
        System.out.println("*************");
        System.out.println("1. Pico.");
        System.out.println("2. Espada.");
        System.out.println("3. Piedra.");
        System.out.println("4. Madera.");
        System.out.println("5. Huevo.");
        System.out.println("6. Perla de Ender.");
        System.out.println("*************");
        System.out.println("0. Volver al menu principal.");

        opcion= lib.validarOpcion(0,6);

        return opcion;


    }

}
