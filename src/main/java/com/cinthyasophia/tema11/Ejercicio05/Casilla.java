package com.cinthyasophia.tema11.Ejercicio05;

import java.util.ArrayList;

public class Casilla implements ICola<Item> {
    protected ArrayList<Item> items;

    public Casilla(int cantidad){
        items= new ArrayList<>(cantidad);
    }

    @Override
    public boolean add(Item e) {
        if (items.size()==e.cantidadApilable){
            return false;
        }else{
            return items.add(e);
        }

    }

    @Override
    public Item remove() {
        return items.remove(0);
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public Item peek() {
        return items.get(0);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
