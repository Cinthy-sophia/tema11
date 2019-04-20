package com.cinthyasophia.tema11.Ejercicio07;

public class EntradaNormal extends Entrada {
    private int codPremio;

    public EntradaNormal(Partido partido, Asiento asiento) {
        super(partido, asiento);
    }

    public int getCodPremio() {
        return codPremio;
    }

    public void setCodPremio(int codPremio) {
        this.codPremio = codPremio;
    }

    @Override
    public String toString() {
        return "\n*ENTRADA NORMAL*\n"+ super.toString()+" Premio:" + codPremio;
    }
}
