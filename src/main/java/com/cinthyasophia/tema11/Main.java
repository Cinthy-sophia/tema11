package com.cinthyasophia.tema11;

//import com.cinthyasophia.tema11.Ejercicio01.Ejercicio1;
//import com.cinthyasophia.tema11.Ejercicio02.Ejercicio2;
//import com.cinthyasophia.tema11.Ejercicio03.Ejercicio3;
//import com.cinthyasophia.tema11.Ejercicio04.Ejercicio4;
//import com.cinthyasophia.tema11.Ejercicio05.Ejercicio5;
//import com.cinthyasophia.tema11.Ejercicio06.Ejercicio6;
import com.cinthyasophia.tema11.Ejercicio07.Ejercicio7;
import com.cinthyasophia.tema11.Ejercicio07.Partido;
import com.cinthyasophia.tema11.Util.Lib;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {
    public static void main (String[] args) {
        //Ejercicio1 ejercicio1 = new Ejercicio1();
        //Ejercicio2 ejercicio2 = new Ejercicio2();
        //Ejercicio3 ejercicio3 = new Ejercicio3();
        //Ejercicio4 ejercicio4 = new Ejercicio4();
        //Ejercicio5 ejercicio5 = new Ejercicio5();
        //Ejercicio6 ejercicio6 = new Ejercicio6();
        //Ejercicio7 ejercicio7 = new Ejercicio7();
        Faker faker = new Faker(new Locale("es"));
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        String tipo;
        GregorianCalendar fechaP;
        String fechaPartido;
        String equipoLocal;
        String equipoVisitante;
        int cantidadEntradas;
        Partido part;
        Lib lib = new Lib();

        tipo = Partido.TipoPartido.values()[lib.aleatorio(0, Partido.TipoPartido.values().length - 1)].name();
        fechaP = new GregorianCalendar(lib.aleatorio(2010, 2025), lib.aleatorio(1, 11), lib.aleatorio(1, 28));
        fechaPartido = format.format(fechaP.getTime());
        equipoLocal = faker.team().sport();
        equipoVisitante = faker.team().sport();
        cantidadEntradas = lib.aleatorio(150, 300);
        part = new Partido(tipo, fechaPartido, equipoLocal, equipoVisitante, lib.aleatorio(150, 300));

        part.setRecaudacion('+', lib.aleatorio(50.0, (double) cantidadEntradas));

        System.out.println(part.getRecaudacion());
        part.setRecaudacion('-',20);
        System.out.println(part.getRecaudacion());
        part.setRecaudacion('+',20);
        System.out.println(part.toString());
        System.out.println(part.getRecaudacion());


    }
}


