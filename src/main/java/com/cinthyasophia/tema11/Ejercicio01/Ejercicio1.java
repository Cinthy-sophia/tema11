package com.cinthyasophia.tema11.Ejercicio01;

public class Ejercicio1 {
    public Ejercicio1(){
        Punto p1 = new Punto(7,5);
        Punto p2 = new Punto(4,1);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p1.distancia(p2));

    }
}
