package sistemas.administracion;


public class Habitacion {

    private int numerohabitacion;
    private int cantusos;
    private boolean libre;

    public Habitacion (int numeroHabitacion){
        this.numerohabitacion = numeroHabitacion;
        this.cantusos = 0;
        this.libre = true;
    }

    public int getCantUsos() {
        return cantusos;
    }

    public int getNumeroHabitacion() {
        return numerohabitacion;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numerohabitacion = numeroHabitacion;
    }

    public void setCantUsos(int cantUsos) {
        this.cantusos = cantUsos;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    /*
    bien!
     */
}

