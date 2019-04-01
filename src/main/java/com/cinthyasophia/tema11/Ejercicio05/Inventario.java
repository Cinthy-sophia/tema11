package com.cinthyasophia.tema11.Ejercicio05;

import com.cinthyasophia.tema11.Util.Lib;
import java.util.Scanner;

public class Inventario {
    public Scanner lector = new Scanner(System.in);
    private Lib lib = new Lib();
    private final int INVENTARIO_SIZE=7;
    private Casilla[] inventario;

    public Inventario(){
        inventario= new Casilla[INVENTARIO_SIZE];
        for (int i = 0; i < inventario.length; i++) {
            inventario[i]= new Casilla();
        }
    }
    public void menuInventario(){
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
    public void agregar(){
        int opcion;
        do {
            opcion=listaItems();
            switch (opcion){
                case 1:
                    for (Casilla casilla : inventario) {
                        if (casilla.isEmpty()) {
                            System.out.println(agregarItem(casilla, new Pico()));
                        }
                    }
                    break;
                case 2:
                    for (Casilla casilla : inventario) {
                        if (casilla.isEmpty()) {
                            System.out.println(agregarItem(casilla, new Espada()));
                        }
                    }
                    break;
                case 3:
                    for (Casilla casilla : inventario) {
                        if (casilla.peek() instanceof Piedra) {
                            System.out.println(agregarItem(casilla, new Piedra()));
                        } else if (casilla.isEmpty()) {
                            System.out.println(agregarItem(casilla, new Piedra()));
                        }
                    }
                    break;
                case 4:
                    for (Casilla casilla2 : inventario) {
                        if (casilla2.peek() instanceof Madera) {
                            System.out.println(agregarItem(casilla2, new Madera()));
                        } else if (casilla2.isEmpty()) {
                            System.out.println(agregarItem(casilla2, new Madera()));
                        }
                    }
                    break;
                case 5:
                    for (Casilla casilla1 : inventario) {
                        if (casilla1.peek() instanceof Huevo) {
                            System.out.println(agregarItem(casilla1, new Huevo()));
                        } else if (casilla1.isEmpty()) {
                            System.out.println(agregarItem(casilla1, new Huevo()));
                        }
                    }
                    break;
                case 6:
                    for (Casilla casilla : inventario) {
                        if (casilla.peek() instanceof PerlaDeEnder) {
                            System.out.println(agregarItem(casilla, new PerlaDeEnder()));
                        } else if (casilla.isEmpty()) {
                            System.out.println(agregarItem(casilla, new PerlaDeEnder()));
                        }
                    }
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
                    eliminarItem(new Pico());
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

    public String agregarItem(Casilla c,Item e){
        if (c.add(e)){
            return "Añadido correctamente";
        }else {
            return "No fue posible añadirlo";
        }
    }

    public Item eliminarItem(Item e){
        Casilla c = new Casilla();
        for (Casilla casilla : inventario) {
            if (casilla.peek() instanceof Item) {
                c=casilla;
            }
        }
        return  c.remove();

    }

}

