package ControlBebida;

public class BebidaAzucarada extends Bebida {
    private int cantidadDeAzucar;

    public BebidaAzucarada(String nombre, int cantidadDeAzucar) {
        super(nombre, 1, cantidadDeAzucar*10);
        this.cantidadDeAzucar = cantidadDeAzucar;
    }

    public int getCantidadDeAzucar() {
        return cantidadDeAzucar;
    }

    public void setCantidadDeAzucar(int cantidadDeAzucar) {
        this.cantidadDeAzucar = cantidadDeAzucar;
    }
    @Override
    public int CalculoCoeficiente() {
        return (1-getCoeficienteNegativo());
    }

    @Override
    public String TipoDeBebida(){
        return "Azucarada";
    }

}
