package servicios;

public class Editorial {
    private String nombre;
    private int ventasDias;

    public Editorial(String nombre, int ventasDias) {
        this.nombre = nombre;
        this.ventasDias = ventasDias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVentasDias() {
        return ventasDias;
    }

    public void setVentasDias(int ventasDias) {
        this.ventasDias = ventasDias;
    }
    public void addVentasDias() {
        this.ventasDias++;
    }
}
