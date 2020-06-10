package main;

import java.util.*;

import servicios.compra.Pedido;

public class MainRestaurante {

    /*-------------------------------ATRIBUTOS------------------------------------------*/

    private ArrayList<Pedido> listaPedidosActuales;
    private HashMap<Integer,Integer> mesas;
    private HashMap<String,Integer> platos;
    private HashSet<Pedido> listaPedidosDelDia; //Arreglar parece que con HashSet no funca


    /*-------------------------------GETTERS Y SETTERS---------------------------------*/

    public ArrayList<Pedido> getListaPedidosActuales() {
        return listaPedidosActuales;
    }

    public void setListaPedidosActuales(ArrayList<Pedido> listaPedidosActuales) {
        this.listaPedidosActuales = listaPedidosActuales;
    }

    public HashMap<Integer, Integer> getMesas() {
        return mesas;
    }

    public void setMesas(HashMap<Integer, Integer> mesas) {
        this.mesas = mesas;
    }

    public HashMap<String, Integer> getPlatos() {
        return platos;
    }

    public void setPlatos(HashMap<String, Integer> platos) {
        this.platos = platos;
    }

    public HashSet<Pedido> getListaPedidosDelDia() {
        return listaPedidosDelDia;
    }

    public void setListaPedidosDelDia(HashSet<Pedido> listaPedidosDelDia) {
        this.listaPedidosDelDia = listaPedidosDelDia;
    }
    /*-------------------------------FUNCIONES DEL MENU---------------------------------*/
    public void agregarMesas(){
        Scanner ingresoCantidadDeMesas = new Scanner(System.in);
        System.out.println("Por favor, ingrese cuantas mesas va a poner");
        int cantidadDeMesas=ingresoCantidadDeMesas.nextInt();
        int numeroDeLaUltimaMesa=mesas.size();
        for(int i=1; i+<cantidadDeMesas;i++) {
            mesas.put(numeroDeLaUltimaMesa+i,0);
        }
        System.out.println("");
        System.out.println("Ingresado correctamente");
    }

    public void borrarMesas(){
        boolean seguirBorrando=true;
        while (seguirBorrando) {
            Scanner ingresoMesaABorrar = new Scanner(System.in);
            System.out.println("Por favor, ingrese la mesa que desee borrar");
            int numeroDeMesa=ingresoMesaABorrar.nextInt();
            mesas.remove(numeroDeMesa);
        }
    }
    /*-------------------------------MENU-----------------------------------------------*/
    public void menuOpciones(){
        System.out.println("Opciones en general del sistema del restaurante");
        System.out.println("1:Agregar mesas");
        System.out.println("2:Borrar mesas");
        System.out.println("3:Agregar platos");
        System.out.println("4:Borrar platos");
        System.out.println("5:Llegó  un cliente");
        System.out.println("6:Se fué un cliente ");
        System.out.println("7:Ver en que lugar esta un pedido ");
        System.out.println("8:Numeros de mesas correspondiente a un plato ");
        System.out.println("9:Siguiente pedido a entregar ");
        System.out.println("10:Mesa mas ocupada del día ");
        System.out.println("11:Plato mas pedido del día ");
        System.out.println("12:Plato menos pedido del día ");
        System.out.println("13:Salir ");
    }

    public int EleccionDeOpcion(){
        menuOpciones();
        Scanner ingresoDeOpcion = new Scanner(System.in);
        int opcion=ingresoDeOpcion.nextInt();
        while (opcion<1 || opcion>13) {
            System.out.println("Opcion Incorrecta, vuelva a elegir");
            menuOpciones();
            opcion=ingresoDeOpcion.nextInt();
        }
        return  opcion;
    }

    public boolean Eleccion(int opcionElegida) {
        switch (opcionElegida) {
            case 1:agregarMesas();
                break;
            case 2:borrarMesas();
                break;
            case 3:agregarPlatos();
                break;
            case 4:borrarPlatos();
                break;
            case 5:registrarPedidoEnActuales();
                break;
            case 6:guardarPedido();
                break;
            case 7:conseguirPosicionPedido();
                break;
            case 8:numerosDeMesasDeUnPlato();
                break;
            case 9:siguientePedidoAEntregar();
                break;
            case 10:mesaMasOcupada();
                break;
            case 11:platoMasPedido();
                break;
            case 12:platoMenosPedido()
                break;
            case 13: return false;
        }
        return true;
    }
    /*-------------------------------FUNCIONES INICIALES---------------------------------*/
    private void crearMesas(){
        mesas=new HashMap<Integer, Integer>();
        mesas.put(1,0);
        mesas.put(2,0);
        mesas.put(3,0);
        mesas.put(4,0);
        mesas.put(5,0);
        mesas.put(6,0);
    }
    private void crearPlatos(){
        platos=new HashMap<String,Integer>();
        platos.put("Milanesa con puré de papas",0);
        platos.put("Ravioles rellenos con carne",0);
        platos.put("Pizza a la Piedra",0);
        platos.put("Polenta con salsa Fileto",0);
        platos.put("Arroz primavera",0);
    }
    private void crearListas(){
    listaPedidosDelDia=new HashSet<Pedido>();
    listaPedidosActuales=new ArrayList<Pedido>();
    crearMesas();
    crearPlatos();
    }

    public MainRestaurante(){
        this.crearListas();
    }
    /*-------------------------------MAIN---------------------------------------------*/
    public static void main(String[] args) {
        MainRestaurante restaurante= new MainRestaurante();
        boolean seguirEnElMenu= true;
        while(seguirEnElMenu) {
            int OpcionElegida=restaurante.EleccionDeOpcion();
            seguirEnElMenu=restaurante.Eleccion(OpcionElegida);
        }
    }
}

