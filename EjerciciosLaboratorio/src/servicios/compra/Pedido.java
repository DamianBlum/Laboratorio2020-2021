package servicios.compra;

import java.util.HashSet;

public class Pedido {
    private String mesa;
    private HashSet<String> platos;

    public Pedido(String mesa, HashSet<String> platos) {
        this.mesa=mesa;
        this.platos=platos;
    }
    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public HashSet<String> getPlatos() {
        return platos;
    }

    public void setPlatos(HashSet<String> plato) {
        this.platos = plato;
    }
}
