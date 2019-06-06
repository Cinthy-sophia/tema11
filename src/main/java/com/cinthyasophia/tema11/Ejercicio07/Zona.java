package com.cinthyasophia.tema11.Ejercicio07;

public class Zona {
    public enum TipoZona{A,B,C,D,E,VIP}

    protected final int CANTIDAD_ASIENTOS= 100;
    protected final int CANTIDAD_FILAS= 5;
    protected final int CANTIDAD_COLUMNAS= CANTIDAD_ASIENTOS/CANTIDAD_FILAS;

    protected TipoZona tipo;
    protected Asiento[][] asientos;


    public Zona(String tipo){
        this.tipo=TipoZona.valueOf(tipo);
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

    public TipoZona getTipo() {
        return tipo;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public Asiento getAsiento(int numeroAsiento, int numeroFila){
        Asiento a = null;
        for (Asiento[] asiento : asientos) {//filas
            for (Asiento value : asiento) {//columnas
                if (value.getNumero()== numeroAsiento && value.getFila()== numeroFila){
                    a= value;
                }
            }
        }

        return a;
    }

    public void mostrarAsientos(){
        for (Asiento[] asiento : asientos) {//filas
            for (Asiento value : asiento) {//columnas
                System.out.println(value.toString());
            }
            System.out.print("\n");
        }
    }


    @Override
    public String toString() {
        return "\nTipo: " + tipo+"\t"+ "Cantidad de asientos total: "+ CANTIDAD_ASIENTOS;

    }

}
