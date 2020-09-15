package ControlBebida;

public class BebidaNeutra extends Bebida {
    public BebidaNeutra(String nombre, int coeficientePositivo, int coeficienteNegativo) {
        super(nombre, coeficientePositivo, coeficienteNegativo);
    }
    @Override
    public int CalculoCoeficiente() {
        return (getCoeficientePositivo()-getCoeficienteNegativo());
    }

    @Override
    public String TipoDeBebida(){
        return "Neutra";
    }
}
