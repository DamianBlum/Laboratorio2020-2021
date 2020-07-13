package main;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfazGrafica {
    public static void main(String[] args) {
        JFrame ventana= new JFrame();
        ventana.setLayout(null);
        ventana.setSize(500,500);
        ventana.setVisible(true);

        JLabel textoATriplicar= new JLabel();
        textoATriplicar.setText("Aguantaa");
        textoATriplicar.setSize(500,200);
        textoATriplicar.setLocation(25,25);

        JButton botonDeTriplicar= new JButton("Triplicar");
        botonDeTriplicar.setSize(500,40);
        botonDeTriplicar.setLocation(00,350);

        ventana.add(textoATriplicar);
        ventana.add(botonDeTriplicar);



        botonDeTriplicar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String texto=textoATriplicar.getText();
                texto=texto+texto+texto;
                textoATriplicar.setText(texto);
            }

        });
    }
}
