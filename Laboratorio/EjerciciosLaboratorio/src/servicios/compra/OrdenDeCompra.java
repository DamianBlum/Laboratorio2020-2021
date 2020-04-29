package servicios.compra;
public class OrdenDeCompra {
    //Atributos fecha, hora, importe a pagar,
    //   cliente, cantidad total de productos, forma de pago
    private String fecha;
    private String hora;
    private int importe_a_pagar;
    private String cliente;
    private int cantidad_total_productos;
    private String forma_pago;



    public int getCantidad_total_productos() {
        return this.cantidad_total_productos;
    }

    public int getImporte_a_pagar() {
        return this.importe_a_pagar;
    }

    public String getCliente() {
        return this.cliente;
    }

    public String getFecha() {
        return this.fecha;
    }

    public String getForma_pago() {
        return this.forma_pago;
    }

    public String getHora() {
        return this.hora;
    }

    public void setCantidad_total_productos(int cantidad_total_productos) {
        this.cantidad_total_productos = cantidad_total_productos;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setImporte_a_pagar(int importe_a_pagar) {
        this.importe_a_pagar = importe_a_pagar;
    }
    public boolean CantidadMenora255 (int cantidad_total_productos) {
        return cantidad_total_productos < 255;
    }
    public boolean PagaEnEfectivo(String forma_pago) {
        //si forma pago es en efectivo devuelve true
        return forma_pago.equals("efectivo") || forma_pago.equals("Efectivo");
    }

}
