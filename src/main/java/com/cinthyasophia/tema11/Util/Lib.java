package com.cinthyasophia.tema11.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Lib {
    private Scanner lector = new Scanner(System.in);
    /**
     * Transforma en string el vector de enteros que reciba
     * @param vector
     * @return String
     */
    public String toString(int[] vector){
        String cadena= "";
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

    /**
     * Le resta el ultimo numero al vectori que recibe y lo mueve a otro array
     * @param vectorP
     * @param num
     * @return
     * Devuelve el array con el numero menos
     */
    public int[] numeroMenos(int[] vectorP, int num){
        int[] vector = new int[num];
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

    /**
     * Cambia la fecha de string a GregorianCalendar
     * @param f
     * @return
     * Devuelve la fecha en GregorianCalendar
     */
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
     *Valida la opcion del menu.
     * @param opcionMin
     * @param opcionMax
     * @return
     * Devuelve la opcion que el usuario haya elegido.
     */
    public int validarOpcion(int opcionMin, int opcionMax){
        int opcion=0;
        boolean isNumber;
        do {
            try {
                opcion = lector.nextInt();
                isNumber = true;
            } catch (InputMismatchException ime) {
                errorDatos();
                isNumber = false;
            } finally {
                lector.nextLine();
            }
            if (opcion < opcionMin || opcion > opcionMax) {
                System.out.println(errorMenu());
            }

        } while (!isNumber || opcion < opcionMin || opcion > opcionMax);

        return opcion;
    }

    /**
     *
     * @param fechaNac
     * @return
     */
    public int getEdad(GregorianCalendar fechaNac){
        int year= fechaNac.get(Calendar.YEAR);
        int month= fechaNac.get(Calendar.MONTH);
        int day= fechaNac.get(Calendar.DAY_OF_MONTH);

        LocalDate birth= LocalDate.of(year,month,day);
        LocalDate now = LocalDate.now();
        Period p;
        p= Period.between(birth, now);

        if (birth.isBefore(now)){
            return p.getYears()-1;
        }else{
            return p.getYears();
        }
    }


}
