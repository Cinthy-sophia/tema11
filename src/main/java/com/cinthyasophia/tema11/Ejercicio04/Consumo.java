package com.cinthyasophia.tema11.Ejercicio04;

public enum Consumo {
    A('A'),B('B'),C('C'),D('D'),E('E'),F('F');
    private char letra;

    Consumo(char letra){
        this.letra=letra;
    }

    public char getLetra() {
        return letra;
    }
}
