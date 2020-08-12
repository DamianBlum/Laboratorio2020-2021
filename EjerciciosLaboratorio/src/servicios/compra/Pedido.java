package servicios.compra;


import java.util.ArrayList;

public class Pedido {
    private int numeroDeMesa;
    private ArrayList<String> platos;

    public Pedido(){
        numeroDeMesa = -1;
        platos       = new ArrayList<>();
    }

    public Pedido(int numeroDeMesa, ArrayList<String> platos){
        this.numeroDeMesa = numeroDeMesa;
        this.platos       = platos;
    }

    public int getNumeroDeMesa() {
        return numeroDeMesa;
    }

    public ArrayList<String> getPlatos() {
        return platos;
    }

    public void setNumeroDeMesa(int numeroDeMesa) {
        this.numeroDeMesa = numeroDeMesa;
    }

    public void setPlatos(ArrayList<String> platos) {
        this.platos = platos;
    }
}