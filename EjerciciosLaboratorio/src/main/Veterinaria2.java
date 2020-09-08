package main;



import seresVivos.Mascotas.Mascotas;
import seresVivos.Mascotas.Perro;

import java.util.HashSet;

public class Veterinaria2 {
    private HashSet<Mascotas> mascotasDeVeterinarios;


    public HashSet<Mascotas> getMascotasDeVeterinarios() {
        return mascotasDeVeterinarios;
    }

    public void setMascotasDeVeterinarios(HashSet<Mascotas> mascotasDeVeterinarios) {
        this.mascotasDeVeterinarios = mascotasDeVeterinarios;
    }

    public void tipoDeMascotaConMejorAsistencia(){
        int contadorPerros=0;
        int contadorGato=0;
        int contadorTortuga=0;
        for (Mascotas mascotaAux:mascotasDeVeterinarios) {
            if(mascotaAux.cumplioConLasVisitasAnuales("2020")) {
                switch (mascotaAux.TipoDeMascota()) {
                    case "Perro":
                        contadorPerros++;
                        break;
                    case "Tortuga":
                        contadorTortuga++;
                        break;
                    case "Gato":
                        contadorGato++;
                        break;
                }
            }
        }
        if (contadorGato>contadorPerros && contadorGato>contadorTortuga){
            System.out.println("Mejor asistencia para: los gatos");
        }
        else if(contadorPerros>contadorGato && contadorPerros>contadorTortuga){
            System.out.println("Mejor asistencia para: los perros");
        }
        else if(contadorTortuga>contadorGato && contadorTortuga>contadorPerros){
            System.out.println("Mejor asistencia para: las tortugas");
        }
        else {
            System.out.println("Ha habido un empate entre alguna de los tipos de mascotas, no hay ganador");
        }
    }
    public HashSet<String> razasDePerrosIncumplidoras(){
        HashSet<String> lista_aux = new HashSet<>();
        for(Mascotas mascota_aux : mascotasDeVeterinarios){
            if(mascota_aux.TipoDeMascota().equals("perro") && !mascota_aux.cumplioConLasVisitasAnuales("2020")){
                Perro perro_aux = (Perro)mascota_aux;
                lista_aux.add(perro_aux.getRaza());
            }
        }
        return lista_aux;
    }


}
