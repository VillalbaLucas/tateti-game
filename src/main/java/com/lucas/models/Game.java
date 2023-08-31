package com.lucas.models;

import java.util.Scanner;

import com.lucas.models.interfaces.GameInterfaz;

public class Game implements GameInterfaz {
    private Jugador jugador1, jugador2;
    private Tablero tablero;
    private Scanner scan = new Scanner(System.in);

    private void seleccionarJugador(){
        System.out.println("---Seleccione al jugador 1---");
        System.out.print("Nombre: ");
        jugador1 = new Jugador('X', scan.nextLine());

        System.out.println("---Seleccione al jugador 2---");
        System.out.print("Nombre: ");
        jugador1 = new Jugador('O', scan.nextLine());
    }

    public Game(Tablero tab){
        seleccionarJugador();
        tablero = tab;
    }

    public void iniciar(){
        System.out.println("Juego iniciado! ");
        boolean enPartida = true;

        while(enPartida){
            System.out.println("Turno del jugador " + jugador1.getName());
            
        }
    }

    public void reiniciar(){

    }

    @Override
    public void nextRound() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextRound'");
    }

    @Override
    public void finalizar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finalizar'");
    }


}
