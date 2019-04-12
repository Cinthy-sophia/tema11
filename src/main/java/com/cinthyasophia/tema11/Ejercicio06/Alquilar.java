package com.cinthyasophia.tema11.Ejercicio06;

import java.util.GregorianCalendar;

public interface Alquilar {
    void setFechaAlquiler(String fecha);
    GregorianCalendar getFechaAlquiler();
    void setFechaDevolucion(String fecha);
    GregorianCalendar getFechaDevolucion();
    boolean isAlquilado();
    void setPrecio(int precio);
    int getPrecio();
}
