package com.cinthyasophia.tema11.Ejercicio03;

public class CocheCambioAutomatico extends Coche{

    public CocheCambioAutomatico(String matricula) {
        super(matricula);
    }

    protected void cambiarMarcha() {
        if (velocidad == 0) {
            cambiarMarcha('P');

        } else if (getVelocidad() > 10) {
            cambiarMarcha('D');

        } else if(getVelocidad() == 10 ){
            cambiarMarcha('N');
        }

    }
}
