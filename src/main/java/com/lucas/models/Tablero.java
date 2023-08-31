package com.lucas.models;

import java.util.HashMap;
import java.util.Map;

public class Tablero {
    private final char[][] tablero = new char[3][3];
    private Map<Integer, int[]> posicion = new HashMap<>();

    public Tablero(){
        cargarPosiciones();
    }
    private void cargarPosiciones(){
        for (int i = 0; i < 9; i++){
            int col = i%3, row = i/3;
            posicion.put(i+1, new int[]{row, col});
        }
    }

    public void marcarCasilla(char c, int[] pos){
        tablero[pos[0]][pos[1]] = (char) c;
    }

    public  int[] getPosicion(int pos){
        return posicion.get(pos);
    }

    public void showTablero(){
        for(char[] i: tablero){
            for (char j : i) {
                if(j != ('X'|'O'))
                    System.out.print('^' + " ");
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public char getSimbolIn(int[] pos){
        return tablero[pos[0]][pos[1]];
    }

}
