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
    /**
     * Marca la casilla en el tablero con el caracter correspondiente al jugador.
     * @param c caracter de cada jugador.
     * @param pos posicion donde coloca su caracter en el tablero.
     */
    public void marcarCasilla(char c, int[] pos){
        tablero[pos[0]][pos[1]] = (char) c;
    }

    /**
     * Convierte la posicion tecleada por el jugador con valores del 1 al 9 y las convierte para poder acceder al tablero.
     */
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
    /**
     * Metodo para obtener el caracter en una posicion que le indicamos.
     * @param pos <b>int[]</b> donde int[0]: es la posicion de la fila y int[1]: posicion de la columna.
     * @return <b>char</b> caracter en esa posicion.
     */
    public char getSimbolIn(int[] pos){
        return tablero[pos[0]][pos[1]];
    }

    public void setTablero(){
        for (int i = 0; i < 9; i++){
            int col = i%3, row = i/3;
            tablero[row][col] = '0';
        }
    }
}
