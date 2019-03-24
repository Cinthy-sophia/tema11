package com.cinthyasophia.tema11.Ejercicio02;

import com.cinthyasophia.tema11.Ejercicio01.Punto;

import java.util.ArrayList;

public class Ejercicio2 {
    public Ejercicio2(){
        ArrayList<Punto> puntos= new ArrayList<>();
        puntos.add(new Punto(0,0));
        puntos.add(new Punto(2,0));
        puntos.add(new Punto(2,2));
        puntos.add(new Punto(0,2));

        Poligono poligono = new Poligono(puntos);

        System.out.println("Vertices: "+poligono.numVertices());
        System.out.println("Perimetro: "+poligono.perimetro());
        System.out.println(poligono.toString());


    }
}
