package ControlBebida;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    private HashSet<Consumidor> Consumidores;

    public Main() {
        Consumidores = GenerarConsumidores();

    }

    public HashSet<Consumidor> getConsumidores() {
        return Consumidores;
    }

    public void setConsumidores(HashSet<Consumidor> consumidores) {
        Consumidores = consumidores;
    }

    public HashSet<Consumidor> GenerarConsumidores() {
        Bebida bebida1=new BebidaNeutra("agua1",25,5);
        Bebida bebida2=new BebidaNeutra("agua2",25,0);
        Bebida bebida3=new BebidaNeutra("agua3",15,0);
        Bebida bebida4=new BebidaNeutra("agua4",25,3);
        Bebida bebida5=new BebidaNeutra("agua5",25,4);
        Bebida bebida6=new BebidaNeutra("agua6",25,2);
        Bebida bebida7=new BebidaNeutra("agua7",35,5);
        Bebida bebida8=new BebidaNeutra("agua8",40,5);
        Bebida bebida9=new BebidaNeutra("agua9",45,5);
        ArrayList<Bebida> array1= new ArrayList<>();
        ArrayList<Bebida> array2=new ArrayList<>();
        ArrayList<Bebida> array3=new ArrayList<>();
        array1.add(bebida1);
        array2.add(bebida2);
        array3.add(bebida3);
        array1.add(bebida4);
        array2.add(bebida5);
        array3.add(bebida6);
        array1.add(bebida7);
        array2.add(bebida8);
        array3.add(bebida9);
        Consumidor consumidor1=new Consumidor("Damian",15,44655313,"Blum",array1);
        Consumidor consumidor2= new Consumidor("Jorge",15,34144654,"Casa",array2);
        Consumidor consumidor3= new Consumidor("Manuel",15,34147587,"Paredes",array3);
        HashSet<Consumidor> consumidores= new HashSet<Consumidor>();
        consumidores.add(consumidor1);
        consumidores.add(consumidor2);
        consumidores.add(consumidor3);
        return consumidores;
    }

    public void ConsumidorConMejorCoeficiente(){
        int Coeficiente=0;
        String NombreCompleto="";
        for (Consumidor consumidorEjemplo:Consumidores) {
            if (NombreCompleto.equals("")) {
                Coeficiente=consumidorEjemplo.CalculoCoeficienteHidratacion();
                NombreCompleto=consumidorEjemplo.getNombre()+consumidorEjemplo.getApellido();
            }
            else if (consumidorEjemplo.CalculoCoeficienteHidratacion()>Coeficiente) {
                Coeficiente=consumidorEjemplo.CalculoCoeficienteHidratacion();
                NombreCompleto=consumidorEjemplo.getNombre()+consumidorEjemplo.getApellido();
            }
        }
        System.out.println("La persona con mejor coeficiente es"+NombreCompleto);
    }

    public void ConsumidorConMenorCoeficiente(){
        int Coeficiente=0;
        String NombreCompleto="";
        for (Consumidor consumidorEjemplo:Consumidores) {
            if (NombreCompleto.equals("")) {
                Coeficiente=consumidorEjemplo.CalculoCoeficienteHidratacion();
                NombreCompleto=consumidorEjemplo.getNombre()+consumidorEjemplo.getApellido();
            }
            else if (consumidorEjemplo.CalculoCoeficienteHidratacion()<Coeficiente) {
                Coeficiente=consumidorEjemplo.CalculoCoeficienteHidratacion();
                NombreCompleto=consumidorEjemplo.getNombre()+consumidorEjemplo.getApellido();
            }
        }
        System.out.println("La persona con menor coeficiente es"+NombreCompleto);
    }

    public static void main(String[] args) {
        Main dia1= new Main();
        for (Consumidor consumidorEjemplo:dia1.getConsumidores()) {
            System.out.println(consumidorEjemplo.CalculoCoeficienteHidratacion());
            System.out.println(consumidorEjemplo.getNombre());
        }
        dia1.ConsumidorConMejorCoeficiente();
        dia1.ConsumidorConMenorCoeficiente();
    }
}
