package main;
import java.util.HashSet;
import java.util.Scanner;

public enum Libreria {
    Kapelusz(0),Sudamericana(0),Atlantida(0),ElAteneo(0),Interzona(0),Sur (0),Alianza(0);
    private int cantVentas;

    private Libreria(int cantVentas){
        this.cantVentas = cantVentas;
    }

    public int getCantVentas() {
        return cantVentas;
    }

    public void setCantVentas(int cantVentas){
        this.cantVentas = cantVentas;
    }

    public void inc(int cantidad_libro){
        this.setCantVentas(this.getCantVentas()+cantidad_libro);
    }

    public static void main(String[] args) {
        HashSet<Libreria> listsaLibrerias = new HashSet<Libreria>();
        Scanner           input           = new Scanner(System.in);
        int               opcion          = 2;
        String            basura;

        Libreria nueva_libreria = null;

        nueva_libreria = nueva_libreria.Kapelusz;
        listsaLibrerias.add(nueva_libreria);
        nueva_libreria = nueva_libreria.Sudamericana;
        listsaLibrerias.add(nueva_libreria);
        nueva_libreria = nueva_libreria.Atlantida;
        listsaLibrerias.add(nueva_libreria);
        nueva_libreria = nueva_libreria.ElAteneo;
        listsaLibrerias.add(nueva_libreria);
        nueva_libreria = nueva_libreria.Interzona;
        listsaLibrerias.add(nueva_libreria);
        nueva_libreria = nueva_libreria.Sur;
        listsaLibrerias.add(nueva_libreria);
        nueva_libreria = nueva_libreria.Alianza;
        listsaLibrerias.add(nueva_libreria);

        while (opcion == 2) {

            System.out.println("_______________________________________");
            System.out.println("Ingresar el nombre del libro vendido");
            String nombre_libro = input.nextLine();
            System.out.println("Ingrese la editorial");
            String editorial_libro = input.nextLine();
            System.out.println("Ingrese la cantidad");
            int cantidad_libro = input.nextInt();
            basura = input.nextLine();

            Libreria libreria_aux = null;
            switch (editorial_libro){
                case "Kapelusz":
                    libreria_aux = Libreria.Kapelusz;
                    break;
                case "Sudamericana":
                    libreria_aux = Libreria.Sudamericana;
                    break;
                case "Atlántida":
                    libreria_aux = Libreria.Atlantida;
                    break;
                case "ElAteneo":
                    libreria_aux = Libreria.ElAteneo;
                    break;
                case "Interzona":
                    libreria_aux = Libreria.Interzona;
                    break;
                case "Sur":
                    libreria_aux = Libreria.Sur;
                    break;
                case "Alianza":
                    libreria_aux = Libreria.Alianza;
                    break;
            }
            libreria_aux.inc(cantidad_libro);

            System.out.println("_______________________________________");
            System.out.println("¿Salir?");
            System.out.println("1) Si");
            System.out.println("2) No");
            opcion = input.nextInt();
            basura = input.nextLine();
            System.out.println("_______________________________________");
        }
        for(Libreria libreria_aux : listsaLibrerias){
            System.out.println(libreria_aux + ":" + libreria_aux.getCantVentas());
        }
    }
}
