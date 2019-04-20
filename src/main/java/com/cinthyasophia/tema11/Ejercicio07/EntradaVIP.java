package com.cinthyasophia.tema11.Ejercicio07;

public class EntradaVIP extends Entrada implements VIP {
    private boolean vip;
    private String passwordVIP;

    public EntradaVIP(Partido partido, Asiento asiento) {
        super(partido, asiento);
        vip=true;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getPasswordVIP() {
        return passwordVIP;
    }

    public void setPasswordVIP(String passwordVIP) {
        this.passwordVIP = passwordVIP;
    }

    @Override
    public boolean isVIP() {
        return vip;
    }

    @Override
    public String toString() {
        return "\n*ENTRADA VIP*"+super.toString()+ " Password Taquilla: " + passwordVIP ;
    }
}
