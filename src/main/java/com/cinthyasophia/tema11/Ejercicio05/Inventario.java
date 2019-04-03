package com.cinthyasophia.tema11.Ejercicio05;

import com.cinthyasophia.tema11.Util.Lib;
import java.util.Scanner;

public class Inventario {
    public Scanner lector = new Scanner(System.in);
    private Lib lib = new Lib();
    private final int INVENTARIO_SIZE=7;
    private Casilla[] inventario;

    public Inventario(){
        int opcion;
        inventario= new Casilla[INVENTARIO_SIZE];
        for (int i = 0; i < inventario.length; i++) {
            inventario[i]= new Casilla();
        }
        do {
            opcion= menuPrincipal();
            switch (opcion){
                case 1:
                    agregar();
                    break;

                case 2:
                    eliminar();
                    break;

                case 3:
                    mostrarInventario();
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
    public void mostrarInventario(){
        for (Casilla casilla:inventario) {
            System.out.println(casilla.toString());
        }
        
    }

    public void agregar(){
        int opcion;
        do {
            opcion=listaItems();
            switch (opcion){
                case 1:
                    System.out.println(agregarItem(new Pico()));
                    break;
                case 2:
                    System.out.println(agregarItem(new Espada()));
                    break;
                case 3:
                    System.out.println(agregarItem(new Piedra()));
                    break;
                case 4:
                    System.out.println(agregarItem(new Madera()));
                    break;
                case 5:
                    System.out.println(agregarItem(new Huevo()));
                    break;
                case 6:
                    System.out.println(agregarItem(new PerlaDeEnder()));
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

    public void eliminar(){
        int opcion;

        do {
            opcion=listaItems();
            switch (opcion){
                case 1:
                    System.out.println(eliminarItem(new Pico()));
                    break;
                case 2:
                    System.out.println(eliminarItem(new Espada()));
                    break;
                case 3:
                    System.out.println(eliminarItem(new Piedra()));
                    break;
                case 4:
                    System.out.println(eliminarItem(new Madera()));
                    break;
                case 5:
                    System.out.println(eliminarItem(new Huevo()));
                    break;
                case 6:
                    System.out.println(eliminarItem(new PerlaDeEnder()));
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

    public String eliminarItem(Item e){
        for (Casilla casilla : inventario) {

            if(casilla.size()>0 && casilla.peek().getClass().isInstance(e)){
                if (casilla.remove(casilla.peek())){
                    return "Eliminado correctamente.";
                }
            }
        }
        return "No fue posible eliminarlo.";
    }

    public String agregarItem(Item e){
        for (Casilla casilla : inventario) {
            if (casilla.isEmpty() || casilla.peek().getClass().isInstance(e)) {
                if (casilla.add(e)){
                    return "Añadido correctamente.";
                }
            }
        }
        return "No fue posible añadirlo.";
    }

    public int menuPrincipal(){
        int opcion;
        System.out.println("************");
        System.out.println("*INVENTARIO*");
        System.out.println("************");
        System.out.println("1. Añadir al inventario.");
        System.out.println("2. Eliminar del inventario.");
        System.out.println("3. Mostrar inventario.");
        System.out.println("**************************");
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
        System.out.println("********************");
        System.out.println("0. Volver al menu principal.");

        opcion= lib.validarOpcion(0,6);

        return opcion;

    }

}

