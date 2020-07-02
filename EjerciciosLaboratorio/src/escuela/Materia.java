package escuela;

import java.util.HashSet;

public class Materia {
    private String nombre;
    private HashSet<Double> listaNotas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.listaNotas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashSet<Double> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(HashSet<Double> listaNotas) {
        this.listaNotas = listaNotas;
    }

    public Double conseguirPromedio(){
        double sumaNotas = 0.0;
        int cantidadNotas=0;
        for (Double nota:listaNotas) {
            sumaNotas=sumaNotas+nota;
            cantidadNotas++;
        }
        return sumaNotas/cantidadNotas;
    }

    public void agregarNota(Double nota){
        listaNotas.add(nota);
    }
    public Double menorNota(){
        Double menorNota=0.0;
        for (Double nota:listaNotas) {
            if (menorNota==0) menorNota=nota;
            else if (nota<menorNota) menorNota=nota;
        }
        return menorNota;
    }

    public Double mayorNota(){
        Double mayorNota=0.0;
        for (Double nota:listaNotas) {
            if (mayorNota==0) mayorNota=nota;
            else if (nota>mayorNota) mayorNota=nota;
        }
        return mayorNota;
    }
}
