package seresVivos.Mascotas;

public class Pez extends Mascotas {

    private int vidas;

    public Pez(String nombre, String propietario) {
        super(nombre, propietario);
        vidas=10;
    }

    @Override
    public void Saludar(String propietario) {
        if (this.getPropietario().equals(propietario)) {
            vidas--;
        }
        else {
            vidas=0;
        }
    }

    @Override
    public String TipoDeMascota(){
        return "Pez";
    }

    @Override
    public void Alimentar() {
        vidas++;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
}
