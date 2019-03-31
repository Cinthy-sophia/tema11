package com.cinthyasophia.tema11.Ejercicio05;

public interface ICola<T> {
    boolean add(T e);
    T remove();
    int size();
    T peek();
    boolean isEmpty();

}
