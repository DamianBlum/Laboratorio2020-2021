package main;
import seresVivos.Mascotas.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class ABMascotas {

    /*-------------------------------ATRIBUTOS------------------------------------------*/

    private HashSet<Mascotas> conjuntoDeMascotas;

    /*-------------------------------CONSTRUCTOR---------------------------------------*/

    public ABMascotas() {
        this.crearMascotasIniciales();
    }

    /*-------------------------------GETTERS Y SETTERS---------------------------------*/

    public HashSet<Mascotas> getConjuntoDeMascotas() {
        return conjuntoDeMascotas;
    }

    public void setConjuntoDeMascotas(HashSet<Mascotas> conjuntoDeMascotas) {
        this.conjuntoDeMascotas = conjuntoDeMascotas;
    }

    /*----------------------------------FUNCIONES--------------------------------------*/

    public void AgregarMascota() {

        boolean nombreCorrecto=true;
        String nombreMascota;
        do{
            Scanner ingresoNombreMascota = new Scanner(System.in);
            System.out.println("Por favor, ingrese el nombre de la mascota");
            nombreMascota=ingresoNombreMascota.nextLine();
            for (Mascotas mascotaAComparar:conjuntoDeMascotas) {
                if (mascotaAComparar.getNombre().equals(nombreMascota)) {
                    System.out.println("Ese nombre ya se encuentra utilizado.");
                    nombreCorrecto=false;
                }
            }
        } while(!nombreCorrecto);

        Scanner ingresoDuenioMascota = new Scanner(System.in);
        System.out.println("Por favor, ingrese el dueño de la mascota");
        String duenio=ingresoDuenioMascota.nextLine();
        Scanner ingresoTipoMascota = new Scanner(System.in);
        System.out.println("Por favor, ingrese que animal es");
        String tipoMascota=ingresoTipoMascota.nextLine();
        Mascotas nuevaMascota;

        switch (tipoMascota) {
            case "Pez": nuevaMascota=new Pez(nombreMascota,duenio);
                break;
            case "Pajarito": nuevaMascota=new Pajarito(nombreMascota,duenio);
                break;
            case "Perro": nuevaMascota=new Perro(nombreMascota,duenio);
                break;
            case "Gato": nuevaMascota=new Gato(nombreMascota,duenio);
                break;
        }

    }

    public void SacarMascota() {
        boolean seBorro=false;
        Scanner ingresoNombreMascota = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nombre de la mascota");
        String nombreMascota=ingresoNombreMascota.nextLine();
        for (Mascotas mascotaAComparar:conjuntoDeMascotas) {
            if (mascotaAComparar.getNombre().equals(nombreMascota)) {
                seBorro=true;
                conjuntoDeMascotas.remove(mascotaAComparar);
            }
        }
        if (seBorro) {
            System.out.println("Mascota eliminada correctamente");
        }
        else {
            System.out.println("No se encontro una mascota con ese nombre");
        }
    }

    public void CambiarDuenio() {
        boolean seActualizo=false;
        Scanner ingresoNombreMascota = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nombre de la mascota");
        String nombreMascota=ingresoNombreMascota.nextLine();
        Scanner ingresoDuenioMascota = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nuevo dueño de la mascota");
        String duenio=ingresoDuenioMascota.nextLine();
        for (Mascotas mascotaAComparar:conjuntoDeMascotas) {
            if (mascotaAComparar.getNombre().equals(nombreMascota)) {
                seActualizo=true;
                mascotaAComparar.setPropietario(duenio);
            }
        }
        if (seActualizo) {
            System.out.println("Dueño actualizo correctamente");
        }
        else {
            System.out.println("No se encontro una mascota con ese nombre");
        }
    }

    public void CambiarNombre() {
        boolean seActualizo=false;
        Scanner ingresoNombreMascotaAnterior = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nombre anterior de la mascota");
        String nombreMascotaAnterior=ingresoNombreMascotaAnterior.nextLine();
        Scanner ingresoNombreMascotaActual = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nuevo nombre de la mascota");
        String nombreMascotaActual=ingresoNombreMascotaActual.nextLine();
        for (Mascotas mascotaAComparar:conjuntoDeMascotas) {
            if (mascotaAComparar.getNombre().equals(nombreMascotaAnterior)) {
                seActualizo=true;
                mascotaAComparar.setNombre(nombreMascotaActual);
            }
        }
        if (seActualizo) {
            System.out.println("Nombre de mascota actualizado correctamente");
        }
        else {
            System.out.println("No se encontro una mascota con ese nombre");
        }
    }

    public void SaludarMascota(){
        Scanner ingresoNombreMascota = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nombre de la mascota");
        String nombreMascota=ingresoNombreMascota.nextLine();
        Scanner ingresoPersona = new Scanner(System.in);
        System.out.println("Por favor, ingrese la persona que quiere saludar a la mascota");
        String persona=ingresoPersona.nextLine();
        for (Mascotas mascotaAComparar:conjuntoDeMascotas) {
            if (mascotaAComparar.getNombre().equals(nombreMascota)) {
                mascotaAComparar.Saludar(persona);
                if (mascotaAComparar.TipoDeMascota().equals("Pez")) {
                    Pez pezAux= (Pez) mascotaAComparar;
                    if (pezAux.getVidas()==0){
                        conjuntoDeMascotas.remove(mascotaAComparar);
                    }
                }
            }
        }
    }

    public void AlimentarMascota() {
        boolean seAlimento=false;
        Scanner ingresoNombreMascota = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nombre de la mascota a alimentar");
        String nombreMascota=ingresoNombreMascota.nextLine();
        for (Mascotas mascotaAComparar:conjuntoDeMascotas) {
            if (mascotaAComparar.getNombre().equals(nombreMascota)) {
                mascotaAComparar.Alimentar();
                seAlimento=true;
            }
        }
        if (seAlimento) {
            System.out.println("El animal comio correctamente");
        }
        else {
            System.out.println("No se encontro una mascota  con ese nombre");
        }
    }

    public void TipoMascota() {
        Scanner ingresoNombreMascota = new Scanner(System.in);
        System.out.println("Por favor, ingrese el nombre de la mascota");
        String nombreMascota=ingresoNombreMascota.nextLine();
        for (Mascotas mascotaAComparar:conjuntoDeMascotas) {
            if (mascotaAComparar.getNombre().equals(nombreMascota)) {
                System.out.println("Es del tipo "+mascotaAComparar.TipoDeMascota());
            }
        }
    }

    /*-------------------------------------MENU----------------------------------------*/

    public void menuOpciones(){
        System.out.println("Opciones ABM");
        System.out.println("1:Agregar mascota");
        System.out.println("2:Sacar mascota");
        System.out.println("3:Cambiar dueño de mascota");
        System.out.println("4:Cambiar nombre de mascota");
        System.out.println("5:Saludar mascota");
        System.out.println("6:Alimentar mascota");
        System.out.println("7:Tipo de mascota ");
        System.out.println("8:Salir ");

    }

    public int EleccionDeOpcion(){
        menuOpciones();
        Scanner ingresoDeOpcion = new Scanner(System.in);
        int opcion=ingresoDeOpcion.nextInt();
        while (opcion<1 || opcion>8) {
            System.out.println("Opcion Incorrecta, vuelva a elegir");
            menuOpciones();
            opcion=ingresoDeOpcion.nextInt();
        }
        return  opcion;
    }

    public boolean Eleccion(int opcionElegida) {
        switch (opcionElegida) {
            case 1:AgregarMascota();
                break;
            case 2:SacarMascota();
                break;
            case 3:CambiarDuenio();
                break;
            case 4:CambiarNombre();
                break;
            case 5:SaludarMascota();
                break;
            case 6:AlimentarMascota();
                break;
            case 7:TipoMascota();
                break;
            case 8: return false;
        }
        return true;
    }

    /*-------------------------------FUNCIONES INICIALES---------------------------------*/

    private void crearMascotasIniciales(){
        Mascotas mascota1= new Gato("Michu"," Juan Carlos");
        Mascotas mascota2= new Pez("Nemo"," Juan Carlos");
        Mascotas mascota3= new Perro("Firulais"," Miguel Angel");
        Mascotas mascota4= new Pajarito("Carpintero"," Lionel Messi");
        Mascotas mascota5= new Gato("Don Gato"," Miguel Angel");
        Mascotas mascota6= new Perro("Ozzy"," Ozzy Osbourne");
        Mascotas mascota7= new Pajarito("Clario"," Eugenia Bellestar");
        Mascotas mascota8= new Gato("Carioto"," Maria Del Puerto");
        Mascotas mascota9= new Pez("Wally"," Claudete Defourio");
        Mascotas mascota10= new Gato("Michael"," Lisandra Samprio");
        conjuntoDeMascotas= new HashSet<Mascotas>();
        conjuntoDeMascotas.add(mascota1);
        conjuntoDeMascotas.add(mascota2);
        conjuntoDeMascotas.add(mascota3);
        conjuntoDeMascotas.add(mascota4);
        conjuntoDeMascotas.add(mascota5);
        conjuntoDeMascotas.add(mascota6);
        conjuntoDeMascotas.add(mascota7);
        conjuntoDeMascotas.add(mascota8);
        conjuntoDeMascotas.add(mascota9);
        conjuntoDeMascotas.add(mascota10);
    }

    /*-------------------------------MAIN---------------------------------------------*/
    public static void main(String[] args) {
        ABMascotas sistemaDeMascotas= new ABMascotas();
        boolean seguirEnElMenu= true;
        while(seguirEnElMenu) {
            int OpcionElegida=sistemaDeMascotas.EleccionDeOpcion();
            seguirEnElMenu=sistemaDeMascotas.Eleccion(OpcionElegida);
        }
    }
}

