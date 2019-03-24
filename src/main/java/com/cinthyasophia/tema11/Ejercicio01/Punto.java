package com.cinthyasophia.tema11.Ejercicio01;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Punto() {
        x = 0;
        y = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distancia(Punto p){
        double d;
        double x= (p.getX()-this.x)*(p.getX()-this.x);
        double y= (p.getY()-this.y)*(p.getY()-this.y);
        d= Math.sqrt(x+y);
        return d;
    }

    @Override
    public String toString() {
        return "(" + x +
                ", " + y + ")";
    }
}
