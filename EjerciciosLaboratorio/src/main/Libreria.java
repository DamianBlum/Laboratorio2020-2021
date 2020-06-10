package main;
import Objetos.Libro;
import seresVivos.Cliente;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;



public class Libreria {
    HashSet<String>          editorialesConDescuento   = new HashSet<>();
    HashSet<Cliente>         Lista_clientes            = new HashSet<>();
    HashMap<String ,Integer> Lista_editoriales         = new HashMap<String, Integer>();
    HashMap<Libro  ,Integer> Venta_libros              = new HashMap<Libro,  Integer>();
    Scanner                  input                     = new Scanner(System.in);
    //evitar error scanner
    String basura;

    public int menu(){

        int eleccionMenu = 0;
        System.out.println("                   ______________"                   );
        System.out.println("___________________|    MENU    |___________________");
        System.out.println("|                                                  |");
        System.out.println("| 1) modificar lista editoriales con descuento     |");
        System.out.println("| 2) modificar lista editoriales                   |");
        System.out.println("| 3) Vender libro                                  |");
        System.out.println("| 4) Mostrar                                       |");
        System.out.println("| 5) Clientes                                      |");
        System.out.println("| 6) Salir                                         |");
        System.out.println("|__________________________________________________|");

        while(eleccionMenu<1 || 5<eleccionMenu){
            System.out.print("                 *ingrese opcion: ");
            eleccionMenu = input.nextInt();
            basura       = input.nextLine();
        }
        System.out.println();

        return eleccionMenu;
    }

    public int menu_clientes(){

        int eleccionMenu = 0;
        System.out.println("                 |    _____________________________");
        System.out.println("                 |    |                           |");
        System.out.println("                 |    | 1) clientes con deuda     |");
        System.out.println("                 |    | 2) cliente que mas gasto  |");
        System.out.println("                 |=>  | 3) registrar cliente      |");
        System.out.println("                      | 4) cancelar deuda         |");
        System.out.println("                      | 5) salir                  |");
        System.out.println("                      |___________________________|");

        while(eleccionMenu<1 || 4<eleccionMenu){
            System.out.print("                          *ingrese opcion: ");
            eleccionMenu = input.nextInt();
            basura       = input.nextLine();
        }
        System.out.println();

        return eleccionMenu;
    }

    public void modificarListaEditorialDescuento(int eleccion){
        String editorial_descuento = "";
        if(eleccion == 1){
            while( (!Lista_editoriales.containsKey(editorial_descuento)) || (editorialesConDescuento.contains(editorial_descuento)) ){
                System.out.print( " --> Ingrese la editorial a agregar a descuentos: ");
                editorial_descuento = input.nextLine();
            }
            editorialesConDescuento.add(editorial_descuento);
        }
        else{
            while(!editorialesConDescuento.contains(editorial_descuento)){
                System.out.print(" --> Ingrese la editorial a aliminar a descuentos: ");
                editorial_descuento = input.nextLine();
            }
            editorialesConDescuento.remove(editorial_descuento);
        }
    }

    public void modificarListaEditorial(int eleccion){
        String editorial = "";
        if(eleccion == 1){
            do{
                System.out.print( " --> Ingrese la editorial a agregar a la libreria: ");
                editorial = input.nextLine();

            }while(Lista_editoriales.containsKey(editorial));

            Lista_editoriales.put(editorial,0);
        }
        else{
            do{
                System.out.print(" --> Ingrese la editorial a eliminar a la libreria: ");
                editorial = input.nextLine();

            }while(!Lista_editoriales.containsKey(editorial));

            Lista_editoriales.remove(editorial);
            editorialesConDescuento.remove(editorial);
        }
    }

    public void acreditar_pago(double cargo){
        int     dni_cliente    = 0;
        int     eleccion       = 0;
        boolean dni_verificado = false;

        while(!dni_verificado){
            System.out.print  ("* Ingresar el dni del cliente: ");
            dni_cliente = input.nextInt();
            basura      = input.nextLine();
            for(Cliente cliente_aux : Lista_clientes){
                if(cliente_aux.getDNI() == dni_cliente){
                    Lista_clientes.remove(cliente_aux);
                    while(eleccion<1 || eleccion>2){
                        System.out.print ("   ->Registrar a Pago(1) o Deuda(2): ");
                        eleccion = input.nextInt();
                        basura   = input.nextLine();
                    }
                    if(eleccion == 1){
                        cliente_aux.setTotal_gastado(cliente_aux.getTotal_gastado()+cargo);;
                        Lista_clientes.add(cliente_aux);
                        System.out.println("   * Gasto total del cliente: " + cliente_aux.getTotal_gastado());
                    }
                    else{
                        cliente_aux.setDeuda(cliente_aux.getDeuda()+cargo);
                        Lista_clientes.add(cliente_aux);
                        System.out.println("   * Deuda del cliente: " + cliente_aux.getDeuda());
                    }
                    dni_verificado = true;
                }
            }
        }
    }

    public void ventaLibro(){
        String  eleccion_acreditacion = "";
        String  editorial_libro       = "";
        String  nombre_libro          = "";
        int     cantidad_libro        = 0;
        double  precio_libro          = 0.0;
        boolean sustitucion           = false;

        System.out.println("____________________________________________________");
        System.out.print  ("* Ingresar el nombre del libro vendido: ");
        nombre_libro = input.nextLine();

        while(!Lista_editoriales.containsKey(editorial_libro)){
            System.out.print("* Ingrese la editorial: ");
            editorial_libro = input.nextLine();
        }

        System.out.print("* Ingresar el precio del libro vendido: ");
        precio_libro = input.nextDouble();

        if(editorialesConDescuento.contains(editorial_libro)) precio_libro = precio_libro/2;

        System.out.print("* Ingrese la cantidad: ");
        cantidad_libro = input.nextInt();
        basura         = input.nextLine();

        Libro libro_vendido = new Libro(nombre_libro,editorial_libro,precio_libro);

        for (HashMap.Entry<Libro, Integer> entry : Venta_libros.entrySet()) {
            Libro  key                 = entry.getKey();
            String nombre_libro_aux    = key.getNombre();
            String editorial_libro_aux = key.getEditorial();
            if(nombre_libro_aux.equals(nombre_libro) && editorial_libro_aux.equals(editorial_libro)){
                Integer value = entry.getValue();
                Venta_libros.put(libro_vendido,cantidad_libro + value);
                sustitucion = true;
            }
        }
        if(!sustitucion){
            Venta_libros.put(libro_vendido,cantidad_libro);
        }

        Lista_editoriales.put(editorial_libro,cantidad_libro + (Integer)Lista_editoriales.get(editorial_libro));

        System.out.println("____________________________________________________" );
        System.out.println(" * Nombre del libro: "   + nombre_libro               );
        System.out.println(" * Precio del libro: "   + precio_libro               );
        System.out.println(" * Cantidad de libros: " + cantidad_libro             );
        System.out.println(" * Gasto Total: "        + precio_libro*cantidad_libro + "$" );
        System.out.println("____________________________________________________" );
        while(!eleccion_acreditacion.equals("S") && !eleccion_acreditacion.equals("N") && !Lista_clientes.isEmpty()){
            System.out.print  ("  ->Acreditar pago a un cliente registrado? S/N: " );
            eleccion_acreditacion = input.nextLine();
        }
        if(eleccion_acreditacion.equals("S")){
            acreditar_pago(precio_libro*cantidad_libro);
        }
    }

    public static void main(String[] args) {
        Libreria libreria = new Libreria();

        libreria.Lista_editoriales.put("kapelusz"    , 0);
        libreria.Lista_editoriales.put("sudamericana", 0);
        libreria.Lista_editoriales.put("atlántida"   , 0);
        libreria.Lista_editoriales.put("elateneo"    , 0);
        libreria.Lista_editoriales.put("interzona"   , 0);
        libreria.Lista_editoriales.put("sur"         , 0);
        libreria.Lista_editoriales.put("alianza"     , 0);

        int opcion_menu;
        do{
            opcion_menu = libreria.menu();
            switch(opcion_menu){
                case 1:
                case 2:
                    int opcion_menu_operacion = 0;
                    while(opcion_menu_operacion<1 || opcion_menu_operacion>2){
                        System.out.print(" -> Elija operacion,(1)insertar o (2)eliminar): ");
                        opcion_menu_operacion = libreria.input.nextInt();
                        libreria.basura       = libreria.input.nextLine();
                    }
                    if(opcion_menu == 1) {
                        libreria.modificarListaEditorialDescuento(opcion_menu_operacion);
                    }
                    else{
                        libreria.modificarListaEditorial(opcion_menu_operacion);
                    }
                    break;
                case 3:
                    libreria.ventaLibro();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Editoriales:  " + libreria.Lista_editoriales);
                    System.out.println("E. Descuento: " + libreria.editorialesConDescuento);
                    System.out.println("Libros:       " +libreria.Venta_libros);
                    System.out.println(libreria.Lista_clientes.size());
                    System.out.println();
                    break;
                case 5:
                    int dni_cliente = 0;
                    switch (libreria.menu_clientes()) {
                        case 1:
                            System.out.println("                           -> Clientes con deuda pendiente: "  );
                            System.out.println("                                   ___________________________");
                            for (Cliente cliente_aux : libreria.Lista_clientes) {
                                if (cliente_aux.getDeuda() > 0) {
                                    System.out.println("                                   nombre: " + cliente_aux.getNombre());
                                    System.out.println("                                   dni: "    + cliente_aux.getDNI());
                                    System.out.println("                                   deuda: "  + cliente_aux.getDeuda() + "$" );
                                    System.out.println("                                   ___________________________");
                                }
                            }
                            break;
                        case 2:
                            double mayor_gasto_total = 0;
                            String apellido_cliente  = "";
                            dni_cliente       = 0;
                            for (Cliente cliente_aux : libreria.Lista_clientes) {
                                if (cliente_aux.getTotal_gastado() >= mayor_gasto_total) {
                                    mayor_gasto_total = cliente_aux.getTotal_gastado();
                                    apellido_cliente  = cliente_aux.getApellido();
                                    dni_cliente       = cliente_aux.getDNI();
                                }
                            }
                            System.out.println("                           -> Cliente con mayor ingreso: "    );
                            System.out.println("                                  ___________________________");
                            System.out.println("                                   apellido: "      + apellido_cliente );
                            System.out.println("                                   dni: "           + dni_cliente      );
                            System.out.println("                                 * total gastado: " + mayor_gasto_total + "$" );
                            System.out.println("                                  ___________________________");
                            break;
                        case 3:
                            System.out.print("                          Nombre: ");
                            String Nombre = libreria.input.nextLine();
                            System.out.print("                          Apellido: ");
                            String Apellido = libreria.input.nextLine();
                            System.out.print("                          Edad: ");
                            int edad            = libreria.input.nextInt();
                            libreria.basura = libreria.input.nextLine();
                            System.out.print("                          Dni: ");
                            int     dni             = libreria.input.nextInt();
                            libreria.basura = libreria.input.nextLine();
                            Cliente nuevo_cliente   = new Cliente(Nombre,Apellido,edad,dni,0,0);
                            libreria.Lista_clientes.add(nuevo_cliente);
                            break;
                        case 4:
                            dni_cliente = 0;
                            System.out.print("                           -> dni cliente a cancelar deuda: ");
                            dni_cliente     = libreria.input.nextInt();
                            libreria.basura = libreria.input.nextLine();
                            for(Cliente cliente_aux : libreria.Lista_clientes){
                                if((cliente_aux.getDNI()) == dni_cliente){
                                    libreria.Lista_clientes.remove(cliente_aux);
                                    cliente_aux.setDeuda(0);
                                    libreria.Lista_clientes.add(cliente_aux);
                                }
                            }
                            break;
                    }
                    break;
            }
        } while(opcion_menu != 6);
    }
}
