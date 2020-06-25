package seresVivos.Mascotas;

public class Mascotas {

    private String nombre;
    private String propietario;

    public Mascotas(String nombre, String propietario) {
        this.nombre=nombre;
        this.propietario=propietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void Saludar(String propietario) {
        System.out.println("Saludo no defenido");
    }
    public String TipoDeMascota(){
        System.out.println("Mascota no definida");
        return "";
    }
    public void Alimentar() {
        System.out.println("Alimento no definido");
    }

}
