package Veterinaria;

public abstract class Mascota2 {
    private String Nombre;
    private String Dueno;

    public Mascota2(String nombre, String dueno) {
        Nombre = nombre;
        Dueno = dueno;
    }

    public abstract String tipoMascota();

    public abstract void saludo(boolean duenoCorrecto);

    public abstract void alimentar();

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDueno() {
        return Dueno;
    }

    public void setDueno(String dueno) {
        Dueno = dueno;
    }
}
