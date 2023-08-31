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
        System.out.println("---Seleccione al jugador 1---");
        System.out.print("Nombre: ");
        jugadores.add(new Jugador('X', scan.nextLine()));

        System.out.println("---Seleccione al jugador 2---");
        System.out.print("Nombre: ");
        jugadores.add(new Jugador('O', scan.nextLine()));
    }

    public Game(){
        seleccionarJugador();
        tablero = new Tablero();
    }

    public void iniciar(){
        System.out.println("Juego iniciado! ");
        boolean enPartida = true;
        int posicion, turno=0;

        while(enPartida){
            turno /= 1; 
            System.out.println("Turno del jugador " + jugadores.get(turno).getName() + ", Donde pondras tu ficha?");
            do {
                tablero.show();
                posicion = scan.nextInt();
                System.out.println("pos");
                if(tablero.getSimbolIn(tablero.getPosicion(posicion)) == ('X' | 'O'))
                    System.out.println("Casilla no disponible, vuelva a elejir una...");
            } while(tablero.getSimbolIn(tablero.getPosicion(posicion)) != ('X' | 'O'));

            tablero.marcarCasilla(jugadores.get(turno).getSimbol(), tablero.getPosicion(posicion));
            turno++; 
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


}
