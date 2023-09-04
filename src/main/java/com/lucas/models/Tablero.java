package com.lucas.models;

import java.util.HashMap;
import java.util.Map;
import static java.lang.System.out;

public class Tablero {
    private char[][] tablero = new char[3][3];
    private Map<Integer, int[]> posicion = new HashMap<>();

    public Tablero(){
        cargarPosiciones();
    }

    /**
     * Hace las conversiones de la posicion de la matriz a una posicion de solo numeros ej: la posicion 0,0 es el 1 y 2,1 es la 8
     */
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

    public void show(){
        for(char[] i: tablero){
            for (char j : i){
                if(j != 'X' & j != 'O')
                    out.print('^' + "  ");
                else
                    out.print(j + "  ");
            }
            out.println("\n");
        }
    }
    public char getSimbolIn(int[] pos){
        return tablero[pos[0]][pos[1]];
    }
}
