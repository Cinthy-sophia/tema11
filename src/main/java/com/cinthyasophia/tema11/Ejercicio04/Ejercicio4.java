package com.cinthyasophia.tema11.Ejercicio04;

import java.util.ArrayList;
import com.cinthyasophia.tema11.Util.Lib;
import com.github.javafaker.Faker;
import com.cinthyasophia.tema11.Ejercicio04.Electrodomestico.*;


public class Ejercicio4 {
    Lib lib = new Lib();
    Faker faker = new Faker();
    public Ejercicio4(){
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>(10);
        Consumo[] consumo = Consumo.values();
        Color[] color = Color.values();
        char consum;
        String col;
        double electrodomesticoTotal=0;
        double televisionTotal=0;
        double lavadoraTotal=0;

        for (int i = 0; i < 1; i++) {
            consum=consumo[lib.aleatorio(0,5)].toString().charAt(0);
            col=color[lib.aleatorio(0,4)].toString();
            electrodomesticos.add(new Lavadora(col,consum,lib.aleatorio(0,90),lib.aleatorio(10,50),lib.aleatorio(5,80)));

            consum=consumo[lib.aleatorio(0,5)].toString().charAt(0);
            col=color[lib.aleatorio(0,4)].toString();
            electrodomesticos.add(new Television(col,consum,lib.aleatorio(0,90),lib.aleatorio(10,50),lib.aleatorio(20,70),faker.bool().bool()));


        }

        for (Electrodomestico e:electrodomesticos) {
            if (e instanceof Lavadora){
                lavadoraTotal+=e.precioFinal();
            }
            if (e instanceof Television){
                televisionTotal+=e.precioFinal();
            }
            if (e instanceof Electrodomestico){
                electrodomesticoTotal+= e.precioFinal();

            }
        }

        System.out.println("Importe total lavadoras:"+lavadoraTotal);
        System.out.println("Importe total televisores:"+televisionTotal);
        System.out.println("Importe total electrodomesticos:"+electrodomesticoTotal);


    }
}
