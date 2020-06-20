package main;
import Objetos.Cuaderno;
import Objetos.HashSetCantidadNoIndeterminada;
import com.sun.tools.javac.Main;

import java.util.HashMap;
import java.util.Scanner;

public class MainCuaderno {

    private HashSetCantidadNoIndeterminada pedido;

    public boolean registrarPedido() {
        Scanner ingresoCuadernoChico = new Scanner(System.in);
        System.out.println("Por favor, ingrese cuanto cuadernos chicos queres");
        int cantidadCuadernoChico=ingresoCuadernoChico.nextInt();
        Scanner ingresoCuadernoMediano = new Scanner(System.in);
        System.out.println("Por favor, ingrese cuanto cuadernos mediano queres");
        int cantidadCuadernoMediano=ingresoCuadernoMediano.nextInt();
        Scanner ingresoCuadernoGrande = new Scanner(System.in);
        System.out.println("Por favor, ingrese cuanto cuadernos grande queres");
        int cantidadCuadernoGrande=ingresoCuadernoGrande.nextInt();
        pedido= new HashSetCantidadNoIndeterminada();
        Cuaderno cuadernoChico= Cuaderno.chico;
        Cuaderno cuadernoMediano= Cuaderno.mediano;
        Cuaderno cuadernoGrande= Cuaderno.grande;
        int precioTotal=0;
        for (int i = 0; i <cantidadCuadernoChico ; i++) {
            pedido.add(cuadernoChico);
            precioTotal=precioTotal+cuadernoChico.getPrecio();
        }
        for (int i = 0; i <cantidadCuadernoMediano ; i++) {
            pedido.add(cuadernoMediano);
            precioTotal=precioTotal+cuadernoMediano.getPrecio();
        }
        for (int i = 0; i <cantidadCuadernoGrande ; i++) {
            pedido.add(cuadernoGrande);
            precioTotal=precioTotal+cuadernoGrande.getPrecio();
        }
        System.out.println("Debe pagar "+precioTotal);
        Scanner seguir = new Scanner(System.in);
        System.out.println("¿Seguir?");
        boolean seguirRegistrando=ingresoCuadernoGrande.nextBoolean();
        return  seguirRegistrando;
    }

    public static void main(String[] args) {
        MainCuaderno main= new MainCuaderno();
        boolean seguirEnElMenu= true;
        while(seguirEnElMenu) {
            seguirEnElMenu=main.registrarPedido();
        }
    }
}
