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
            println("Turno del jugador " + jugadores.get(turno).getName() + ", Donde pondras tu ficha? \n");
            do{
                tablero.show();
                print("Posicion: ");
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
                for(int i = 0; i<2; i++ ){
                    if(tablero.enRaya(jugadores.get(i).getSimbol())){
                        jugadores.get(i).setPuntos(jugadores.get(i).getPuntos()+1);
                        println("Ganador de la ronda, "+jugadores.get(i).getName() + " / Puntos: " + jugadores.get(i).getPuntos());
                        nextRound(); 
                        break;
                    }
                    else if(tablero.lleno()){
                        println("Ronda empatada!... ");
                        nextRound();
                    }
                }
            }
        }
    }

    @Override
    public void reiniciar(){
        for(int i=0; i<jugadores.size(); i++){
            print("---Seleccione al jugador "+(i+1)+"---\nNombre: ");
            jugadores.get(i).setPuntos(0).setName(scan.next());
            println("");
        }
        tablero.setTablero();
    }

    @Override
    public void nextRound() {
        print("Jugar otra ronda? Y(si)/N(no): ");
        String opcion = scan.next();
        println("");

        switch (opcion.toUpperCase()){
            case "Y" :
                tablero.setTablero();
                println("---Siguiente Ronda--- \n");
                break;
            case "N" :
                getGanador();
                reiniciar();
                break;
        }
    }

    @Override
    public void finalizar() {
        println("Finalizado!");
    }

    @Override
    public void getGanador() {
        Jugador ganador = null;
        if(jugadores.get(0).getPuntos() == jugadores.get(1).getPuntos()){
            println("Ganador de las partidas... Empate!");
        }else{
            ganador = jugadores.get(0).getPuntos() > jugadores.get(1).getPuntos()? jugadores.get(0) : jugadores.get(0);  
            println("Ganador de las partidas... " + ganador.getName());
            println("Puntos totales: " + ganador.getPuntos());
        }
        
    }

    private void print(Object line){
        System.out.print(line);
    }
    private void println(Object line){
        System.out.println(line);
    }

}
