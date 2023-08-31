package com.lucas.models;

public class Jugador {
    private char simbol;
    private String name;
    private int puntos;
    
    public Jugador(char _simbol, String _name){
        name = _name;
        simbol = _simbol;
        puntos = 0;
    }

    public char getSimbol() {
        return simbol;
    }

    public void setSimbol(char simbol) {
        this.simbol = simbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
