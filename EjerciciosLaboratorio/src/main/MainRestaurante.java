package main;

import java.util.*;

import servicios.compra.Pedido;

public class MainRestaurante {

    /*-------------------------------ATRIBUTOS------------------------------------------*/

    private ArrayList<Pedido> listaPedidosActuales;
    private HashMap<Integer,Integer> mesas;
    private HashMap<String,Integer> platos;
    private HashSet<Pedido> listaPedidosDelDia;


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
    /*-------------------------------FUNCION ROBADA DE INTERNET---------------------------------*/
    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*-------------------------------FUNCIONES DEL MENU---------------------------------*/
    public void agregarMesas(){
        Scanner ingresoCantidadDeMesas = new Scanner(System.in);
        System.out.println("Por favor, ingrese cuantas mesas va a poner");
        int cantidadDeMesas=ingresoCantidadDeMesas.nextInt();
        int numeroDeLaUltimaMesa=mesas.size();
        for(int i=1;i<cantidadDeMesas;i++) {
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
            Scanner ingresoSeguirBorrando = new Scanner(System.in);
            System.out.println("Desea seguir borrando? (ingrese true o false)");
            seguirBorrando=ingresoSeguirBorrando.nextBoolean();
        }
    }
    public void agregarPlatos(){
        boolean seguirAgregando=true;
        while (seguirAgregando) {
            Scanner ingresoMesaABorrar = new Scanner(System.in);
            System.out.println("Por favor, ingrese el plato que desea agregar");
            String nombrePlato=ingresoMesaABorrar.nextLine();
            platos.put(nombrePlato,0);
            Scanner ingresoSeguirAgragegando = new Scanner(System.in);
            System.out.println("Desea seguir agregando? (ingrese true o false)");
            seguirAgregando=ingresoSeguirAgragegando.nextBoolean();
        }
    }

    public void borrarPlatos(){
        boolean seguirBorrando=true;
        while (seguirBorrando) {
            Scanner ingresoMesaABorrar = new Scanner(System.in);
            System.out.println("Por favor, ingrese el plato que desea agregar");
            String nombrePlato=ingresoMesaABorrar.nextLine();
            platos.put(nombrePlato,0);
            Scanner ingresoSeguirBorrando = new Scanner(System.in);
            System.out.println("Desea seguir borrando? (ingrese true o false)");
            seguirBorrando=ingresoSeguirBorrando.nextBoolean();
        }
    }
    public void registrarPedidoEnActuales(){

        Scanner ingresoMesa = new Scanner(System.in);
        System.out.println("Por favor, ingrese la mesa donde se ubicaron los cliente");
        int mesa=ingresoMesa.nextInt();
        boolean seguirPreguntado=false;
        do {
            for (Pedido pedidoActual:listaPedidosActuales) {
                if (pedidoActual.getMesa()==mesa) {
                    System.out.println("Esa mesa esta siendo usada");
                    seguirPreguntado=true;
                    System.out.println("Por favor, ingrese una mesa vacía");
                    mesa=ingresoMesa.nextInt();
                }
            }
        } while(seguirPreguntado);
        for (Map.Entry<Integer,Integer> elemento:this.mesas.entrySet()) {
            if (elemento.getKey()==mesa){
                elemento.setValue(elemento.getValue()+1);
            }
        }
        boolean seguirAgregandoPlatos=false;
        HashSet<String> platos= new HashSet<String>();
        do {
            Scanner ingresoPlato = new Scanner(System.in);
            System.out.println("Por favor, ingrese el plato que desea anotar");
            String nombrePlato=ingresoPlato.nextLine();
            for (Map.Entry<String,Integer> elemento:this.platos.entrySet()) {
                if (elemento.getKey().equals(nombrePlato)) {
                    elemento.setValue(elemento.getValue()+1);
                }
            }
            platos.add(nombrePlato);
            Scanner ingresoSeguirAgregando = new Scanner(System.in);
            System.out.println("Desea seguir agregando platos? (ingrese true o false)");
            seguirAgregandoPlatos=ingresoSeguirAgregando.nextBoolean();
        } while(seguirAgregandoPlatos);
        Pedido pedidoNuevo= new Pedido(mesa,platos);
        listaPedidosActuales.add(pedidoNuevo);
    }
    public void guardarPedido() {
        Scanner ingresoMesa = new Scanner(System.in);
        System.out.println("Por favor, ingrese la mesa que se libero");
        int mesa=ingresoMesa.nextInt();
        for (Pedido pedidoActual:listaPedidosActuales) {
            if (pedidoActual.getMesa()==mesa) {
                listaPedidosDelDia.add(pedidoActual);
                listaPedidosActuales.remove(pedidoActual);
            }

        }
    }
    public void conseguirPosicionPedido() {
        Scanner ingresoMesa = new Scanner(System.in);
        System.out.println("Por favor, ingrese la mesa donde se ubican los cliente");
        int mesa=ingresoMesa.nextInt();
        for (int i=0;i<listaPedidosActuales.size();i++) {
            if (listaPedidosActuales.get(i).getMesa()==mesa) {
                System.out.println("El pedido está en la posicion "+(i+1));
            }
            esperar(4);
        }
    }

    public void numerosDeMesasDeUnPlato() {
        Scanner ingresoPlato = new Scanner(System.in);
        System.out.println("Por favor, ingrese el plato que desea buscar");
        String nombrePlato=ingresoPlato.nextLine();
        for (Pedido pedidoARevisar:listaPedidosActuales) {
            for (String platoARevisar:pedidoARevisar.getPlatos()) {
                if (platoARevisar.equals(nombrePlato)) {
                    System.out.println("El plato lo necesita la mesa "+ pedidoARevisar.getMesa());
                }
            }
            esperar(4);
        }
    }

    public void siguientePedidoAEntregar() {
         Pedido siguientePedido=listaPedidosActuales.get(0);
        System.out.println("El siguiente pedido es a la mesa "+siguientePedido.getMesa());
        System.out.print("Y requiere los siguientes platos: ");
        for (String plato:siguientePedido.getPlatos()) {
            System.out.print(plato+" ");
        }
        System.out.println();
        esperar(5);
    }
    public void mesaMasOcupada(){
        int usosDeLaMesa=-1;
        int mesaConMasUsos = 0;
        for (Map.Entry<Integer,Integer> mesa:mesas.entrySet()) {
            if (mesa.getValue()>usosDeLaMesa) {
                usosDeLaMesa=mesa.getValue();
                mesaConMasUsos=mesa.getKey();
            }
        }
        System.out.println("La mesa mas ocupada fue la numero "+mesaConMasUsos);
        esperar(4);
    }
    public void platoMasPedido(){
        int cantidadDeVecesPedido=-1;
        String PlatoConMasPedidos= "";
        for (Map.Entry<String,Integer> plato:platos.entrySet()) {
            if (plato.getValue()>cantidadDeVecesPedido) {
                cantidadDeVecesPedido=plato.getValue();
                PlatoConMasPedidos=plato.getKey();
            }
        }
        System.out.println("El plato mas pedido fue: "+PlatoConMasPedidos);
        esperar(4);
    }
    public void platoMenosPedido(){
        int cantidadDeVecesPedido=-1;
        String PlatoConMenosPedidos= "";
        for (Map.Entry<String,Integer> plato:platos.entrySet()) {
            if (cantidadDeVecesPedido==-1) { //el primero viene aca asi todos se rigen bajo él
                cantidadDeVecesPedido=plato.getValue();
                PlatoConMenosPedidos=plato.getKey();
            }
            if (plato.getValue()<cantidadDeVecesPedido) {
                cantidadDeVecesPedido=plato.getValue();
                PlatoConMenosPedidos=plato.getKey();
            }
        }
        System.out.println("El plato menos pedido fue: "+PlatoConMenosPedidos);
        esperar(4);
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
            case 12:platoMenosPedido();
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

