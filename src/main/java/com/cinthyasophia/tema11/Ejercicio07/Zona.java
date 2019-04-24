package com.cinthyasophia.tema11.Ejercicio07;

public class Zona {
    public enum TipoZona{A,B,C,D,E,VIP}

    protected final int CANTIDAD_ASIENTOS= 100;
    protected final int CANTIDAD_FILAS= 5;
    protected final int CANTIDAD_COLUMNAS= CANTIDAD_ASIENTOS/CANTIDAD_FILAS;

    protected String tipo;
    protected Asiento[][] asientos;
    protected int cantidadAsientosD;

    public Zona(String tipo){
        this.tipo=tipo;
        cantidadAsientosD= CANTIDAD_ASIENTOS;
        asientos= new Asiento[CANTIDAD_FILAS][CANTIDAD_COLUMNAS];
        int col;
        int fil;

        for (int i=0; i < asientos.length; i++) {//filas
            fil=i;
            ++fil;
            for (int j=0; j < asientos[i].length; j++) {//columnas
                col=j;
                asientos[i][j] = new Asiento(++col,this,fil);

            }
        }

    }

    public String getTipo() {
        return tipo;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public Asiento getAsiento(int numero){
        Asiento a = null;
        for (Asiento[] asiento : asientos) {//filas
            for (Asiento value : asiento) {//columnas
                if (value.getNumero()== numero){
                    a= value;
                }
            }
        }

        return a;
    }

    public void mostrarAsientos(){
        for (Asiento[] asiento : asientos) {//filas
            for (Asiento value : asiento) {//columnas
                System.out.print(value.toString() + "\t");
            }
            System.out.println();
        }
    }

    public void setCantidadAsientosD(int cantidadAsientosD) {
        this.cantidadAsientosD = cantidadAsientosD;

    }

    public int getCantidadAsientosD() {
        return cantidadAsientosD;
    }

    @Override
    public String toString() {
        for (Asiento[] asiento : asientos) {//filas
            for (Asiento value : asiento) {//columnas
                if (!value.isOcupado()){
                    cantidadAsientosD++;
                }
            }
        }

        return "\nTipo:" + tipo+"\t"+ "Cantidad de asientos diponibles: "+ cantidadAsientosD;

    }

}
