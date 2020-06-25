package seresVivos.Mascotas;

public class Pajarito extends Mascotas {

    private int alegria;

    public Pajarito(String nombre, String propietario) {
        super(nombre, propietario);
        alegria=1;
    }

    @Override
    public void Saludar(String propietario) {
        if (this.getPropietario().equals(propietario)) {
            for (int i = 0; i <alegria ; i++) {
                System.out.print("pio ");
            }
            System.out.println();
        }
    }

    @Override
    public void Alimentar() {
        alegria++;
    }

    public int getAlegria() {
        return alegria;
    }

    public void setAlegria(int alegria) {
        this.alegria = alegria;
    }

    @Override
    public String TipoDeMascota(){
        return "Pajarito";
    }
}
