package com.cinthyasophia.tema11.Ejercicio02;

import com.cinthyasophia.tema11.Ejercicio01.Punto;

import java.util.ArrayList;

public class Poligono {
    ArrayList<Punto> puntos;

    public ArrayList<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }

    public Poligono(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }

    public void traslada(double x, double y) {


    }

    public int numVertices() {
        return puntos.size();
    }

    public double perimetro() {
        double pe=0;
        int cont=0;
        double l;
        double lAux;
        for (Punto p:puntos) {
            cont++;
            if(cont<puntos.size()){
                lAux=p.distancia(puntos.get(cont));
                pe+=lAux;

            }

        }
        l= puntos.get(0).distancia(puntos.get(puntos.size()-1));
        return pe+l;

    }

    @Override
    public String toString() {
        StringBuilder s= new StringBuilder();
        String m= new String();
        for (Punto p: puntos) {
            s.append('\n').append(p.toString());
        }
        m= s.toString();
        return "Puntos:"+ m;
    }
}
