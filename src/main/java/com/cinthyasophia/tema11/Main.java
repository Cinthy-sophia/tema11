package com.cinthyasophia.tema11;

//import com.cinthyasophia.tema11.Ejercicio01.Ejercicio1;
//import com.cinthyasophia.tema11.Ejercicio02.Ejercicio2;
//import com.cinthyasophia.tema11.Ejercicio03.Ejercicio3;
//import com.cinthyasophia.tema11.Ejercicio04.Ejercicio4;

import com.cinthyasophia.tema11.Ejercicio05.Casilla;
import com.cinthyasophia.tema11.Ejercicio05.Huevo;
import com.cinthyasophia.tema11.Ejercicio05.Piedra;

public class Main {
    public static void main (String[] args){
        //Ejercicio1 ejercicio1 = new Ejercicio1();
        //Ejercicio2 ejercicio2 = new Ejercicio2();
        //Ejercicio3 ejercicio3 = new Ejercicio3();
        //Ejercicio4 ejercicio4 = new Ejercicio4();
        Casilla[] casillas= new Casilla[7];
        casillas[0]= new Casilla();
        casillas[1]= new Casilla();
        for (int i = 0; i < 69; i++) {
            System.out.println(i+": "+casillas[0].add(new Huevo()));
            System.out.println(i+": "+casillas[1].add(new Piedra()));
        }
    }
}
