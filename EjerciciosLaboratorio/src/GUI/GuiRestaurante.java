package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import servicios.compra.*;
public class GuiRestaurante {

    ArrayList<String> platosDelMenu  = new ArrayList<>();
    ArrayList<Pedido> pedidosActivos = new ArrayList<>();

    public GuiRestaurante()
    {
        //______________________VENTANA_____________________________
        JFrame ventana= new JFrame("RESTAURANTE");
        ventana.setVisible(true);
        ventana.setBounds(270,50,800,600);
        ventana.setLayout(null);

        //_______________________TITULO_____________________________
        JLabel titulo = new JLabel("TITULOS");
        titulo.setBounds(40,5,100,100);
        ventana.add(titulo);

        //______________________PANELES_____________________________

        agregar_borrarPlatoGUI opcion1 = new agregar_borrarPlatoGUI(platosDelMenu);
        //agregarPedidoGUI       opcion2 = new agregarPedidoGUI(platosDelMenu,pedidosActivos);
        //listaPedidosActivos    opcion3 = new listaPedidosActivos(pedidosActivos);

        //______________________BOTONES_____________________________
        JButton b1=new JButton("Button 1");
        b1.setBounds(40,100,100,30);
        b1.setBackground(Color.gray);
        JButton b2=new JButton("Button 2");
        b2.setBounds(40,150,100,30);
        b2.setBackground(Color.red);
        JButton b3=new JButton("Button 3");
        b3.setBounds(40,200,100,30);
        b3.setBackground(Color.green);
        ventana.add(b1);
        ventana.add(b2);
        ventana.add(b3);

        b1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){


            }
        } );
        b2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){

            }
        } );
        b3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){

            }
        } );

    }

    public static void main(String[] args) {
        new GuiRestaurante();
    }
}



/*import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class GuiRestaurante{

    ArrayList<JPanel> panelesOpciones = new ArrayList<>();
    JFrame frame = new JFrame();
    int indicePanel = 0;

    public static void main(String[] args) {
        GuiRestaurante GUI = new GuiRestaurante();

        GUI.frame.setSize(1000,1000);
        GUI.frame.setVisible(true);
        //----------------botones--------------------

        JButton boton1, boton2, boton3, boton4, boton5, boton6;
        boton1 = new JButton("Panel 1");
        boton2 = new JButton("Panel 2");
        boton3 = new JButton("Panel 3");
        boton4 = new JButton("Panel 4");
        boton5 = new JButton("Panel 5");
        boton6 = new JButton("Panel 6");

        JPanel panelBotones = new JPanel(new GridLayout(6, 1, 0, 0));

        panelBotones.add(boton1); panelBotones.add(boton2); panelBotones.add(boton3);
        panelBotones.add(boton4); panelBotones.add(boton5); panelBotones.add(boton6);

        GUI.frame.add(panelBotones, BorderLayout.WEST);

        //-----------------titulo--------------------

        JLabel titulo = new JLabel("Titulo");

        JPanel panelTitulo = new JPanel();

        panelTitulo.add(titulo);

        GUI.frame.add(panelTitulo, BorderLayout.NORTH);

        //-----------------opciones--------------------



        JPanel pane1 = new JPanel();
        pane1.setBackground(Color.BLUE);
        GUI.frame.add(pane1, BorderLayout.CENTER);

        JPanel pane2 = new JPanel();
        pane2.setBackground(Color.RED);

        JPanel pane3 = new JPanel();
        pane3.setBackground(Color.GREEN);

        JPanel pane4 = new JPanel();
        pane4.setBackground(Color.ORANGE);

        JPanel pane5 = new JPanel();
        pane5.setBackground(Color.PINK);

        JPanel pane6 = new JPanel();
        pane6.setBackground(Color.YELLOW);



        GUI.panelesOpciones.add(pane1);
        GUI.panelesOpciones.add(pane2);
        GUI.panelesOpciones.add(pane3);
        GUI.panelesOpciones.add(pane4);
        GUI.panelesOpciones.add(pane5);
        GUI.panelesOpciones.add(pane6);


        boton1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                GUI.frame.remove(GUI.panelesOpciones.get(GUI.indicePanel));
                GUI.indicePanel = 0;
                GUI.frame.add(GUI.panelesOpciones.get(0),BorderLayout.CENTER);
            }
        } );

        boton2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                GUI.frame.remove(GUI.panelesOpciones.get(GUI.indicePanel));
                GUI.indicePanel = 1;
                GUI.frame.add(GUI.panelesOpciones.get(1),BorderLayout.CENTER);
            }
        } );

        boton3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                GUI.frame.remove(GUI.panelesOpciones.get(GUI.indicePanel));
                GUI.indicePanel = 2;
                GUI.frame.add(GUI.panelesOpciones.get(2),BorderLayout.CENTER);
            }
        } );

        boton4.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                GUI.frame.remove(GUI.panelesOpciones.get(GUI.indicePanel));
                GUI.indicePanel = 3;
                GUI.frame.add(GUI.panelesOpciones.get(3),BorderLayout.CENTER);
            }
        } );

        boton5.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                GUI.frame.remove(GUI.panelesOpciones.get(GUI.indicePanel));
                GUI.indicePanel = 4;
                GUI.frame.add(GUI.panelesOpciones.get(4),BorderLayout.CENTER);
            }
        } );

        boton6.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                GUI.frame.remove(GUI.panelesOpciones.get(GUI.indicePanel));
                GUI.indicePanel = 5;
                GUI.frame.add(GUI.panelesOpciones.get(5),BorderLayout.CENTER);
            }
        } );
    }
}

JPanel paneOpcion = new JPanel(new FlowLayout());
frame.add(paneOpcion, BorderLayout.CENTER);

            GUI.panelesOpciones.get(1).setVisible(false);
            GUI.panelesOpciones.get(2).setVisible(false);
            GUI.panelesOpciones.get(3).setVisible(false);
            GUI.panelesOpciones.get(4).setVisible(false);
            GUI.panelesOpciones.get(5).setVisible(false);
        */