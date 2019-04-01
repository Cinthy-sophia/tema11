package com.cinthyasophia.tema11.Ejercicio05;

import java.util.ArrayList;

public class Casilla implements ICola<Item> {
    private ArrayList<Item> items;

    public Casilla() {
        items = new ArrayList<>();
    }

    @Override
    public boolean add(Item e) {

        if (e.isApilable()){
            Apilable a= (Apilable) e;
            if (items.size()<a.getCantidadApilable()){
                return items.add(a);
            }else {
                return false;
            }
        }else {
            if (size()==0){
                return items.add(e);

            }else{
                return false;
            }
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
