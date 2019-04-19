package com.cinthyasophia.tema11.Ejercicio07;

public class Zona {
    public enum TipoZona{A,B,C,D,E,VIP}

    protected final int CANTIDAD_ASIENTOS= 100;
    protected final int CANTIDAD_FILAS= 5;

    protected String tipo;
    protected Asiento[][] asientos;
    protected int cantidadAsientos;

    public Zona(String tipo){
        this.tipo=tipo;
        cantidadAsientos= CANTIDAD_ASIENTOS;
        asientos= new Asiento[CANTIDAD_FILAS][CANTIDAD_ASIENTOS/CANTIDAD_FILAS];

        for (int i=0; i< asientos.length; i++) {//filas
            for (int j=0;j < asientos[i].length; j++) {//columnas
                for (int x = 1; x <= cantidadAsientos; x++) {
                   asientos[i][j] = new Asiento(x,tipo,++i);
                }
            }
        }

    }

    public String getTipo() {
        return tipo;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }
    public void mostrarAsientos(){
        for (Asiento[] asiento : asientos) {//filas
            for (Asiento value : asiento) {//columnas
                System.out.print(value.toString() + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Tipo:" + tipo+ "Cantidad de asientos: "+ cantidadAsientos;

    }

}
