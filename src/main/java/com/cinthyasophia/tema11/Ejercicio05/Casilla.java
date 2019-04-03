package com.cinthyasophia.tema11.Ejercicio05;

import java.util.ArrayList;

public class Casilla {
    private ArrayList<Item> items;

    public Casilla() {
        items = new ArrayList<>();
    }

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

    public boolean remove(Item e) {
        return items.remove(e);
    }

    public int size() {
        return items.size();
    }

    public Item peek() {
        return items.get(0);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        if (isEmpty()){
            return "VACIO"+'\t'+size();
        }else{
            return peek().getNOMBRE()+'\t'+size();
        }
    }
}
