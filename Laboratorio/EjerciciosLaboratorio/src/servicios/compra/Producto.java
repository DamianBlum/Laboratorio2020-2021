package servicios.compra;

public class Producto {
    private int precio;
    private String nombre;
    private String marca;
    private int unidades;

    public Producto () {
    }
    public Producto (int precioX, int Xunidades, String nombreX, String marcaX) {
        precio=precioX;
        nombre=nombreX;
        unidades=Xunidades;
        marca=marcaX;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}

