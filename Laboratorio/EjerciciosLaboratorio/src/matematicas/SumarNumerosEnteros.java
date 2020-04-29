package matematicas;

import java.util.Scanner;
public class SumarNumerosEnteros {
    public static void main(String[] args) {
        Scanner ingresoDatos = new Scanner(System.in);
        System.out.println("Ingrese numeros positivos, se los sumaremos (si ingresa -1 se mostrara el resultado)");
        int NumerosPositivosEnteros=0;
        int Suma=0;
        while(NumerosPositivosEnteros!=-1) {
            Suma=Suma+NumerosPositivosEnteros;10
            NumerosPositivosEnteros=ingresoDatos.nextInt();
        }
        System.out.println(Suma);
    }
}
