package seresVivos.Mascotas;

public class Tortuga extends Mascotas {

    private String raza;

    public Tortuga(String nombre, String propietario, String fechaDeNacimiento, String raza) {
        super(nombre, propietario, fechaDeNacimiento);
        this.raza = raza;
    }

    @Override
    public String TipoDeMascota(){
        return "Tortuga";
    }

    @Override
    public boolean cumplioConLasVisitasAnuales(String anio){
        int visitasAnuales=0;
        for (String fecha:getListaFechas()) {
            if(fecha.substring(6).equals(anio)) {
                visitasAnuales++;
            }
        }
        if (visitasAnuales==1) {
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