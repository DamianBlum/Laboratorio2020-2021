package futbol;

import futbol.ClubDeFutbol;
import seresVivos.Jugador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Partido {

    private ClubDeFutbol equipoLocal;
    private ClubDeFutbol equipoVisitante;
    private String equipoGanador;
    private int golesEquipoLocal;
    private int golesEquipoVisiante;
    private String fechaYHora;

    public Partido(ClubDeFutbol equipoLocalEquis, ClubDeFutbol equipoVisitanteEquis,int golesEquipoLocalEquis, int golesEquipoVisianteEquis, String fechaYHoraEquis){
        equipoLocal=equipoLocalEquis;
        equipoVisitante=equipoVisitanteEquis;
        golesEquipoLocal=golesEquipoLocalEquis;
        golesEquipoVisiante=golesEquipoVisianteEquis;
        fechaYHora=fechaYHoraEquis;
        this.determinarPuntos(golesEquipoLocalEquis,golesEquipoVisianteEquis);
    }

    //         GETTERS

    public ClubDeFutbol getEquipoLocal() {
        return equipoLocal;
    }

    public ClubDeFutbol getEquipoVisitante() {
        return equipoVisitante;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public int getGolesEquipoVisiante() {
        return golesEquipoVisiante;
    }

    public String getEquipoGanador() {
        return equipoGanador;
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    //         SETTERS

    public void setEquipoGanador(String equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public void setEquipoLocal(ClubDeFutbol equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public void setEquipoVisitante(ClubDeFutbol equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public void setGolesEquipoVisiante(int golesEquipoVisiante) {
        this.golesEquipoVisiante = golesEquipoVisiante;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    // Funciones mas complejas

    public void determinarPuntos(int golesEquipoLocalEquis,int golesEquipoVisianteEquis) {
        if (golesEquipoLocalEquis>golesEquipoVisianteEquis) {
            equipoGanador=equipoLocal.getNombre();
            equipoVisitante.setPuntos(equipoLocal.getPuntos()+3);
            equipoLocal.setPartidosGanados(equipoLocal.getPartidosGanados()+1);
            equipoVisitante.setPartidosPerdidos(equipoVisitante.getPartidosPerdidos()+1);
        }
        else if (golesEquipoLocalEquis<golesEquipoVisianteEquis) {
            equipoGanador=equipoVisitante.getNombre();
            equipoVisitante.setPuntos(equipoVisitante.getPuntos()+3);
            equipoVisitante.setPartidosGanados(equipoVisitante.getPartidosGanados()+1);
        }
        else{
            equipoGanador="Empate";
            equipoVisitante.setPuntos(equipoLocal.getPuntos()+1);
            equipoVisitante.setPuntos(equipoVisitante.getPuntos()+1);
        }

    }
    public void informacionCadaEquipo() {
        System.out.println("Información de "+equipoLocal.getNombre());
        System.out.println("Jugó:");
        for (Jugador jugadorLocal:equipoLocal.getJugadores()) {
            System.out.println(jugadorLocal.getNombre()+" "+jugadorLocal.getApellido()+" de "+jugadorLocal.getEdad()+" años"+" con el dorsal "+jugadorLocal.getDorsal());
        }
        System.out.println("Información de "+equipoLocal.getNombre());
        System.out.println("Jugó:");
        for (Jugador jugadorVisitante:equipoVisitante.getJugadores()) {
            System.out.println(jugadorVisitante.getNombre()+" "+jugadorVisitante.getApellido()+" de "+jugadorVisitante.getEdad()+" años"+" con el dorsal "+jugadorVisitante.getDorsal());
        }
    }
    public void informacionPartido(){
        System.out.println("Fecha y Hora: "+this.fechaYHora);
        if(equipoGanador.equals(equipoLocal.getNombre())) {
            System.out.println("Gano el local "+equipoGanador+" por "+golesEquipoLocal+" a "+golesEquipoVisiante);
        }
        else {
            System.out.println("Gano el visitante "+equipoGanador+" por "+golesEquipoVisiante+" a "+golesEquipoLocal);
        }
    }

    /*
    Muy bien pero recordar que se debe aplicar el
    concepto de alta cohesión!
     */

}