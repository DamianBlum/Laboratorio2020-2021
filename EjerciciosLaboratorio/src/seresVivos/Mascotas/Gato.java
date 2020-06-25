package seresVivos.Mascotas;

public class Gato extends Mascotas {

    private int alegria;

    public Gato(String nombre, String propietario) {
        super(nombre, propietario);
        alegria=1;
    }

    @Override
    public void Saludar(String propietario) {
        if (this.getPropietario().equals(propietario)) {
            for (int i = 0; i <alegria ; i++) {
                System.out.print("miau ");
            }
            System.out.println();
        }
        else {
            System.out.println("MIAU!");
        }
    }

    @Override
    public void Alimentar() {
        alegria++;
    }

    @Override
    public String TipoDeMascota(){
        return "Gato";
    }

    public int getAlegria() {
        return alegria;
    }

    public void setAlegria(int alegria) {
        this.alegria = alegria;
    }
}
