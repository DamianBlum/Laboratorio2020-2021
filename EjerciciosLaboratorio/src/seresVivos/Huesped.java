package seresVivos;

public class Huesped extends Persona{

    private int cantVisitas;

    public Huesped (String nombre, String apellido, int edad, int dni){
        super(nombre,edad,apellido,dni);
        this.cantVisitas = 1;
    }
    public Huesped (String nombre, String apellido){
        super(nombre,apellido);
        this.cantVisitas = 1;
    }

    public int getCantVisitas() {
        return cantVisitas;
    }

    public void setCantVisitas(int cantVisitas) {
        this.cantVisitas = cantVisitas;
    }
}

