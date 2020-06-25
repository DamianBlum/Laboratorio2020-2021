package seresVivos.Mascotas;

public class Perro extends Mascotas {

    private int alegria;

    public Perro(String nombre, String propietario) {
        super(nombre, propietario);
        alegria=1;
    }

    @Override
    public void Saludar(String propietario) {
        if (this.getPropietario().equals(propietario)) {
            for (int i = 0; i <alegria ; i++) {
                System.out.print("guau ");
            }
            System.out.println();
        }
        else {
            System.out.println("GUAU!");
        }
    }

    @Override
    public void Alimentar() {
        alegria++;
    }

    @Override
    public String TipoDeMascota(){
        return "Perro";
    }

    public int getAlegria() {
        return alegria;
    }

    public void setAlegria(int alegria) {
        this.alegria = alegria;
    }
}
