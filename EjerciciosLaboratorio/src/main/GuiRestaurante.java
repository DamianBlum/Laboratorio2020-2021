package main;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import servicios.compra.Pedido;

public class GuiRestaurante {

    private ArrayList<Pedido> listaPedidosActuales;
    private HashMap<Integer,Integer> mesas;
    private HashMap<String,Integer> platos;
    private HashSet<Pedido> listaPedidosDelDia;
    private HashSet<JButton> botonesDelMenu;

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

    }

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

    public GuiRestaurante(){
        this.crearListas();
    }


    /*public void menuInicial() {

        JFrame ventana= new JFrame();
        ventana.setLayout(null);
        ventana.setSize(700,1000);
        ventana.setVisible(true);
        ventana.setTitle("Restaurante");

        JButton botonOpcion1= new JButton("Agregar mesas");
        botonOpcion1.setSize(200,25);
        botonOpcion1.setLocation(200,25);
        ventana.add(botonOpcion1);
        botonesDelMenu.add(botonOpcion1);

        JButton botonOpcion2= new JButton("Borrar mesas");
        botonOpcion2.setSize(200,25);
        botonOpcion2.setLocation(200,75);
        ventana.add(botonOpcion2);
        botonesDelMenu.add(botonOpcion2);

        JButton botonOpcion3= new JButton("Agregar platos");
        botonOpcion3.setSize(200,25);
        botonOpcion3.setLocation(200,125);
        ventana.add(botonOpcion3);
        botonesDelMenu.add(botonOpcion3);

        JButton botonOpcion4= new JButton("Borrar platos");
        botonOpcion4.setSize(200,25);
        botonOpcion4.setLocation(200,175);
        ventana.add(botonOpcion4);
        botonesDelMenu.add(botonOpcion4);

        JButton botonOpcion5= new JButton("LLego un cliente");
        botonOpcion5.setSize(200,25);
        botonOpcion5.setLocation(200,225);
        ventana.add(botonOpcion5);
        botonesDelMenu.add(botonOpcion5);


        JButton botonOpcion6= new JButton("Se fué un cliente");
        botonOpcion6.setSize(200,25);
        botonOpcion6.setLocation(200,275);
        ventana.add(botonOpcion6);
        botonesDelMenu.add(botonOpcion6);

        JButton botonOpcion7= new JButton("Ver en que lugar esta un pedido");
        botonOpcion7.setSize(200,25);
        botonOpcion7.setLocation(200,325);
        ventana.add(botonOpcion7);
        botonesDelMenu.add(botonOpcion7);

        JButton botonOpcion8= new JButton("Numeros de mesas correspondiente a un plato");
        botonOpcion8.setSize(200,25);
        botonOpcion8.setLocation(200,375);
        ventana.add(botonOpcion8);
        botonesDelMenu.add(botonOpcion8);

        JButton botonOpcion9= new JButton("Siguiente pedido a entregar");
        botonOpcion9.setSize(200,25);
        botonOpcion9.setLocation(200,425);
        ventana.add(botonOpcion9);
        botonesDelMenu.add(botonOpcion9);

        JButton botonOpcion10= new JButton("Mesa mas ocupada del día ");
        botonOpcion10.setSize(200,25);
        botonOpcion10.setLocation(200,475);
        ventana.add(botonOpcion10);
        botonesDelMenu.add(botonOpcion10);

        JButton botonOpcion11= new JButton("Plato mas pedido del día");
        botonOpcion11.setSize(200,25);
        botonOpcion11.setLocation(200,525);
        ventana.add(botonOpcion11);
        botonesDelMenu.add(botonOpcion11);

        JButton botonOpcion12= new JButton("Plato menos pedido del día");
        botonOpcion12.setSize(200,25);
        botonOpcion12.setLocation(200,575);
        ventana.add(botonOpcion12);
        botonesDelMenu.add(botonOpcion12);
    }*/
    public static void main(String[] args) {
            /*IDEA: salen las 13 opciones como botones y al presionar se desaparece
            todoo y muestra  de acuerdo al caso*/

            /*boton 1: Agregar mesa: Aparece arriba un texto que diga "Ingrese el nombre del plato"
            y un campo para ingresar el nombre, luego dos botones uno al lado del otro, seguir ingresando a la derecha
            y salir a la izquierda*/

            /*boton 2: Borrar mesa: IDEM arriba pero le pregunta nombre de la mesa  para borrarla*/

            /*y asi basicamente casi en la mayoria, me voy manejando poniendo algun boton, texto y campo
             para insertar datos o buscar algo*/

            JFrame ventana= new JFrame();
            ventana.setLayout(null);
            ventana.setSize(700,1000);
            ventana.setVisible(true);
            ventana.setTitle("Restaurante");

            JMenuBar barraDeMenu= new JMenuBar();
            ventana.setJMenuBar(barraDeMenu);

            JMenu opcion1= new JMenu("Agregar mesas");
            barraDeMenu.add(opcion1);

            JMenu opcion2= new JMenu("Borrar mesas ");
            barraDeMenu.add(opcion2);

            JMenu opcion3= new JMenu("Agregar platos ");
            barraDeMenu.add(opcion3);

            JMenu opcion4= new JMenu("Borrar platos ");
            barraDeMenu.add(opcion4);

            JMenu opcion5= new JMenu("LLego un cliente ");
            barraDeMenu.add(opcion5);

            JMenu opcion6= new JMenu("Se fué un cliente ");
            barraDeMenu.add(opcion6);

            JMenu opcion7= new JMenu("Ver en que lugar esta un pedido ");
            barraDeMenu.add(opcion7);

            JMenu opcion8= new JMenu("Numeros de mesas correspondiente a un plato ");
            barraDeMenu.add(opcion8);

            JMenu opcion9= new JMenu("Siguiente pedido a entregar ");
            barraDeMenu.add(opcion9);

            JMenu opcion10= new JMenu("Mesa mas ocupada del día  ");
            barraDeMenu.add(opcion10);

            JMenu opcion11= new JMenu("Plato mas pedido del día");
            barraDeMenu.add(opcion11);

            JMenu opcion12= new JMenu("Plato menos pedido del día ");
            barraDeMenu.add(opcion12);




    }


}
