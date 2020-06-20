import Objetos.ArrayListCantidadNoIndeterminada;

import java.util.HashSet;
import java.util.Scanner;

public class prueba {
    public static void main(String[] args) {
        ArrayListCantidadNoIndeterminada nuevo= new ArrayListCantidadNoIndeterminada();
        nuevo.agregarElementos(1,2,3,4,5,6,7,4,8,9);
        for (int i = 0; i < nuevo.size(); i++) {
            System.out.println(nuevo.get(i));
        }

    }

}
