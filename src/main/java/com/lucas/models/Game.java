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
        print("---Seleccione al jugador 1---\nNombre: ");
        jugadores.add(new Jugador('X', scan.nextLine()));

        print("---Seleccione al jugador 2---\nNombre: ");
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
                    println("Casilla no disponible, vuelva a elejir una...\nValores disponibles:[1-9].");

            }while(!posValida);
            tablero.marcarCasilla(jugadores.get(turno).getSimbol(), tablero.getPosicion(posicion));
            cont++;

            if(cont>=5){
                if(tablero.enRaya(jugadores.get(0).getSimbol())){
                    println("Ganador de la ronda, "+jugadores.get(0).getName());
                    reiniciar();   
                }
                if(tablero.enRaya(jugadores.get(1).getSimbol())){
                    println("Ganador de la ronda, "+jugadores.get(1).getName());
                    reiniciar();
                }
                
            }
        }
    }

    @Override
    public void reiniciar(){
        for(int j=0; j<jugadores.size(); j++){
            println("---Seleccione al jugador "+(j+1)+"---\nNombre: ");
            String nombre = scan.next();
            jugadores.get(j).setPuntos(0).setName(nombre);
        }
        tablero.setTablero();
    }

    @Override
    public void nextRound() {
        System.out.println("NextRound");
    }

    @Override
    public void finalizar() {
        System.out.println("Finalizado!");
    }

    @Override
    public void getGanador() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGanador'");
    }

    private void print(Object line){
        System.out.print(line);
    }
    private void println(Object line){
        System.out.println(line);
    }

}
