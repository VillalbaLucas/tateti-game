package com.lucas.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lucas.models.interfaces.GameInterfaz;

public class Game implements GameInterfaz {
    private List<Jugador> jugadores = new ArrayList<>(2);
    private Tablero tablero;
    private Scanner scan = new Scanner(System.in);

    private void seleccionarJugador(){
        println("---Seleccione al jugador 1---");
        print("Nombre: ");
        jugadores.add(new Jugador('X', scan.nextLine()));

        println("---Seleccione al jugador 2---");
        print("Nombre: ");
        jugadores.add(new Jugador('O', scan.nextLine()));
    }

    public Game(){
        seleccionarJugador();
        tablero = new Tablero();
    }

    public void iniciar(){
        println("Juego iniciado! ");
        boolean enPartida = true;
        int posicion,turno, cont=0;

        while(enPartida){ 
            boolean posValida = false;
            turno = cont%2;
            println("Turno del jugador " + jugadores.get(turno).getName() + ", Donde pondras tu ficha?");
            do{
                tablero.show();
                posicion = scan.nextInt();
                if(posicion>0 & posicion<10){
                    if(tablero.getSimbolIn(tablero.getPosicion(posicion)) != 'X' & tablero.getSimbolIn(tablero.getPosicion(posicion)) != 'O')
                        posValida = true;
                    else
                        println("Casilla Ocupada!, vuelva a elejir una...");
                }
                else
                    print("Casilla no disponible, vuelva a elejir una...");

            }while(!posValida);
            tablero.marcarCasilla(jugadores.get(turno).getSimbol(), tablero.getPosicion(posicion));
            cont++; 
        }
    }

    @Override
    public void reiniciar(){
        System.out.println("Reiniciar!");
    }

    @Override
    public void nextRound() {
        System.out.println("NextRound");
    }

    @Override
    public void finalizar() {
        System.out.println("Finalizado!");
    }

    private void print(Object line){
        System.out.print(line);
    }
    private void println(Object line){
        System.out.println(line);
    }

}
