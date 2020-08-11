package GUI;

import javafx.scene.text.Font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;

public class agregar_borrarPlatoGUI{
    String nombrePlato;
    JPanel listaPlatos;
    JPanel contenedor = new JPanel();

    public void mostrarMenu(ArrayList<String> platosDelMenu, JPanel contenedor){
        listaPlatos = new JPanel();
        contenedor.add(listaPlatos);
        listaPlatos.setBackground(Color.white);
        listaPlatos.setBounds(30,60,440,230);
        JLabel textoMenu = new JLabel("MENU: ");
        contenedor.add(textoMenu);
        textoMenu.setBounds(30,30,100,20);

        int y = 10;
        int x = 10;
        for (String plato_aux : platosDelMenu) {
            if(y == 210){
                x += 110;
                y = 10;
            }
            JLabel label_aux = new JLabel("\200 " + plato_aux);
            listaPlatos.add(label_aux);
            label_aux.setBounds(x,y,100,25);
            y += 20;
        }
    }

    public agregar_borrarPlatoGUI(ArrayList<String> platosDelMenu){
        JFrame f = new JFrame("dou");
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(600,600);
        f.add(contenedor);

        contenedor.setBackground(Color.gray);
        contenedor.setBounds(0,0,500,380);

        JLabel label = new JLabel("Nombre plato: ");
        contenedor.add(label);
        label.setBounds(40,290,100,50);

        JTextField texto = new JTextField();
        contenedor.add(texto);
        texto.setBounds(40,330,150,25);

        JButton botonAgregar = new JButton("Agregar");
        contenedor.add(botonAgregar);
        botonAgregar.setBounds(250,330,100,30);

        JButton botonEliminar = new JButton("Eliminar");
        contenedor.add(botonEliminar);
        botonEliminar.setBounds(360,330,100,30);

        mostrarMenu(platosDelMenu,contenedor);

        botonAgregar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                //abrir ventana confirmacion
                if(!texto.getText().equals("") && !platosDelMenu.contains(texto.getText())){
                    System.out.println("agregado");
                    nombrePlato = texto.getText();
                    platosDelMenu.add(nombrePlato);
                    contenedor.remove(listaPlatos);
                    mostrarMenu(platosDelMenu,contenedor);
                    //actualizarMenu(GUI_ab.nombrePlato);
                }
            }
        } );

        botonEliminar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                //abrir ventana confirmacion
                if(!texto.getText().equals("") && platosDelMenu.contains(texto.getText())){
                    System.out.println("eliminado");
                    nombrePlato = texto.getText();
                    platosDelMenu.remove(nombrePlato);
                    contenedor.remove(listaPlatos);
                    mostrarMenu(platosDelMenu,contenedor);
                    //actualizarMenu(platosDelMenu);
                }
            }
        } );
    }
    public static void main(String[] args) {
        ArrayList<String> platosDelMenu = new ArrayList<>();
        platosDelMenu.add("dou");
        platosDelMenu.add("dfdf");
        platosDelMenu.add("dodfdfu");
        platosDelMenu.add("ddfhdghou");
        platosDelMenu.add("dfghfou");
        platosDelMenu.add("ddfgdfgou");
        platosDelMenu.add("dsfdgsou");
        platosDelMenu.add("dbou");
        platosDelMenu.add("dfrdf");
        platosDelMenu.add("dodfwdfu");
        platosDelMenu.add("ddfehdghou");
        platosDelMenu.add("dfsghfou");
        platosDelMenu.add("ddfgdhfgou");
        platosDelMenu.add("dsfdggsou");
        platosDelMenu.add("fdou");
        platosDelMenu.add("dfgdf");
        platosDelMenu.add("dodgfdfu");
        platosDelMenu.add("ddfhhdghou");
        platosDelMenu.add("dfghhfou");
        platosDelMenu.add("ddfsgdfgou");
        platosDelMenu.add("dsffdgsou");
        platosDelMenu.add("dhou");
        platosDelMenu.add("dfhdf");
        platosDelMenu.add("dodfhdfu");
        platosDelMenu.add("dgdfhdghou");
        platosDelMenu.add("dfghgfou");
        platosDelMenu.add("ddfgssdfgou");
        platosDelMenu.add("dsfdghsou");
        new agregar_borrarPlatoGUI(platosDelMenu);
    }
}

/*
package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;

public class agregar_borrarPlatoGUI{
    String nombrePlato;

    public boolean comprobarExistencia(String plato, HashSet<String> platosDelMenu){
        for(String plato_aux : platosDelMenu){
            if(plato.equals(plato_aux)) return true;
        }
        return false;
    }

    public void mostrarMenu(HashSet<String> platosDelMenu, JPanel contenedor){
        int y = 70;
        int x = 50;
        for (String plato_aux : platosDelMenu) {
            if(y == 250){
                x += 110;
                y = 70;
            }
            JLabel label_aux = new JLabel("\200 " + plato_aux);
            contenedor.add(label_aux);
            label_aux.setBounds(x,y,100,25);
            y += 20;
        }
    }

    public agregar_borrarPlatoGUI(HashSet<String> platosDelMenu){
        JFrame f = new JFrame("dou");
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(1000,1000);

        JPanel contenedor = new JPanel();
        contenedor.setBackground(Color.gray);
        contenedor.setBounds(200,100,500,380);

        JLabel textoMenu = new JLabel("MENU: ");
        contenedor.add(textoMenu);
        textoMenu.setBounds(50,20,100,20);

        JLabel label = new JLabel("Nombre plato: ");
        contenedor.add(label);
        label.setBounds(50,290,100,50);

        JTextField texto = new JTextField();
        contenedor.add(texto);
        texto.setBounds(50,330,150,25);

        JButton botonAgregar = new JButton("Agregar");
        contenedor.add(botonAgregar);
        botonAgregar.setBounds(250,330,100,30);

        JButton botonEliminar = new JButton("Eliminar");
        contenedor.add(botonEliminar);
        botonEliminar.setBounds(360,330,100,30);

        mostrarMenu(platosDelMenu,contenedor);

        f.add(contenedor);

        botonAgregar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                //abrir ventana confirmacion
                if(!comprobarExistencia(texto.getText(), platosDelMenu)){
                    System.out.println("agregado");
                    nombrePlato = texto.getText();
                    platosDelMenu.add(nombrePlato);
                    //actualizarMenu(GUI_ab.nombrePlato);
                }
            }
        } );

        botonEliminar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                //abrir ventana confirmacion
                if(comprobarExistencia(texto.getText(), platosDelMenu)){
                    System.out.println("eliminado");
                    nombrePlato = texto.getText();
                    platosDelMenu.remove(nombrePlato);
                    //actualizarMenu(platosDelMenu);
                }
            }
        } );
    }

    public static void main(String[] args) {
        HashSet<String> platosDelMenu = new HashSet<>();
        platosDelMenu.add("dou");
        platosDelMenu.add("dfdf");
        platosDelMenu.add("dodfdfu");
        platosDelMenu.add("ddfhdghou");
        platosDelMenu.add("dfghfou");
        platosDelMenu.add("ddfgdfgou");
        platosDelMenu.add("dsfdgsou");
        platosDelMenu.add("dbou");
        platosDelMenu.add("dfrdf");
        platosDelMenu.add("dodfwdfu");
        platosDelMenu.add("ddfehdghou");
        platosDelMenu.add("dfsghfou");
        platosDelMenu.add("ddfgdhfgou");
        platosDelMenu.add("dsfdggsou");
        platosDelMenu.add("fdou");
        platosDelMenu.add("dfgdf");
        platosDelMenu.add("dodgfdfu");
        platosDelMenu.add("ddfhhdghou");
        platosDelMenu.add("dfghhfou");
        platosDelMenu.add("ddfsgdfgou");
        platosDelMenu.add("dsffdgsou");
        platosDelMenu.add("dhou");
        platosDelMenu.add("dfhdf");
        platosDelMenu.add("dodfhdfu");
        platosDelMenu.add("dgdfhdghou");
        platosDelMenu.add("dfghgfou");
        platosDelMenu.add("ddfgssdfgou");
        platosDelMenu.add("dsfdghsou");
        agregar_borrarPlatoGUI GUI_ab = new agregar_borrarPlatoGUI(platosDelMenu);
    }
}

//agregar_borrarPlatoGUI agregar_borrarPlato = new agregar_borrarPlatoGUI();

 */