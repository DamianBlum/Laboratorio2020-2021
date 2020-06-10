package Objetos;

public class Libro {
    private String Nombre;
    private String Editorial;
    private Double Precio;


    public Libro() {
        Nombre    = "Code";
        Editorial = "Sur";
        Precio    = 50.2;
    }

    public Libro(String Nombre, String Editorial, Double Precio) {
        this.Nombre    = Nombre;
        this.Editorial = Editorial;
        this.Precio    = Precio;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEditorial() {
        return this.Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public Double getPrecio() {
        return this.Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

}





