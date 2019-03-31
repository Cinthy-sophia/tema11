package com.cinthyasophia.tema11.Ejercicio05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {
    public Scanner lector = new Scanner(System.in);

    public Ejercicio5(){
        int opcion;
        do {
            opcion= menuPrincipal();
            switch (opcion){
                case 1:
                    //todo añadirItem
                    break;

                case 2:
                    //todo eliminarItem
                    break;

                case 3:
                    //todo mostrarInventario
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
    public int menuPrincipal(){
        int opcion = 0;
        boolean isNumber;

        System.out.println("************");
        System.out.println("*INVENTARIO*");
        System.out.println("************");
        System.out.println("1. Añadir al inventario.");
        System.out.println("2. Eliminar del inventario.");
        System.out.println("3. Mostrar inventario.");
        System.out.println("0. Salir.");

        do {
            try {
                opcion = lector.nextInt();
                isNumber = true;
            } catch (InputMismatchException ime) {
                System.out.println("Debes introducir numeros, no letras.");
                isNumber = false;
            } finally {
                lector.nextLine();
            }
            if (opcion < 0 || opcion > 3) {
                System.out.println("Opcion incorrecta.");
            }

        } while (!isNumber || opcion < 0 || opcion > 3);

        return opcion;

    }

}
