package ControlBebida;

import seresVivos.Persona;

import java.util.ArrayList;
import java.util.HashSet;

public class Consumidor extends Persona implements CoeficienteHidratacion{
    private int dni;
    private String apellido;
    private ArrayList<Bebida> Bebidas;

    public Consumidor(String nombre, int edad, int dni, String apellido, ArrayList<Bebida> bebidas) {
        super(nombre,edad);
        this.apellido=apellido;
        this.dni=dni;
        this.Bebidas=bebidas;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Bebida> getBebidas() {
        return Bebidas;
    }

    public void setBebidas(ArrayList<Bebida> bebidas) {
        Bebidas = bebidas;
    }



    @Override
    public int CalculoCoeficienteHidratacion() {
        int coeficiente=0;
        for (int i = 0; i < Bebidas.size(); i++) {
            coeficiente=coeficiente+Bebidas.get(i).CalculoCoeficiente();
        }
        return coeficiente;
    }
}
