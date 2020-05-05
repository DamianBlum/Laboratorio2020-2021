package servicios.compra;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistroDeCompras {
    public static void main(String[] args) {
        ArrayList<Producto> listaDeProductos = new ArrayList<>();
        boolean SeguirMetiendoProductos=true;
        while(SeguirMetiendoProductos) {
            Producto productoAinsertar= new Producto();
            Scanner ingresoDatos = new Scanner(System.in);
            System.out.println("Ingrese el precio del producto: ");
            int precio=ingresoDatos.nextInt();
            productoAinsertar.setPrecio(precio);
            System.out.println("Ingrese el nombre del producto: ");
            ingresoDatos.nextLine();
            String nombre=ingresoDatos.nextLine();
            productoAinsertar.setNombre(nombre);
            System.out.println("Ingrese la marca del producto: ");
            String marca=ingresoDatos.nextLine();
            productoAinsertar.setMarca(marca);
            System.out.println("Ingrese cuantas unidades del producto: ");
            int unidades=ingresoDatos.nextInt();
            productoAinsertar.setUnidades(unidades);
            listaDeProductos.add(productoAinsertar);
            System.out.println("¿Tiene mas productos? (1 si tiene más y 0 si no)");
            int Seguir=ingresoDatos.nextInt();
            if (Seguir==0) {
                SeguirMetiendoProductos=false;
            }
        }
        int ImporteAPagar=0;
        for (int i=0;i<listaDeProductos.size();i++) {
            Producto producto=listaDeProductos.get(i);
            ImporteAPagar=ImporteAPagar+(producto.getPrecio()*producto.getUnidades());
        }
        System.out.println("El importe a pagar es de: " + ImporteAPagar);
    }
}
