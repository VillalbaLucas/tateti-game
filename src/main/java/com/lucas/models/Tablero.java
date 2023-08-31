package com.lucas.models;

public class Tablero {
    private final char [][] tablero = new char[3][3];

    public Tablero(){}

    public void marcarPosicion(char c, int[] pos){
        tablero[pos[0]][pos[1]] = c;
    }

    public char getPosicion(int[] pos){
        return tablero[pos[0]][pos[1]];
    }

    

}
