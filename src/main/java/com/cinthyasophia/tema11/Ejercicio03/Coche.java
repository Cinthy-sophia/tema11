package com.cinthyasophia.tema11.Ejercicio03;

public class Coche {
    private String matricula;
    private int velocidad;
    private char marcha;

    public Coche(String matricula) {
        this.matricula = matricula;
        velocidad=0;
        marcha='0';
    }

    public String getMatricula() {
        return matricula;
    }


    public int getVelocidad() {
        return velocidad;
    }

    public int getMarcha() {
        return marcha;
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
        if (x>=0){
            this.velocidad+= x;
        }else{
            System.out.println("La velocidad no puede ser negativa.");
        }
    }
    public void frenar(int x){
        if (x>=0){
            this.velocidad-= x;

        }else{
            System.out.println("La velocidad no puede ser negativa.");
        }

    }
    protected void cambiarMarcha(char m){
        if (m>='1'){
            this.marcha= m;

        }else if(m=='0'){
            this.marcha= 'N';
        }else{
            System.out.println("La marcha no puede ser negativa.");
        }

    }
}

