package servicios.compra;
import servicios.ProductoAlimenticio;
import servicios.compra.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AppParaDeposito {
    private ArrayList<ProductoAlimenticio> productosQueSeEncuentranAlmacenados;
    private ArrayList<String> nombreDeLosProductosDeMiAlmacen;


    public ArrayList<ProductoAlimenticio> getProductosQueSeEncuentranAlmacenados() {
        return this.productosQueSeEncuentranAlmacenados;
    }

    public ArrayList<String> getNombreDeLosProductosDeMiAlmacen() {
        return nombreDeLosProductosDeMiAlmacen;
    }

    public void setNombreDeLosProductosDeMiAlmacen(ArrayList<String> nombreDeLosProductosDeMiAlmacen) {
        this.nombreDeLosProductosDeMiAlmacen = nombreDeLosProductosDeMiAlmacen;
    }

    public void setProductosQueSeEncuentranAlmacenados(ArrayList<ProductoAlimenticio> productosQueSeEncuentranAlmacenados) {
        this.productosQueSeEncuentranAlmacenados = productosQueSeEncuentranAlmacenados;
    }

    public void menuInicialDeOpciones(){
        System.out.println("Ingresar acción que desee hacer");
        System.out.println("1:Registro de productos que ingresan o egresan");
        System.out.println("2:Cuanto vale el stock presente en valor monetario");
        System.out.println("3:Productos actuales sin stock");
        System.out.println("4:Stock de cierto producto");
        System.out.println("5:Productos con stock menor a 15 unidades");
        System.out.println("6:Salir del menu");
    }
    public int EleccionDeOpcionInicial(){
        menuInicialDeOpciones();
        Scanner ingresoDeOpcion = new Scanner(System.in);
        int Opcion=ingresoDeOpcion.nextInt();
        while (Opcion<1 ||Opcion>6) {
            System.out.println("Opcion Incorrecta, vuelva a elegir");
            menuInicialDeOpciones();
            Opcion=ingresoDeOpcion.nextInt();
        }
        return  Opcion;
    }
    public void IngresoDeProductos(){
        Scanner ingresoNombre = new Scanner(System.in);
        System.out.println("Ingrese nombre");
        String nombre = ingresoNombre.nextLine();

        Scanner ingresoPrecio = new Scanner(System.in);
        System.out.println("Ingrese precio unitario");
        int precio = ingresoPrecio.nextInt();

        Scanner ingresoFechaDeElaboracion = new Scanner(System.in);
        System.out.println("Ingrese fecha de elaboracion");
        String fechaaDeElaboracion = ingresoFechaDeElaboracion.nextLine();

        Scanner ingresoFechaDeVencimiento = new Scanner(System.in);
        System.out.println("Ingrese fecha de vencimiento");
        String fechaDeVencimiento = ingresoFechaDeVencimiento.nextLine();

        Scanner ingresoPesoEnGramos = new Scanner(System.in);
        System.out.println("Ingrese peso en gramos de cada unidad");
        int pesoEnGramos = ingresoPesoEnGramos.nextInt();

        Scanner ingresoCantidad = new Scanner(System.in);
        System.out.println("Ingrese cantidad de productos");
        int cantidad= ingresoCantidad.nextInt();

        Scanner ingresoTipo = new Scanner(System.in);
        System.out.println("Este producto es nuevo o existente? (si es nuevo escriba true, si no escriba false)");
        boolean nuevo=ingresoTipo.nextBoolean();

        if (nuevo) {
            nombreDeLosProductosDeMiAlmacen.add(nombre);
        }

        ProductoAlimenticio productoAInsertar= new ProductoAlimenticio(nombre,fechaaDeElaboracion,fechaDeVencimiento,pesoEnGramos,precio);

        for (int i=0;i<cantidad;i++){
            this.productosQueSeEncuentranAlmacenados.add(productoAInsertar);
        }
        System.out.println("El ingreso ha sido un éxito!\n");
    }
    public void EgresoDeProductos(){
        Scanner ingresoNombreQueDeseaEgresar= new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto que desea egresar");
        String nombre=ingresoNombreQueDeseaEgresar.nextLine();

        Scanner ingresoCantidadQueDesaEgresar= new Scanner(System.in);
        System.out.println("Ingrese la cantidad de productos que desea egresar");
        int cantidad=ingresoCantidadQueDesaEgresar.nextInt();

        for (int i=0;i<cantidad;i++) {
            productosQueSeEncuentranAlmacenados.removeIf(productoEnLaLista -> productoEnLaLista.getNombre().equals(nombre));
        }
    }
    public void RegistroDeProductos(){
        boolean registrarDatos = true;
        while (registrarDatos) {

            System.out.println("Bienvenido,¿Desea ingresar un producto o egresar uno? ");
            System.out.println("Ingrese una opcion: ingresar/ egresar");
            Scanner ingresoDeOpcionInicial= new Scanner(System.in);
            String opcionInicial=ingresoDeOpcionInicial.nextLine();
            opcionInicial=opcionInicial.toLowerCase();

            if(opcionInicial.equals("ingresar")){
                IngresoDeProductos();
            }
            else {
                EgresoDeProductos();
            }
            Scanner ingresoDeOpcion = new Scanner(System.in);
            System.out.println("Quiere realizar un nuevo ingreso o egreso?");
            System.out.println("ingrese una opción: si / no ");
            String opcion = ingresoDeOpcion.nextLine();

            opcion = opcion.toLowerCase();

            if (opcion.equals("si")) {
                System.out.println("ok! \n");
                registrarDatos = true;
            }else {
                System.out.println("Bye!");
                registrarDatos = false;
            }
        }

    }
    public void ValorMonetarioStock() {
        int valorTotal=0;
        for (ProductoAlimenticio productoLista:productosQueSeEncuentranAlmacenados) {
            valorTotal=valorTotal+productoLista.getPrecio();
        }
        System.out.println(valorTotal);
    }
    public void ProductosSinStock() {
        for (String nombresDeLosProductos:nombreDeLosProductosDeMiAlmacen) {
            int cantidad=0;
            for (ProductoAlimenticio productoActualEnMiAlmacen:productosQueSeEncuentranAlmacenados) {
                if (productoActualEnMiAlmacen.getNombre().equals(nombresDeLosProductos)) {
                    cantidad++;
                }
            }
            if (cantidad==0) {
                System.out.println(nombresDeLosProductos+" no tiene stock");
            }
        }
    }
    public void StockDeEquisProducto(){
        Scanner ingresoNombre= new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto que desea saber el stock");
        String nombre=ingresoNombre.nextLine();
        int Stock=0;
        for (ProductoAlimenticio productoEnMiLista:productosQueSeEncuentranAlmacenados) {
            if (productoEnMiLista.getNombre().equals(nombre)) {
                Stock++;
            }
        }
        System.out.println(nombre+" tiene "+Stock+" de stock");
    }
    public void ProductosConStockMenorAQuince(){
        for (String nombresDeLosProductos:nombreDeLosProductosDeMiAlmacen) {
            int cantidad=0;
            for (ProductoAlimenticio productoActualEnMiAlmacen:productosQueSeEncuentranAlmacenados) {
                if (productoActualEnMiAlmacen.getNombre().equals(nombresDeLosProductos)) {
                    cantidad++;
                }
            }
            if (cantidad<15) {
                System.out.println(nombresDeLosProductos+" tiene stock menor a 15");
            }
        }
    }
    public boolean EleccionDeFuncion(int OpcionElegida, AppParaDeposito Deposito, boolean SeguirEnElMenu){
        switch (OpcionElegida) {
            case 1: Deposito.RegistroDeProductos();
                break;
            case 2: Deposito.ValorMonetarioStock();
                break;
            case 3: Deposito.ProductosSinStock();
                break;
            case 4: Deposito.StockDeEquisProducto();
                break;
            case 5: Deposito.ProductosConStockMenorAQuince();
                break;
            case 6: SeguirEnElMenu=false;
                break;

        }
        return SeguirEnElMenu;
    }
    public void InicializarPrimerosProductos (){
        ProductoAlimenticio producto1= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto2= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto3= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto4= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto5= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto6= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto7= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto8= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto9= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto10= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto11= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto12= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto13= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto14= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto15= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto16= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto17= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto18= new ProductoAlimenticio("fideos","2018-06-07","2019-01-20",300,30);
        ProductoAlimenticio producto19= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto20= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto21= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto22= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto23= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto24= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto25= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto26= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto27= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto28= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto29= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto30= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto31= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto32= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto33= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto34= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto35= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ProductoAlimenticio producto36= new ProductoAlimenticio("salchicas","2020-04-10","2020-06-25",400,40);
        ArrayList<ProductoAlimenticio> ProductosAlmacenadasIncialmente= new ArrayList<>();
        ProductosAlmacenadasIncialmente.add(producto1);
        ProductosAlmacenadasIncialmente.add(producto2);
        ProductosAlmacenadasIncialmente.add(producto3);
        ProductosAlmacenadasIncialmente.add(producto4);
        ProductosAlmacenadasIncialmente.add(producto5);
        ProductosAlmacenadasIncialmente.add(producto6);
        ProductosAlmacenadasIncialmente.add(producto7);
        ProductosAlmacenadasIncialmente.add(producto8);
        ProductosAlmacenadasIncialmente.add(producto9);
        ProductosAlmacenadasIncialmente.add(producto10);
        ProductosAlmacenadasIncialmente.add(producto11);
        ProductosAlmacenadasIncialmente.add(producto12);
        ProductosAlmacenadasIncialmente.add(producto13);
        ProductosAlmacenadasIncialmente.add(producto14);
        ProductosAlmacenadasIncialmente.add(producto15);
        ProductosAlmacenadasIncialmente.add(producto16);
        ProductosAlmacenadasIncialmente.add(producto17);
        ProductosAlmacenadasIncialmente.add(producto18);
        ProductosAlmacenadasIncialmente.add(producto19);
        ProductosAlmacenadasIncialmente.add(producto20);
        ProductosAlmacenadasIncialmente.add(producto21);
        ProductosAlmacenadasIncialmente.add(producto22);
        ProductosAlmacenadasIncialmente.add(producto23);
        ProductosAlmacenadasIncialmente.add(producto24);
        ProductosAlmacenadasIncialmente.add(producto25);
        ProductosAlmacenadasIncialmente.add(producto26);
        ProductosAlmacenadasIncialmente.add(producto27);
        ProductosAlmacenadasIncialmente.add(producto28);
        ProductosAlmacenadasIncialmente.add(producto29);
        ProductosAlmacenadasIncialmente.add(producto30);
        ProductosAlmacenadasIncialmente.add(producto31);
        ProductosAlmacenadasIncialmente.add(producto32);
        ProductosAlmacenadasIncialmente.add(producto33);
        ProductosAlmacenadasIncialmente.add(producto34);
        ProductosAlmacenadasIncialmente.add(producto35);
        ProductosAlmacenadasIncialmente.add(producto36);
        ArrayList<String> nombresDeMiProductos= new ArrayList<>();
        nombresDeMiProductos.add("fideos");
        nombresDeMiProductos.add("salchicas");
        this.setNombreDeLosProductosDeMiAlmacen(nombresDeMiProductos);
        this.setProductosQueSeEncuentranAlmacenados(ProductosAlmacenadasIncialmente);
    }
    public static void main(String[] args){
        AppParaDeposito Deposito = new AppParaDeposito();
        Deposito.InicializarPrimerosProductos();
        boolean SeguirEnElMenu= true;
        while(SeguirEnElMenu) {
            int OpcionElegida=Deposito.EleccionDeOpcionInicial();
            SeguirEnElMenu=Deposito.EleccionDeFuncion(OpcionElegida,Deposito, true);
        }
    }

}