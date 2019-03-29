package com.cinthyasophia.tema11.Ejercicio04;

public class Television extends Electrodomestico {
    private static final double RESO_DEFAULT=20;

    protected boolean SmartTv;
    protected double resolucion;

    public Television(){
        super();
        this.resolucion= RESO_DEFAULT;
        this.SmartTv= false;
    }

    public Television(double precio, double peso){
        super(precio,peso);
        this.resolucion= RESO_DEFAULT;
        this.SmartTv=false;
    }

    public Television(String color, char consumoEnergetico, double peso, double precio, double resolucion, boolean isSmartTv){
        super(color,consumoEnergetico,peso,precio);
        this.resolucion=resolucion;
        this.SmartTv= isSmartTv;
    }

    public boolean isSmartTv() {
        return SmartTv;
    }

    public double getResolucion() {
        return resolucion;
    }

    @Override
    public double precioFinal() {
        this.precio= super.precioFinal();
        if (getResolucion()>40){
            this.precio+=(precio*0.30);
        }
        if (isSmartTv()){
            this.precio+=50;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "\nTelevision:" +
                "\nSmartTv: " + SmartTv +
                ".\nResolucion: " + resolucion +
                "\".\nColor: " + color +
                ".\nConsumo energetico: " + consumoEnergetico +
                ".\nPeso: " + peso +
                "kg.\nPrecio: " + precio +
                "€.";
    }
}
