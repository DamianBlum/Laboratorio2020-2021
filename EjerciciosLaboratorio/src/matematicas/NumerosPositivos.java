package matematicas;

import java.util.Scanner;
public class NumerosPositivos {
    public static void main(String[] args) {
        Scanner ingresoDatos = new Scanner(System.in);
        System.out.println("Porfavor, ingrese la cantidad de numeros positivos pares que quiere ver");
        int NumerosPositivosEnteros = ingresoDatos.nextInt();
        for (int i=1;i<=NumerosPositivosEnteros;i++) {
            System.out.println(i*2);
        }
    }
    /*
    bien!
     */
}

