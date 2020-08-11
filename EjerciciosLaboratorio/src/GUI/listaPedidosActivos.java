package GUI;
import servicios.compra.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class listaPedidosActivos {
    public listaPedidosActivos(ArrayList<Pedido> pedidosActivos){
        JFrame f = new JFrame("dou");
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(600,600);

        JPanel contenedor = new JPanel();
        f.add(contenedor);
        contenedor.setBackground(Color.gray);
        contenedor.setBounds(0,0,500,380);
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.LINE_AXIS));

        JTabbedPane tp=new JTabbedPane();
        contenedor.add(tp);

        for (Pedido pedido_aux : pedidosActivos){
            JLabel listaPlatos = new JLabel("   Lista de Platos:");
            JPanel panelPedido = new JPanel();
            panelPedido.add(listaPlatos);
            panelPedido.setLayout(new GridLayout(15, 3, 0, 0));
            for (String plato_aux : pedido_aux.getPlatos()){
                JLabel plato = new JLabel("          " + "\200 " + plato_aux);
                panelPedido.add(plato);
            }
            tp.add("mesa " + String.valueOf(pedido_aux.getNumeroDeMesa()),panelPedido);
        }
    }

    public static void main(String[] args) {
        Pedido p1 = new Pedido();
        p1.setNumeroDeMesa(3);
        p1.getPlatos().add("milanesas de pollo con papas y pure");
        p1.getPlatos().add("salchichas alemanas con pure");
        ArrayList<Pedido> pedidosActivos = new ArrayList<>();
        pedidosActivos.add(p1);
        new listaPedidosActivos(pedidosActivos);
    }
}