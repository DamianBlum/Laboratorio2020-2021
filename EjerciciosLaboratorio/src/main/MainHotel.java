package main;

import seresVivos.Huesped;
import sistemas.administracion.Habitacion;
import sistemas.administracion.Hospedaje;

import java.util.Date;
import java.util.ArrayList;

public class MainHotel {

    ArrayList<Huesped> top6Huepedes (ArrayList<Huesped> listaHuespedes){

        ArrayList<Huesped> top6Huespedes = new ArrayList<>();
        Huesped huespedAux = new Huesped("Jorgito", "Perez", 21, 12345678);

        for (int i = 0 ; i < 6 ; i++){
            top6Huespedes.add(huespedAux);
        }
        // esto que esta arriba esta hecho para que primero compare con personas con 0 y nos permitan luego seguir comparando bien

        for (Huesped huespedLista:listaHuespedes){
            /* en este caso no puedo utilizar el foreach ya que necesito esa variable auxiliar en otra función,
            que seria desplazarListaPersonas, y sin esta variable no funciona
            */
            for (int j = 0 ; j < top6Huespedes.size() ; j++) {
                if (huespedLista.getCantVisitas() > (top6Huespedes.get(j)).getCantVisitas()){
                    top6Huespedes=desplazarListaPersonas(huespedLista,top6Huespedes,j);
                    j=top6Huespedes.size();
                }
            }
        }
        return top6Huespedes;
        //cuando encuentra una persona con mas visitas llama a la funcio desplazarListaPersonas que mueve todas las personas hacia la dereha, eliminando el ultimo
    }

    int cantDePersonasConEstadiaProlongada(ArrayList<Huesped> listaHuespedes,  ArrayList<Hospedaje> listaHospedajes){
        // hubo que crear yaEsta para que no se repitan personas.
        ArrayList<Huesped> yaContados = new ArrayList<>();
        boolean yaEsta = false;

        for (Hospedaje hospedaje:listaHospedajes){
            if (hospedaje.getCantDias()>30){
                //este for no se puede cambiar porque no solo recorre si que tambien se fija si esta o no contado (el !yaEsta)
                for (int j = 0 ; j < yaContados.size() && !yaEsta ; j++){
                    if (hospedaje.getHuesped1() == yaContados.get(j)){
                        yaEsta = true;
                    }
                }
                if (!yaEsta){
                    yaContados.add(hospedaje.getHuesped1());
                }
                else {
                    yaEsta = false;
                }
                if ((hospedaje.getHuesped2()).getNombre() == "NULL"){
                    for (int j = 0 ; j < yaContados.size() && !yaEsta ; j++){
                        if (hospedaje.getHuesped2() == yaContados.get(j)){
                            yaEsta = true;
                        }
                    }
                    if (!yaEsta){
                        yaContados.add(hospedaje.getHuesped2());
                    }
                    else {
                        yaEsta = false;
                    }
                }
            }
        }
        return yaContados.size();
        /*
        Aplicar concepto de alta cohesión
         */
    }

    double dineroTotal ( ArrayList<Hospedaje> listaHospedajes){
        double dinerototal=0;
        for(Hospedaje hospedaje:listaHospedajes){
            dinerototal = dinerototal + hospedaje.getCosto();
        }
        return dinerototal;
    }

    ArrayList<Habitacion> top3Habitaciones (ArrayList<Habitacion> listaHabitaciones) {
        // Misma idea que top6Huespedes
        ArrayList<Habitacion> top3Habitaciones = new ArrayList<>();
        for (int i=0; i<3;i++) {
            Habitacion habitacionaux= new Habitacion(i);
            top3Habitaciones.add(habitacionaux);
        }

        for (Habitacion habitacionLista:listaHabitaciones){
            /* en este caso no puedo utilizar el foreach ya que necesito esa variable auxiliar en otra función,
            que seria desplazarListaHabitaciones, y sin esta variable no funciona
            */
            for (int j = 0 ; j < top3Habitaciones.size() ; j++) {
                if (habitacionLista.getCantUsos() > (top3Habitaciones.get(j)).getCantUsos()){
                    top3Habitaciones=desplazarListaHabitaciones(habitacionLista,top3Habitaciones,j);
                    j=top3Habitaciones.size();
                }
            }
        }
        return top3Habitaciones;
        /*
        aplicar concepto de alta cohesión"
         */
    }

    ArrayList<Integer> listaHabitacionesDisponibles( ArrayList<Habitacion> listaHabitacioes){
        ArrayList<Integer> nroHabitacionesDisp = new ArrayList<>();
        for (Habitacion habitacion:listaHabitacioes){
            if (habitacion.isLibre()){
                nroHabitacionesDisp.add(habitacion.getNumeroHabitacion());
            }
        }
        return nroHabitacionesDisp;

    }

    ArrayList<Integer> listaHabitacionesOcupadas(ArrayList<Habitacion> listaHabitacioes){
        ArrayList<Integer> nroHabitacionesOcupadas = new ArrayList<>();
        for (int i=0; i<listaHabitacioes.size();i++){
            if (listaHabitacioes.get(i).isLibre()){
                nroHabitacionesOcupadas.add(i);
            }
        }
        return nroHabitacionesOcupadas;

    }

    ArrayList<Integer> tiempoHuesped ( ArrayList<Hospedaje> listaHospedajes){
        ArrayList<Integer>tiempoHuesped = new ArrayList<>();
        for(Hospedaje hospedaje:listaHospedajes){
            Integer cantidadDias = hospedaje.getCantDias();
            tiempoHuesped.add(cantidadDias);
        }
        return tiempoHuesped;
    }

    ArrayList<Huesped> huespedesEnDeterminadaHabitacion ( ArrayList<Hospedaje> listaHospedajes, int numeroHabitacion) {
        Date fechaActual= new Date();
        ArrayList<Huesped> huespedesEnDeterminadaHabitacion = new ArrayList<>();
        //No puedo usar foreach ya que lo recorro de derecha a izquierda
        for(int i=listaHospedajes.size()-1;i>0;i--){
            if (((listaHospedajes.get(i)).getHabitacion()).getNumeroHabitacion() == numeroHabitacion){
                huespedesEnDeterminadaHabitacion.add((listaHospedajes.get(i)).getHuesped1());
                if(!((listaHospedajes.get(i)).getHuesped2()).getNombre().equals("NULL")){
                    huespedesEnDeterminadaHabitacion.add((listaHospedajes.get(i)).getHuesped2());
                }
            }
            return huespedesEnDeterminadaHabitacion;
        }
        return huespedesEnDeterminadaHabitacion;
        /*
        Aplicar concepto de alta cohesión
         */
    }

    ArrayList<ArrayList<Date>> fechaEntradaSalida( ArrayList<Hospedaje> listaHospedajes){

        ArrayList<ArrayList<Date>> fechasEntradaYSalida = new ArrayList<>();

        for(Hospedaje hospedaje:listaHospedajes){
            ArrayList<Date> arrayAux = new ArrayList<>();
            arrayAux.add(hospedaje.getFechaEntrada());
            arrayAux.add(hospedaje.getFechaSalida());
            fechasEntradaYSalida.add(arrayAux);
        }

        return fechasEntradaYSalida;
    }

    ArrayList<Double> importeAPagar ( ArrayList<Hospedaje> listaHospedajes) {
        ArrayList<Double>importeAPagar = new ArrayList<>();
        for(Hospedaje hospedaje:listaHospedajes){
            Double importe = hospedaje.getCosto();
            importeAPagar.add(importe);
        }
        return importeAPagar;
    }

    ArrayList<Hospedaje> agregaMasDiasdeEstadia( ArrayList<Hospedaje> listaHospedajes, Date fecha_nueva, int cantDias, int numerodeHabitacion){
        // no puedo usar foreach porque lo quiero recorre de derecha a izquierda
        for(int i=listaHospedajes.size()-1; i>0; i--){
            if((listaHospedajes.get(i).getHabitacion()).getNumeroHabitacion()==numerodeHabitacion){
                (listaHospedajes.get(i)).setCantDias((listaHospedajes.get(i)).getCantDias()+cantDias);
                (listaHospedajes.get(i)).setFechaSalida(fecha_nueva);
                return listaHospedajes;
            }
        }
        return listaHospedajes;
    }

    ////////////////////////////////////////Funciones Auxilares///////////////////////////////////////////////////////////////////
    ArrayList<Huesped> desplazarListaPersonas(Huesped HuespedQueEntraEnLaLista, ArrayList<Huesped> top6Huespedes, int lugarDondeEmpiezaElDesplazamiento){
        //No puedo usar foreach porque arranca ya en 5 y va de derecha a izquierda
        for (int i=5;i>lugarDondeEmpiezaElDesplazamiento;i--) {
            top6Huespedes.set(i,top6Huespedes.get(i-1));
        }
        top6Huespedes.set(lugarDondeEmpiezaElDesplazamiento,HuespedQueEntraEnLaLista);
        return top6Huespedes;
    }
    ArrayList<Habitacion> desplazarListaHabitaciones(Habitacion HabitacionQueEntraEnLaLista, ArrayList<Habitacion> top3Habitaciones, int lugarDondeEmpiezaElDesplazamiento){
        //No puedo usar foreach porque ya arranca en 3 y va de derecha a izquierda
        for (int i=3;i>lugarDondeEmpiezaElDesplazamiento;i--) {
            top3Habitaciones.set(i,top3Habitaciones.get(i-1));
        }
        top3Habitaciones.set(lugarDondeEmpiezaElDesplazamiento,HabitacionQueEntraEnLaLista);
        return top3Habitaciones;
    }


    public static void main(String[] args) {

        ArrayList<Habitacion> listaHabitaciones = new ArrayList<>();

        for (int i = 1 ; i < 14 ; i++){
            Habitacion habitacionaAux = new Habitacion(i);
            listaHabitaciones.add(habitacionaAux);
        }

        ArrayList<Huesped> listaHuespedes = new ArrayList<>();
        ArrayList<Hospedaje> listaHospedajes = new ArrayList<>();
    }

    /*
     es mejor que "lista de habitaciones" sea un atributo
     de una clase llamada "Hotel"
     */

    /*
    Muy bien!
     */
}
