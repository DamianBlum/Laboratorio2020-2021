package matematicas;
import java.util.Scanner;
public class DosNumeros {
    public static void main(String[] args) {
        System.out.println("Porfavor, ingrese dos numeros: ");
        Scanner ingresoDatos = new Scanner(System.in);
        int Num1 = ingresoDatos.nextInt();
        int Num2 = ingresoDatos.nextInt();
        if (Num1==Num2) { System.out.println("Los números ingresados son iguales"); }
        else if (Num1>Num2) {System.out.println(Num1); }
        else {System.out.println(Num2); }
    }
    /*
    bien!
     */
}