package main;
import futbol.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class MainTorneoFutbol {

    private HashSet<ClubDeFutbol> torneo;

    public HashSet<ClubDeFutbol> getTorneo() {
        return torneo;
    }

    public void setTorneo(HashSet<ClubDeFutbol> torneo) {
        torneo = torneo;
    }

    public void menuOpcionesEnGeneral(){
        System.out.println("Opciones en general del torneo");
        System.out.println("1:Buscar información de un club en específico");
        System.out.println("2:futbol.Partido en especifico");
        System.out.println("3:Registrar un partido nuevo");
        System.out.println("4:Salir del menu");
    }
    public void menuOpcionesDeCadaClub(String NombreDelClubDeFutbol){
        System.out.println("Bienvenido a la informacion de "+NombreDelClubDeFutbol);
        System.out.println("1:Partidos ganados");
        System.out.println("2:Partidos perdidos");
        System.out.println("3:Partidos empatados");
        System.out.println("4:Volver al menu pasado");
    }
    public int EleccionDeOpcionGeneral(){
        menuOpcionesEnGeneral();
        Scanner ingresoDeOpcion = new Scanner(System.in);
        int opcion=ingresoDeOpcion.nextInt();
        while (opcion<1 || opcion>4) {
            System.out.println("Opcion Incorrecta, vuelva a elegir");
            menuOpcionesEnGeneral();
            opcion=ingresoDeOpcion.nextInt();
        }
        return  opcion;
    }
    public int EleccionDeOpcionDeCadaClub(String NombreDelClubDeFutbol){
        menuOpcionesDeCadaClub(NombreDelClubDeFutbol);
        Scanner ingresoDeOpcion = new Scanner(System.in);
        int opcion=ingresoDeOpcion.nextInt();
        while (opcion<1 || opcion>4) {
            System.out.println("Opcion Incorrecta, vuelva a elegir");
            menuOpcionesDeCadaClub(NombreDelClubDeFutbol);
            opcion=ingresoDeOpcion.nextInt();
        }
        return  opcion;
    }
    public boolean EleccionGeneral(int opcionElegida, boolean SeguirEnElMenu) {
        switch (opcionElegida) {
            case 1: InformacionClub();
                break;
            case 2: InformacionPartidoEspecifico();
                break;
            case 3: RegistrarNuevoPartido();
                break;
            case 4: SeguirEnElMenu=false;
                break;
        }
        return SeguirEnElMenu;
    }
    public void InformacionClub() {
        Scanner ingresoNombreDelClub = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nombre del equipo que desea saber algo");
        String nombreDelClub=ingresoNombreDelClub.nextLine();
        ClubDeFutbol clubDeFutbolEquis=BuscarClubPorSuNombre(nombreDelClub);
        boolean seguirEnElMenu= true;
        while(seguirEnElMenu) {
            int opcionElegida=EleccionDeOpcionDeCadaClub(nombreDelClub);
            seguirEnElMenu=EleccionEspecifica(opcionElegida,true,clubDeFutbolEquis);
        }
    }
    public boolean EleccionEspecifica(int opcionElegida,boolean SeguirEnElMenu, ClubDeFutbol clubDeFutbolEquis) {
        switch (opcionElegida) {
            case 1: clubDeFutbolEquis.InformacionPartidosGanados();
                break;
            case 2: clubDeFutbolEquis.InformacionPartidosPerdidos();
                break;
            case 3: clubDeFutbolEquis.InformacionPartidosEmpatados();
                break;
            case 4: return false;
        }
        return true;
    }
    public void InformacionPartidoEspecifico() {
        Scanner ingresoNombreDelClubLocal = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nombre del equipo local");
        String nombreDelClubLocal=ingresoNombreDelClubLocal.nextLine();
        Scanner ingresoNombreDelClubVisitante = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nombre del equipo visitante");
        String nombreDelClubVisitante=ingresoNombreDelClubVisitante.nextLine();
        ClubDeFutbol clubDeFutbolLocal=BuscarClubPorSuNombre(nombreDelClubLocal);
        Partido partido=BuscarPartido(clubDeFutbolLocal,nombreDelClubVisitante);
        partido.informacionCadaEquipo();
    }
    public Partido BuscarPartido(ClubDeFutbol clubDeFutbolLocal, String nombreDelClubVisitante) {
        for (Partido partidoAux:clubDeFutbolLocal.getPartidosJugados()) {
            if (partidoAux.getEquipoVisitante().equals(nombreDelClubVisitante)) {
                return partidoAux;
            }
        }
    }
    public void RegistrarNuevoPartido() {
        Scanner ingresoNombreDelClubLocal = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nombre del equipo local");
        String nombreDelClubLocal=ingresoNombreDelClubLocal.nextLine();
        Scanner ingresoNombreDelClubVisitante = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nombre del equipo visitante");
        String nombreDelClubVisitante=ingresoNombreDelClubVisitante.nextLine();
        Scanner ingresoGolesClubLocal = new Scanner(System.in);
        System.out.println("ingrese goles del equipo local");
        int golesClubLocal=ingresoGolesClubLocal.nextInt();
        Scanner ingresoGolesClubVisitante = new Scanner(System.in);
        System.out.println("ingrese goles del equipo visitante");
        int golesClubVisitante=ingresoGolesClubVisitante.nextInt();
        Scanner ingresoFechaYHora = new Scanner(System.in);
        System.out.println("ingrese fecha y hora");
        String fechayHora=ingresoFechaYHora.nextLine();
        ClubDeFutbol clubDeFutbolLocal=BuscarClubPorSuNombre(nombreDelClubLocal);
        ClubDeFutbol clubDeFutbolVisitante=BuscarClubPorSuNombre(nombreDelClubVisitante);
        Partido partido= new Partido(clubDeFutbolLocal,clubDeFutbolVisitante,golesClubLocal,golesClubVisitante,fechayHora);
        clubDeFutbolLocal.añadirPartido(partido);
        clubDeFutbolVisitante.añadirPartido(partido);
    }
    public ClubDeFutbol BuscarClubPorSuNombre(String nombreDelClub) {
        for (ClubDeFutbol clubDeFutbolAuxiliar:torneo) {
            if (clubDeFutbolAuxiliar.getNombre().equals(nombreDelClub)) {
                return clubDeFutbolAuxiliar;
            }
        }
        return null;
    }

    public void crearEquiposIniciales() {
        Jugador jugador1= new Jugador("Damian",15,"Perez",3);
        Jugador jugador2= new Jugador("Lautario",16,"Rodriguez",4);
        Jugador jugador3= new Jugador("Franco",17,"Perez",1);
        Jugador jugador4= new Jugador("Maximo",19,"Rodriguez",5);
        Jugador jugador5= new Jugador("Marcos",16,"Perez",7);
        Jugador jugador6= new Jugador("Eduardo",17,"Rodriguez",11);
        Jugador jugador7= new Jugador("Gerardo",19,"Perez",10);
        Jugador jugador8= new Jugador("Carlos",20,"Rodriguez",5);
        Jugador jugador9= new Jugador("Pablo",16,"Perez",7);
        Jugador jugador10= new Jugador("Nicolas",17,"Rodriguez",9);
        Jugador jugador11= new Jugador("Agustin",18,"Perez",3);
        Jugador jugador12= new Jugador("Manolo",19,"Rodriguez",2);
        Jugador jugador13= new Jugador("Papa",17,"Perez",7);
        Jugador jugador14= new Jugador("Juan",18,"Rodriguez",10);
        Jugador jugador15= new Jugador("Ignacio",15,"Perez",11);
        Jugador jugador16= new Jugador("Marco",17,"Rodriguez",10);
        Jugador jugador17= new Jugador("Mano",18,"Perez",7);
        Jugador jugador18= new Jugador("Daddy",19,"Rodriguez",4);
        Jugador jugador19= new Jugador("David",16,"Perez",5);
        Jugador jugador20= new Jugador("Laucho",17,"Rodriguez",9);
        Jugador jugador21= new Jugador("Lionel",15,"Perez",8);
        Jugador jugador22= new Jugador("Urel",17,"Rodriguez",3);
        Jugador jugador23= new Jugador("Jotaro",18,"Perez",13);
        Jugador jugador24= new Jugador("Soul",20,"Rodriguez",15);
        Jugador jugador25= new Jugador("Weri",17,"Perez",20);
        HashSet<Jugador> Equipo1= new HashSet<Jugador>();
        HashSet<Jugador> Equipo2= new HashSet<Jugador>();
        HashSet<Jugador> Equipo3= new HashSet<Jugador>();
        HashSet<Jugador> Equipo4= new HashSet<Jugador>();
        HashSet<Jugador> Equipo5= new HashSet<Jugador>();
        Equipo1.add(jugador1);
        Equipo1.add(jugador2);
        Equipo1.add(jugador3);
        Equipo1.add(jugador4);
        Equipo1.add(jugador5);
        Equipo2.add(jugador6);
        Equipo2.add(jugador7);
        Equipo2.add(jugador8);
        Equipo2.add(jugador9);
        Equipo2.add(jugador10);
        Equipo3.add(jugador11);
        Equipo3.add(jugador12);
        Equipo3.add(jugador13);
        Equipo3.add(jugador14);
        Equipo3.add(jugador15);
        Equipo4.add(jugador16);
        Equipo4.add(jugador17);
        Equipo4.add(jugador18);
        Equipo4.add(jugador19);
        Equipo4.add(jugador20);
        Equipo5.add(jugador21);
        Equipo5.add(jugador22);
        Equipo5.add(jugador23);
        Equipo5.add(jugador24);
        Equipo5.add(jugador25);
        ClubDeFutbol club1= new ClubDeFutbol(Equipo1,"Boca");
        ClubDeFutbol club2= new ClubDeFutbol(Equipo2,"River");
        ClubDeFutbol club3= new ClubDeFutbol(Equipo3,"Rosario Central");
        ClubDeFutbol club4= new ClubDeFutbol(Equipo4,"San lorenzo");
        ClubDeFutbol club5= new ClubDeFutbol(Equipo5,"Banfield");
        HashSet<ClubDeFutbol> Torneo= new HashSet<>();
        Torneo.add(club1);
        Torneo.add(club2);
        Torneo.add(club3);
        Torneo.add(club4);
        Torneo.add(club5);
        this.setTorneo(Torneo);
    }



    public static void main(String[] args) {
        MainTorneoFutbol main=new MainTorneoFutbol();
        MainTorneoFutbol.crearEquiposIniciales();
        boolean SeguirEnElMenu= true;
        while(SeguirEnElMenu) {
            int OpcionElegida=MainTorneoFutbol.EleccionDeOpcionGeneral();
            SeguirEnElMenu=MainTorneoFutbol.EleccionGeneral(OpcionElegida,true,);
        }
    }
}
