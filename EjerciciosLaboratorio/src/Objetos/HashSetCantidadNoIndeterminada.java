package Objetos;

import java.util.HashSet;

public class HashSetCantidadNoIndeterminada extends HashSet {

    public void agregarElementos(Object... elementos){
        for (int i = 0; i < elementos.length; i++) {
            this.add(elementos[i]);
        }
    }
}

