package main;
import seresVivos.*;
import java.util.HashSet;
public class MainDePrueba {

        public static void main(String[] argum){
        Hijo hijo1=new Hijo();
        Hijo hijo2=new Hijo();
        Hijo hijo3=new Hijo();
        Hijo hijo4=new Hijo();
        Hijo hijo5=new Hijo();
        Hijo hijo6=new Hijo();
        HashSet<Hijo> Hijos= new HashSet<>();
        Hijos.add(hijo1);
        Hijos.add(hijo2);
        Hijos.add(hijo3);
        Madre mama1= new Madre("Maria",43,"Fernandez",28578904,"Levite",Hijos);
        mama1.getHijosMenoresDeEdad();
    }

}
