package Objetos;

import java.util.ArrayList;

public class ArrayListCantidadNoIndeterminada extends ArrayList {

    public void agregarElementos(Object... elementos){
        for (int i = 0; i < elementos.length; i++) {
            this.add(elementos[i]);
        }
    }
}
