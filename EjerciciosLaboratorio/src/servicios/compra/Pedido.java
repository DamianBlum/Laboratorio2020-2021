package servicios.compra;

import java.util.HashSet;

public class Pedido {
    private int mesa;
    private HashSet<String> platos;

    public Pedido(int mesa, HashSet<String> platos) {
        this.mesa=mesa;
        this.platos=platos;
    }
    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public HashSet<String> getPlatos() {
        return platos;
    }

    public void setPlatos(HashSet<String> plato) {
        this.platos = plato;
    }
}
