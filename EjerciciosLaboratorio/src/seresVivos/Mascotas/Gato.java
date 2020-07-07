package seresVivos.Mascotas;

public class Gato extends Mascotas {

    private String raza;

    public Gato(String nombre, String propietario, String fechaDeNacimiento, String raza) {
        super(nombre, propietario, fechaDeNacimiento);
        this.raza = raza;
    }

    @Override
    public String TipoDeMascota(){
        return "Gato";
    }

    @Override
    public boolean cumplioConLasVisitasAnuales(String anio){
        int visitasAnuales=0;
        for (String fecha:getListaFechas()) {
            if(fecha.substring(6).equals(anio)) {
                visitasAnuales++;
            }
        }
        if (visitasAnuales==2) {
            return true;
        }
        else {
            return false;
        }
    }





    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
