package servicios;


public enum Dia {
    Lunes(0),Martes(0),Miercoles(0),Jueves(0),Viernes(0),Sabado (0),Domingo(0);
    private int cantVentasDia;

    private Dia(int cantVentasDia){
        this.cantVentasDia = cantVentasDia;
    }

    public int getCantVentasDia() {
        return cantVentasDia;
    }

    public void setCantVentasDia(int cantVentasDia){
        this.cantVentasDia = cantVentasDia;
    }

}