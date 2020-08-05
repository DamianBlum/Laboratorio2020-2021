package main;

import javax.swing.*;

public class GuiHotel {
    public static void main(String[] args) {
        JFrame ventana= new JFrame();
        ventana.setLayout(null);
        ventana.setSize(700,1000);
        ventana.setVisible(true);
        ventana.setTitle("Hotel");

        JMenuBar barraDeMenu= new JMenuBar();
        ventana.setJMenuBar(barraDeMenu);

        JMenu opcion1= new JMenu("Top 6 Huespedes");
        barraDeMenu.add(opcion1);

        JMenu opcion2= new JMenu("Gente con estadia prolongada");
        barraDeMenu.add(opcion2);

        JMenu opcion3= new JMenu("Dinero total");
        barraDeMenu.add(opcion3);

        JMenu opcion4= new JMenu("Top 3 Habitaciones");
        barraDeMenu.add(opcion4);

        JMenu opcion5= new JMenu("Habitaciones disponibles");
        barraDeMenu.add(opcion5);

        JMenu opcion6= new JMenu("Habitaciones ocupadas");
        barraDeMenu.add(opcion6);

        JMenu opcion7= new JMenu("Tiempo de im Huesped");
        barraDeMenu.add(opcion7);

        JMenu opcion8= new JMenu("Huesped en una habitacion");
        barraDeMenu.add(opcion8);

        JMenu opcion9= new JMenu("Fecha de entrada y salida");
        barraDeMenu.add(opcion9);

        JMenu opcion10= new JMenu("Importe a pagar");
        barraDeMenu.add(opcion10);

        JMenu opcion11= new JMenu("Agregar dias de estadia");
        barraDeMenu.add(opcion11);
        
    }
}
