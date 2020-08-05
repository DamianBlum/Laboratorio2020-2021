package servicios.compra;

import seresVivos.Persona;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;
/*PANTALLA COMPLETA */
public class RegistroDeDatos {
    public static void main(String[] args) {

        ArrayList <Persona> Personas= new ArrayList<>();

        JFrame ventana= new JFrame();
        ventana.setLayout(null);

        ventana.setSize(500,700);
        ventana.setVisible(true);

        JLabel nombre= new JLabel();
        nombre.setText("Ingrese nombre");
        nombre.setLocation(200,25);
        nombre.setSize(100,100);
        ventana.add(nombre);

        JTextField campoNombre= new JTextField();
        campoNombre.setLocation(150,100);
        campoNombre.setSize(200,25);
        ventana.add(campoNombre);

        JLabel apellido= new JLabel();
        apellido.setText("Ingrese apellido");
        apellido.setLocation(200,100);
        apellido.setSize(100,100);
        ventana.add(apellido);


        JTextField campoApellido= new JTextField();
        campoApellido.setLocation(150,175);
        campoApellido.setSize(200,25);
        ventana.add(campoApellido);

        JLabel edad= new JLabel();
        edad.setText("Ingrese edad");
        edad.setLocation(200,175);
        edad.setSize(100,100);
        ventana.add(edad);

        JTextField campoEdad= new JTextField();
        campoEdad.setLocation(150,250);
        campoEdad.setSize(200,25);
        ventana.add(campoEdad);

        JLabel dni= new JLabel();
        edad.setText("Ingrese dni");
        edad.setLocation(200,250);
        edad.setSize(100,100);
        ventana.add(edad);

        JTextField campoDni= new JTextField();
        campoDni.setLocation(150,325);
        campoDni.setSize(200,25);
        ventana.add(campoDni);

        JButton boton= new JButton("Guardar Informacion");
        boton.setSize(200,25);
        boton.setLocation(150,400);
        ventana.add(boton);

        JLabel confirmacion= new JLabel();
        confirmacion.setLocation(200,450);
        confirmacion.setSize(100,100);
        ventana.add(confirmacion);

        boton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String nombrePersona=campoNombre.getText();
                String apellidoPersona=campoApellido.getText();
                int edadPersona=Integer.parseInt(campoEdad.getText());
                int dniPersona=Integer.parseInt(campoDni.getText());
                Persona nuevaPersona=new Persona(nombrePersona,edadPersona,apellidoPersona,dniPersona);
                confirmacion.setText("Registrado correctamente");

            }

        });

    }
}
