package GUI;

import javax.swing.*;
import java.awt.*;

public class GuiHotel extends JFrame{
    private JPanel Menu;
    private JPanel InformacionGeneral; /*top 6 huespedes, gente con estadia prolongada, dinero total, top 3 habitaciones, habitaciones disponibles,habitaciones ocupadas*/
    private JPanel InformacionHuesped;/*Tiempo huesped, huesped en una habitacion, fecha de entrada y salida*/
    private JPanel InformacionHospedaje;/*Importe a pagar,agregar dias de estadia*/


    public GuiHotel(){
        //this.acceso
        this.setTitle("Hotel");
        this.setSize(700,1000);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.Menu=new JPanel(new GridLayout(4,3));
        this.InformacionGeneral=new JPanel();
        this.InformacionHospedaje=new JPanel();
        this.InformacionHuesped=new JPanel();

        this.armarMenu();
        this.armarInformacionGeneral();
        this.armarInformacionHuesped();
        this.armarInformacionHospedaje();
        //acceso.conectar();
        this.setVisible(true);
    }

    public void armarMenu(){

    }


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

        JMenu opcion7= new JMenu("Tiempo de un Huesped");
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
