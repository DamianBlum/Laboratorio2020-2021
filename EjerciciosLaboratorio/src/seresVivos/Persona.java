package seresVivos;

public class Persona
{
    private String nombre;
    private int edad;


    public Persona() {
        this("Juan",15);
    }
    public Persona(String Nombre,int Edad) {
        nombre= Nombre;
        edad=Edad;



    }




    public int getEdad() {
        return this.edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public boolean esMayorDeEdad(int edad) {
        //si su edad es mayor a 18
        return edad>18;
    }

    public boolean tienenLaMismaEdad(Persona persona2) {
        //compara y devuelve si las edades son las mismas
        return this.getEdad() == persona2.getEdad();
    }
}