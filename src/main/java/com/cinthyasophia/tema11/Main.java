package com.cinthyasophia.tema11;

//import com.cinthyasophia.tema11.Ejercicio01.Ejercicio1;
//import com.cinthyasophia.tema11.Ejercicio02.Ejercicio2;
//import com.cinthyasophia.tema11.Ejercicio03.Ejercicio3;
//import com.cinthyasophia.tema11.Ejercicio04.Ejercicio4;
//import com.cinthyasophia.tema11.Ejercicio05.Ejercicio5;
//import com.cinthyasophia.tema11.Ejercicio06.Ejercicio6;


import com.cinthyasophia.tema11.Ejercicio07.Estadio;

public class Main {
    public static void main (String[] args){
        //Ejercicio1 ejercicio1 = new Ejercicio1();
        //Ejercicio2 ejercicio2 = new Ejercicio2();
        //Ejercicio3 ejercicio3 = new Ejercicio3();
        //Ejercicio4 ejercicio4 = new Ejercicio4();
        //Ejercicio5 ejercicio5 = new Ejercicio5();
        //Ejercicio6 ejercicio6 = new Ejercicio6();
        Estadio estadio= new Estadio();
        System.out.println(estadio.toString());
        estadio.getZonas().get(2).mostrarAsientos();
    }
}


