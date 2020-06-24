package servicios;
import java.util.HashSet;
import java.util.Scanner;

public enum Editorial {
    Kapelusz(0),Sudamericana(0),Atlántida(0),ElAteneo(0),Interzona(0),Sur (0),Alianza(0);
    private int cantVentas;

    private Editorial(int cantVentas){
        this.cantVentas = cantVentas;
    }

    public int getCantVentas() {
        return cantVentas;
    }

    public void setCantVentas(int cantVentas){
        this.cantVentas = cantVentas;
    }

    public static void main(String[] args) {
        HashSet<Editorial> listsaEditorials = new HashSet<Editorial>();
        HashSet<Dia>       diasSemana       = new HashSet<Dia>();
        Scanner            input            = new Scanner(System.in);
        int                opcion;
        String             basura;

        /*agregar editoriales*/
        Editorial nueva_editorial = null;

        nueva_editorial = nueva_editorial.Kapelusz;
        listsaEditorials.add(nueva_editorial);
        nueva_editorial = nueva_editorial.Sudamericana;
        listsaEditorials.add(nueva_editorial);
        nueva_editorial = nueva_editorial.Atlántida;
        listsaEditorials.add(nueva_editorial);
        nueva_editorial = nueva_editorial.ElAteneo;
        listsaEditorials.add(nueva_editorial);
        nueva_editorial = nueva_editorial.Interzona;
        listsaEditorials.add(nueva_editorial);
        nueva_editorial = nueva_editorial.Sur;
        listsaEditorials.add(nueva_editorial);
        nueva_editorial = nueva_editorial.Alianza;
        listsaEditorials.add(nueva_editorial);

        /*agregar editoriales*/
        Dia nuevoDia = null;
        nuevoDia = nuevoDia.Lunes;
        diasSemana.add(nuevoDia);
        nuevoDia = nuevoDia.Martes;
        diasSemana.add(nuevoDia);
        nuevoDia = nuevoDia.Miercoles;
        diasSemana.add(nuevoDia);
        nuevoDia = nuevoDia.Jueves;
        diasSemana.add(nuevoDia);
        nuevoDia = nuevoDia.Viernes;
        diasSemana.add(nuevoDia);
        nuevoDia = nuevoDia.Sabado;
        diasSemana.add(nuevoDia);
        nuevoDia = nuevoDia.Domingo;
        diasSemana.add(nuevoDia);


        do{

            System.out.println("_______________________________________");
            System.out.println("Ingrese dia de la semana:");
            String dia_semana = input.nextLine();
            System.out.println("Ingresar el nombre del libro vendido");
            String nombre_libro = input.nextLine();
            System.out.println("Ingrese la editorial");
            String editorial_libro = input.nextLine();
            System.out.println("Ingrese la cantidad");
            int cantidad_libro = input.nextInt();
            basura = input.nextLine();

            Dia diaSemana = null;
            switch (dia_semana){
                case "Lunes":
                    diaSemana = diaSemana.Lunes;
                    break;
                case "Martes":
                    diaSemana = diaSemana.Martes;
                    break;
                case "Miercoles":
                    diaSemana = diaSemana.Miercoles;
                    break;
                case "Jueves":
                    diaSemana = diaSemana.Jueves;
                    break;
                case "Viernes":
                    diaSemana = diaSemana.Viernes;
                    break;
                case"Sabado":
                    diaSemana = diaSemana.Sabado;
                    break;
                case "Domingo":
                    diaSemana = diaSemana.Domingo;
                    break;
            }

            Editorial editorial = null;
            switch (editorial_libro){
                case "Kapelusz":
                    editorial = Editorial.Kapelusz;
                    break;
                case "Sudamericana":
                    editorial = Editorial.Sudamericana;
                    break;
                case "Atlántida":
                    editorial = Editorial.Atlántida;
                    break;
                case "ElAteneo":
                    editorial = Editorial.ElAteneo;
                    break;
                case "Interzona":
                    editorial = Editorial.Interzona;
                    break;
                case "Sur":
                    editorial = Editorial.Sur;
                    break;
                case "Alianza":
                    editorial = Editorial.Alianza;
                    break;
            }
            editorial.setCantVentas(editorial.getCantVentas()+cantidad_libro);
            diaSemana.setCantVentasDia(diaSemana.getCantVentasDia()+cantidad_libro);

            System.out.println("_______________________________________");
            System.out.println("¿Salir?");
            System.out.println("1) Si");
            System.out.println("2) No");
            opcion = input.nextInt();
            basura = input.nextLine();
            System.out.println("_______________________________________");

        } while (opcion == 2);

        for(Editorial editorial_aux : listsaEditorials){
            System.out.println(editorial_aux + " : " + editorial_aux.getCantVentas());
        }

        System.out.println("_______________________________________");

        int mayorCantidadVentasDiarias = -1;
        String nomreDiaCantidadVentasDiarias = "";
        for(Dia dia_aux : diasSemana){
            if(dia_aux.getCantVentasDia() > mayorCantidadVentasDiarias){
                mayorCantidadVentasDiarias = dia_aux.getCantVentasDia();
                switch (dia_aux){
                    case Lunes:
                        nomreDiaCantidadVentasDiarias = "Lunes";
                        break;
                    case Martes:
                        nomreDiaCantidadVentasDiarias = "Martes";
                        break;
                    case Miercoles:
                        nomreDiaCantidadVentasDiarias = "Miercoles";
                        break;
                    case Jueves:
                        nomreDiaCantidadVentasDiarias = "Jueves";
                        break;
                    case Viernes:
                        nomreDiaCantidadVentasDiarias = "Viernes";
                        break;
                    case Sabado:
                        nomreDiaCantidadVentasDiarias = "Sabado";
                        break;
                    case Domingo:
                        nomreDiaCantidadVentasDiarias = "Domingo";
                        break;
                }
            }
        }
        System.out.print("Dia con mas ventas: " + nomreDiaCantidadVentasDiarias);
    }
}