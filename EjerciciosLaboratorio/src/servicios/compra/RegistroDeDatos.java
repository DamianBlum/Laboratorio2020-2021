package servicios.compra;

import java.util.Scanner;

public class RegistroDeDatos {
    public static void main(String[] args) {

        Scanner ingresoDatos = new Scanner(System.in);
        System.out.println("Buen día, por favor ingrese su nombre");
        String nombre = ingresoDatos.nextLine();
        System.out.println("Ingrese su apellido");
        String apellido = ingresoDatos.nextLine();
        System.out.println("Hola: " + nombre + " " +apellido);
        System.out.println("...................................................");
        System.out.println("Ingrese su edad");
        int Edad = ingresoDatos.nextInt();
        System.out.println(Edad);
        System.out.println("Ingrese su ocupacion");
        ingresoDatos.nextLine();
        String Ocupacion= ingresoDatos.nextLine();
        System.out.println(Ocupacion);
    }
}
