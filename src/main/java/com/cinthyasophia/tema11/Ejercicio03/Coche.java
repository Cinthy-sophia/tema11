package com.cinthyasophia.tema11.Ejercicio03;

public class Coche {
    private String matricula;
    private int velocidad;
    private int marcha;

    public Coche(String matricula) {
        this.matricula = matricula;
        velocidad=0;
        marcha=0;
    }

    public String getMatricula() {
        return matricula;
    }


    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", velocidad=" + velocidad +
                ", marcha=" + marcha +
                '}';
    }

    public void acelerar(int x){
        this.velocidad+= x;
    }
    public void frenar(int x){
        this.velocidad-= x;
    }
    protected void cambiarMarcha(int m){
        this.marcha= m;

    }
}

