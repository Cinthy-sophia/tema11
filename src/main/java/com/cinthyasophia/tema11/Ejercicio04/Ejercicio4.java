package com.cinthyasophia.tema11.Ejercicio04;

import java.util.ArrayList;
import com.cinthyasophia.tema10.Util.Lib;
public class Ejercicio4 {
    Lib lib = new Lib();
    public Ejercicio4(){
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            electrodomesticos.add(new Lavadora());
            electrodomesticos.add(new Television());


        }

    }
}
