package main;
import Objetos.Libro;
import servicios.Editorial;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MainLibreria {
    private HashMap<Libro, Editorial> ventaEditorial;

    public void agregarVenta(Libro libroQueSeVendio) {
        for ( Map.Entry<Libro,Editorial> elemento : ventaEditorial.entrySet() ) {
            System.out.println(elemento.getKey().getNombre());
            if(elemento.getKey() == libroQueSeVendio){
                elemento.getValue().addVentasDias();
            }
        }
    }
    public void editoriaConMasVendidos(){
        int cantidadMayor=0;
        String editorialGanadora = "";
        for ( Map.Entry<Libro,Editorial> elemento : ventaEditorial.entrySet() ) {
            if (elemento.getValue().getVentasDias()>=cantidadMayor) {
                cantidadMayor=elemento.getValue().getVentasDias();
                editorialGanadora=elemento.getValue().getNombre();
            }
        }
        System.out.println("La editorial con mas ventas del dia es: "+editorialGanadora);
    }

    public static void main(String[] args) {
        MainLibreria nuevaLibreria=new MainLibreria();
        HashMap<Libro, Editorial> ventaEditorial= new HashMap<Libro,Editorial>();
        //"Kapelusz, Sudamericana, Atlántida, ElAteneo, Interzona, Sur y Alianza."
        Libro libro1=new Libro("Harry Potter",401);
        Libro libro2=new Libro("Libertad,Libertad,Libertad",518);
        Libro libro3=new Libro("La puerta equivocada",168);
        Libro libro4=new Libro("Estrategias",109);
        Libro libro5=new Libro("Las comunicaciones",158);
        Libro libro6=new Libro("El misterio del rock",50);
        Libro libro7=new Libro("A sangre fría",750);
        Libro libro8=new Libro("Vampiratas",150);
        Libro libro9=new Libro("El señor de los anillos",200);
        Libro libro10=new Libro("El hobbit",150);
        Editorial editorial1=new Editorial("Kapelusz",5);
        Editorial editorial2=new Editorial("Sudamericana",5);
        Editorial editorial3=new Editorial("Atlántida",5);
        Editorial editorial4=new Editorial("ElAteneo",5);
        Editorial editorial5=new Editorial("Interzona",5);
        Editorial editorial6=new Editorial("Sur",5);
        Editorial editorial7=new Editorial("Alianza",5);
        ventaEditorial.put(libro1,editorial4);
        ventaEditorial.put(libro2,editorial1);
        ventaEditorial.put(libro3,editorial7);
        ventaEditorial.put(libro4,editorial5);
        ventaEditorial.put(libro5,editorial6);
        ventaEditorial.put(libro6,editorial2);
        ventaEditorial.put(libro7,editorial3);
        ventaEditorial.put(libro8,editorial6);
        ventaEditorial.put(libro9,editorial3);
        ventaEditorial.put(libro10,editorial2);
        nuevaLibreria.ventaEditorial=ventaEditorial;
        nuevaLibreria.agregarVenta(libro3);
        nuevaLibreria.editoriaConMasVendidos();
    }
}
