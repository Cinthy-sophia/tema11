package com.cinthyasophia.tema11.Ejercicio03;

import java.util.Scanner;

public class Ejercicio3 {
    public Scanner lector = new Scanner(System.in);

    public Ejercicio3(){
        String matricula;
        String tipoCoche;
        Coche coche;

        System.out.println("Indica la matricula del coche:");
        matricula=lector.nextLine();

        do {
            System.out.println("Indique A si el coche es automatico o M si es manual:");
            tipoCoche=lector.nextLine();
            if (!(tipoCoche.equals("A")) && !(tipoCoche.equals("M"))){
                System.out.println("Datos incorrectos. Solo debe utilizar A si el coche es automatico o M si es manual.");
            }
        }while(!(tipoCoche.equalsIgnoreCase("A")) && !(tipoCoche.equalsIgnoreCase("M")));

        switch (tipoCoche){
            case "A":
                coche= new CocheCambioAutomatico(matricula);
                coche.acelerar(60);
                ((CocheCambioAutomatico) coche).cambiarMarcha();
                break;

            case "M":
                coche= new CocheCambioManual(matricula);
                coche.acelerar(60);
                coche.cambiarMarcha('3');
            break;

            default:
                coche= new Coche(matricula);
            break;

        }

        System.out.println(coche.toString());

    }
}
