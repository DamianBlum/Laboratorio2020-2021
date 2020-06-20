package Objetos;

public enum Cuaderno {
    chico(24,60), mediano(48,100), grande(96,190);

    private int hojas;
    private int precio;

    private Cuaderno(int hojas, int precio) {
        this.hojas=hojas;
        this.precio=precio;
    }

    public int getHojas() {return this.hojas;}

    public int getPrecio() {
        return precio;
    }
}
