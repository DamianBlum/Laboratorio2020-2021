package seresVivos;

import escuela.Materia;
/*
import java.util.HashMap;
import java.util.Map;

public class Alumno extends Persona{
    private HashMap<Materia,Double> listaMateriasConPromedio;

    public Alumno(String Nombre, int Edad, String Apellido, int dni) {
        super(Nombre, Edad, Apellido, dni);
        this.listaMateriasConPromedio= new HashMap<Materia, Double>();
    }

    public HashMap<Materia, Double> getListaMateriasConPromedio() {
        return listaMateriasConPromedio;
    }

    public void setListaMateriasConPromedio(HashMap<Materia, Double> listaMateriasConPromedio) {
        this.listaMateriasConPromedio = listaMateriasConPromedio;
    }
    public void agregarMateria(Materia nuevaMateria) {
        listaMateriasConPromedio.put(nuevaMateria,nuevaMateria.conseguirPromedio());
    }
    public void actualizarPromedio() {
        for (Map.Entry<Materia,Double> materia :listaMateriasConPromedio.entrySet()) {
            materia.setValue(materia.getKey().conseguirPromedio());
        }
    }
    public Double promedioDeCiertaMateria(String nombre) {
        for (Map.Entry<Materia,Double> materia :listaMateriasConPromedio.entrySet()) {
            if (materia.getKey().getNombre().equals(nombre)) {
                return materia.getValue();
            }
        }
        return 0.0;
    }
    public Double mayorPromedio () {
        Double mayor=0.0;
        for (Map.Entry<Materia,Double> materia :listaMateriasConPromedio.entrySet()) {
            if (materia.getValue()>mayor) {
                mayor=materia.getValue();
            }
        }
        return mayor;
    }

    public Double menorPromedio () {
        Double menor=0.0;
        for (Map.Entry<Materia,Double> materia :listaMateriasConPromedio.entrySet()) {
            if (menor==0.0) menor=materia.getValue();
            else if (materia.getValue()<menor) {
                menor=materia.getValue();
            }
        }
        return menor;
    }
    public double promedioFinal() {
        double sumaPromedio = 0.0;
        int cantidadNotas=0;
        for (Map.Entry<Materia,Double> materia :listaMateriasConPromedio.entrySet()) {
            cantidadNotas++;
            sumaPromedio=sumaPromedio+materia.getValue();
        }
        return sumaPromedio/cantidadNotas;
    }

}*/
