package com.cinthyasophia.tema11.Ejercicio02;

import com.cinthyasophia.tema11.Ejercicio01.Punto;

import java.util.ArrayList;
import java.util.Arrays;

public class Poligono {
    private ArrayList<Punto> puntos;

    public ArrayList<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(Punto... puntos) {
        this.puntos.addAll(Arrays.asList(puntos));
    }

    public Poligono(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }

    public void traslada(double x, double y) {
        for (Punto p:puntos) {
            puntos.set(puntos.indexOf(p),new Punto(p.getX()+x,p.getY()+y));

        }

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
        String m;
        for (Punto p: puntos) {
            s.append('\n').append(p.toString());
        }
        m= s.toString();
        return "Puntos:"+ m;
    }
}
