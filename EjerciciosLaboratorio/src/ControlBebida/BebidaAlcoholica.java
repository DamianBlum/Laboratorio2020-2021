package ControlBebida;

public class BebidaAlcoholica extends Bebida {
    private int cantidadDeAlcohol;

    public BebidaAlcoholica(String nombre, int cantidadDeAlcohol) {
        super(nombre, 0,cantidadDeAlcohol*20 );
        this.cantidadDeAlcohol = cantidadDeAlcohol;
    }

    public int getCantidadDeAlcohol() {
        return cantidadDeAlcohol;
    }

    public void setCantidadDeAlcohol(int cantidadDeAlcohol) {
        this.cantidadDeAlcohol = cantidadDeAlcohol;
    }

    @Override
    public String TipoDeBebida(){
        return "Alcoholica";
    }

    @Override
    public int CalculoCoeficiente() {
        return (0-getCoeficienteNegativo());
    }
}
