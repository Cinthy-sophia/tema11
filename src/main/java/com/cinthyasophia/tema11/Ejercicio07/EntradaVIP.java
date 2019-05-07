package com.cinthyasophia.tema11.Ejercicio07;

public class EntradaVIP extends Entrada {
    private String passwordVIP;

    public EntradaVIP(Partido partido, Asiento asiento) {
        super(partido, asiento);
    }
    public EntradaVIP(){
        super();
    }

    public String getPasswordVIP() {
        return passwordVIP;
    }

    public void setPasswordVIP(String passwordVIP) {
        this.passwordVIP = passwordVIP;
    }

    @Override
    public boolean isVIP() {
        return true;
    }

    @Override
    public String toString() {
        return "\n***************\n*ENTRADA VIP*\n***************\n"+super.toString()+ "\n\nPassword Taquilla: " + passwordVIP ;
    }
}
