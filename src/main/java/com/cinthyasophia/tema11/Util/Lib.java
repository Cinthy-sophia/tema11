package com.cinthyasophia.tema11.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Lib {
    private Scanner lector = new Scanner(System.in);
    /**
     * Transforma en string el vector de enteros que reciba
     * @param vector
     * @return String
     */
    public String toString(int[] vector){
        String cadena= new String();
        for (int i = 0; i <vector.length ; i++) {
            cadena= cadena.concat(Integer.toString(vector[i]))+" ";
        }
        return cadena;
    }

    /**
     * Ordena el vector de enteros que reciba y lo devuelve ordenado
     * @param vector
     * @return vector
     */
    public int[] ordernarCombinacion(int[] vector) {
        boolean hayCambios = true;
        int aux;
        
        while(hayCambios) {
            hayCambios = false;
            for(int i = 0; i < vector.length - 1; i++) {
                if(vector[i] > vector[i+1]) {
                    aux = vector[i];
                    vector[i] = vector[i+1];
                    vector[i+1] = aux;
                    hayCambios = true;
                }
            }
        }
        return vector;
    }

    /**
     * Recibe el vector y un numero, y comprueba que no se encuentre en el
     * vector. Si lo encuentra devuelve true, si no, devuelve false.
     * @param vector
     * @param val
     * @return boolean
     */
    public boolean existeValor(int[] vector,int val){
        boolean existeValor= false;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i]== val){
                existeValor= true;
            }

        }
        return existeValor;
    }
    public boolean existeValor(double[] vector, double val){
        boolean existeValor= false;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i]== val){
                existeValor= true;
            }

        }
        return existeValor;
    }
    //Devuelve un String para indicar un error en el menu
    public String errorMenu(){
        return "Elija una opción del menú.";
    }

    public void errorDatos(){ System.out.println("Debes introducir un numero y no una letra.");}

    //Devuelve un String al volver al menu principal
    public String volverMenu(){
        return "Volviendo al menu principal.";

    }
    //Felicitacion al jugador
    public String felicitacion(){
        return "\u001B[1;0;0m¡ENHORABUENA!\u001B[0m";
    }

    public void pausa(){
        System.out.println("Presiona Intro para continuar.");
        lector.nextLine();
    }

    public int[] numeroMenos(int[] vectorP){
        int[] vector = new int[6];
        for (int i = 0; i < vector.length; i++) {

            vector[i]=vectorP[i];
        }
        return vector;
    }
    public int aleatorio(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min +1 ) + min;
    }
    public double aleatorio(double min, double max) {
        Random r = new Random();
        return r.nextDouble()*(max - min);
    }
    public GregorianCalendar getFecha(String f){

        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar fechaN= new GregorianCalendar();
        Date d= new Date();
        try{
            d= format.parse(f);
        }catch (ParseException pe){

        }
        fechaN.setTime(d);
        return fechaN;
    }

    /**
     *
     * @param opcionMin
     * @param opcionMax
     * @return
     */
    public int validarOpcion(int opcionMin, int opcionMax){
        int opcion=0;
        boolean isNumber;
        do {
            try {
                opcion = lector.nextInt();
                isNumber = true;
            } catch (InputMismatchException ime) {
                System.out.println("Debes introducir numeros, no letras.");
                isNumber = false;
            } finally {
                lector.nextLine();
            }
            if (opcion < opcionMin || opcion > opcionMax) {
                System.out.println("Opcion incorrecta.");
            }

        } while (!isNumber || opcion < opcionMin || opcion > opcionMax);

        return opcion;
    }


}
