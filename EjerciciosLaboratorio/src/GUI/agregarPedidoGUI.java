package GUI;

import javafx.scene.text.Font;
import servicios.compra.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;

public class agregarPedidoGUI{
    String nombrePlato;
    JPanel listaPlatos;
    Pedido nuevoPedido = new Pedido();

    public void mostrarPedido(Pedido pedido, JPanel contenedor){
        listaPlatos = new JPanel();
        contenedor.add(listaPlatos);
        listaPlatos.setBounds(30,110,310,250);
        listaPlatos.setBackground(Color.white);

        int y = 10;
        for(String plato_aux : pedido.getPlatos()){
            JLabel label_aux = new JLabel("\200 " + plato_aux);
            listaPlatos.add(label_aux);
            label_aux.setBounds(10,y,100,25);
            y += 20;
        }
    }

    public boolean estadoMesa(String numMesa , ArrayList<Pedido> pedidos) {
        for(Pedido pedido_aux : pedidos){
            if(pedido_aux.getNumeroDeMesa() == Integer.parseInt(numMesa)) {
                return false;
            }
        }
        return true;
    }

    public agregarPedidoGUI(ArrayList<String> platosDelMenu, ArrayList<Pedido> pedidosActivos){
        JFrame f = new JFrame("dou");
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(600,600);
        JPanel contenedor = new JPanel();
        f.add(contenedor);

        JFrame frameAlert = new JFrame();


        contenedor.setBackground(Color.gray);
        contenedor.setBounds(0,0,500,380);

        JLabel label1 = new JLabel("Nro Mesa: ");
        contenedor.add(label1);
        label1.setBounds(30,30,100,50);

        JTextField texto1 = new JTextField();
        contenedor.add(texto1);
        texto1.setBounds(120,40,150,25);

        JLabel label2 = new JLabel("Nombre plato: ");
        contenedor.add(label2);
        label2.setBounds(30,60,100,50);

        JTextField texto2 = new JTextField();
        contenedor.add(texto2);
        texto2.setBounds(120,70,150,25);

        JButton botonAgregarMesa = new JButton("+");
        contenedor.add(botonAgregarMesa);
        botonAgregarMesa.setBounds(280,40,30,25);

        JButton botonEliminarMesa = new JButton("-");
        contenedor.add(botonEliminarMesa);
        botonEliminarMesa.setBounds(310,40,30,25);

        JButton botonAgregarPlato = new JButton("+");
        contenedor.add(botonAgregarPlato);
        botonAgregarPlato.setBounds(280,70,30,25);

        JButton botonEliminarPlato = new JButton("-");
        contenedor.add(botonEliminarPlato);
        botonEliminarPlato.setBounds(310,70,30,25);

        JButton botonAgregar = new JButton("Agregar");
        contenedor.add(botonAgregar);
        botonAgregar.setBounds(380,330,100,30);

        mostrarPedido(nuevoPedido,contenedor);

        botonAgregarMesa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(!texto1.getText().equals("")){
                    if(estadoMesa(texto1.getText(),pedidosActivos)){
                        nuevoPedido.setNumeroDeMesa(Integer.parseInt(texto1.getText()));
                        mostrarPedido(nuevoPedido,contenedor);
                        JOptionPane.showMessageDialog(frameAlert,"Mesa seleccionada.","Alert",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(frameAlert,"Mesa ocupada.","Alert",JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frameAlert,"Parametro vacio.","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        } );

        botonEliminarMesa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                //abrir ventana confirmacion
                if(!texto1.getText().equals("")){
                    if(nuevoPedido.getPlatos().contains(texto1.getText())){
                        nuevoPedido.setNumeroDeMesa(-1);
                        JOptionPane.showMessageDialog(frameAlert,"Mesa deseleccionada.","Alert",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(frameAlert,"Mesa ocupada.","Alert",JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frameAlert,"Parametro vacio.","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        } );

        botonAgregarPlato.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(!texto2.getText().equals("")){
                    if(platosDelMenu.contains(texto2.getText())){
                        nombrePlato = texto2.getText();
                        nuevoPedido.getPlatos().add(nombrePlato);
                        contenedor.remove(listaPlatos);
                        mostrarPedido(nuevoPedido,contenedor);
                    }
                    else{
                        JOptionPane.showMessageDialog(frameAlert,"Plato inexistente.","Alert",JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frameAlert,"Parametro vacio.","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        } );

        botonEliminarPlato.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(!texto2.getText().equals("")){
                    if(nuevoPedido.getPlatos().contains(texto2.getText())){
                        nombrePlato = texto2.getText();
                        nuevoPedido.getPlatos().remove(nombrePlato);
                        contenedor.remove(listaPlatos);
                        mostrarPedido(nuevoPedido,contenedor);
                    }
                    else{
                        JOptionPane.showMessageDialog(frameAlert,"Plato inexistente.","Alert",JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frameAlert,"Parametro vacio.","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        } );
    }

    public static void main(String[] args) {
        ArrayList<String> platosDelMenu  = new ArrayList<>();
        ArrayList<Pedido> pedidosActivos = new ArrayList<>();
        Pedido paux = new Pedido();
        paux.setNumeroDeMesa(1);
        platosDelMenu.add("milanesa");
        new agregarPedidoGUI(platosDelMenu,pedidosActivos);
    }
}