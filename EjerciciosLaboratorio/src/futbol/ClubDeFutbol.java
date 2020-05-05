package futbol;

import seresVivos.Jugador;

import java.util.HashSet;

public class ClubDeFutbol {
    private HashSet<Jugador> jugadores;
    private String nombre;
    private int partidosGanados=0;
    private int partidosPerdidos=0;
    private int partidosEmpatados=0;
    private HashSet<Partido> partidosJugados;
    private int Puntos=0;

    public ClubDeFutbol(HashSet<Jugador> jugadoresEquis, String nombreEquis) {
        jugadores=jugadoresEquis;
        nombre=nombreEquis;
        partidosJugados=new HashSet<>();
    }
    //         GETTERS

    public HashSet<Partido> getPartidosJugados() {
        return partidosJugados;
    }

    public String getNombre() {
        return nombre;
    }

    public HashSet<Jugador> getJugadores() {
        return jugadores;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public int getPuntos() {
        return Puntos;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    //         SETTERS

    public void setPartidosJugados(HashSet<Partido> partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setJugadores(HashSet<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public void setPuntos(int puntos) {
        Puntos = puntos;
    }

    public void añadirPartido(Partido partidoEquis) {
        this.partidosJugados.add(partidoEquis);
    }

    public boolean esIgualA(ClubDeFutbol clubDeFutbolEquis) {
        if(this.nombre.equals(clubDeFutbolEquis.nombre)) {
            return true;
        }
        return false;
    }
    public void InformacionPartidosGanados() {
        if (partidosGanados==0){
            System.out.println("Lo lamento, en este momento del torneo todavia no hay ganado ningun partido");
        }
        else {
            System.out.println("Partidos Ganados: "+partidosGanados);
            for (Partido partidoAux:partidosJugados) {
                if(this.getNombre().equals(partidoAux.getEquipoGanador())) {
                    System.out.println("Victoria el dia"+partidoAux.getFechaYHora());
                }
            }
        }

    }
    public void InformacionPartidosPerdidos() {
        if (partidosPerdidos==0){
            System.out.println("Lo lamento, en este momento del torneo todavia no hay perdido ningun partido");
        }
        System.out.println("Partidos Ganados: "+partidosGanados);
        for (Partido partidoAux:partidosJugados) {
            if(!this.getNombre().equals(partidoAux.getEquipoGanador())) {
                System.out.println("Perdida el dia"+partidoAux.getFechaYHora());
            }
        }
    }
    public void InformacionPartidosEmpatados() {
        if (partidosEmpatados==0){
            System.out.println("Lo lamento, en este momento del torneo todavia no hay empatado ningun partido");
        }
        System.out.println("Partidos Ganados: "+partidosGanados);
        for (Partido partidoAux:partidosJugados) {
            if(partidoAux.getEquipoGanador().equals("Empate")) {
                System.out.println("Empate el día"+partidoAux.getFechaYHora());
            }
        }
    }
}

