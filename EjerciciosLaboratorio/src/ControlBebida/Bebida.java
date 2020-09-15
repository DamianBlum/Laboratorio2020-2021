package ControlBebida;

public abstract class Bebida {
    private String nombre;
    private int coeficientePositivo;
    private int coeficienteNegativo;

    public Bebida(String nombre, int coeficientePositivo, int coeficienteNegativo) {
        this.nombre = nombre;
        this.coeficientePositivo = coeficientePositivo;
        this.coeficienteNegativo = coeficienteNegativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoeficientePositivo() {
        return coeficientePositivo;
    }

    public void setCoeficientePositivo(int coeficientePositivo) {
        this.coeficientePositivo = coeficientePositivo;
    }

    public int getCoeficienteNegativo() {
        return coeficienteNegativo;
    }

    public void setCoeficienteNegativo(int coeficienteNegativo) {
        this.coeficienteNegativo = coeficienteNegativo;
    }

    public String TipoDeBebida(){
        return "No especificada";
    }
    public int CalculoCoeficiente() {
        System.out.println("Se necesita saber que tipo es");
        return 0;
    }
}
