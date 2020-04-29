package servicios;

public class ProductoAlimenticio {
    // Atributos: nombre, precio, fecha de elaboración, fecha de vencimiento y peso.
    private String nombre;
    private int precio;
    private String fecha_elaboracion;
    private String fecha_vencimiento;
    private int peso_en_kilos;

    public int getPeso_en_kilos() {
        return this.peso_en_kilos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        return this.precio;
    }

    public String getFecha_elaboracion() {
        return this.fecha_elaboracion;
    }

    public String getFecha_vencimiento() {
        return this.fecha_vencimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha_elaboracion(String fecha_elaboracion) {
        this.fecha_elaboracion = fecha_elaboracion;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public void setPeso_en_kilos(int peso_en_kilos) {
        this.peso_en_kilos = peso_en_kilos;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public boolean PesoMayor5Kilos () {
        //si el peso es mayor a 5 kilos devuelve true
        return this.peso_en_kilos>5;
    }

}