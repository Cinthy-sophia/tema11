package com.cinthyasophia.tema11;

//import com.cinthyasophia.tema11.Ejercicio01.Ejercicio1;
//import com.cinthyasophia.tema11.Ejercicio02.Ejercicio2;
//import com.cinthyasophia.tema11.Ejercicio03.Ejercicio3;
//import com.cinthyasophia.tema11.Ejercicio04.Ejercicio4;
//import com.cinthyasophia.tema11.Ejercicio05.Ejercicio5;
//import com.cinthyasophia.tema11.Ejercicio06.Ejercicio6;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main {
    public static void main (String[] args){
        //Ejercicio1 ejercicio1 = new Ejercicio1();
        //Ejercicio2 ejercicio2 = new Ejercicio2();
        //Ejercicio3 ejercicio3 = new Ejercicio3();
        //Ejercicio4 ejercicio4 = new Ejercicio4();
        //Ejercicio5 ejercicio5 = new Ejercicio5();
        //Ejercicio6 ejercicio6 = new Ejercicio6();
        ArrayList<Integer> h= new ArrayList<>();
        ArrayList<Integer> d= new ArrayList<>();

        h.add(2);
        h.add(3);
        h.add(4);

        for (Integer i:h) {
            if (i==2){
                d.add(i);
            }
        }
        System.out.println(h.toString());
        System.out.println(d.toString());
        System.out.println(h.toString());

    }
}


