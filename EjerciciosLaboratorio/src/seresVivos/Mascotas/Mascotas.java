package seresVivos.Mascotas;

import java.util.ArrayList;

public class Mascotas {

    private String nombre;
    private String propietario;
    private String fechaDeNacimineto;
    private ArrayList<String> listaFechas;

    public Mascotas(String nombre, String propietario, String fechaDeNacimineto) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.fechaDeNacimineto=fechaDeNacimineto;
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

    public String getFechaDeNacimineto() {
        return fechaDeNacimineto;
    }

    public void setFechaDeNacimineto(String fechaDeNacimineto) {
        this.fechaDeNacimineto = fechaDeNacimineto;
    }

    public String TipoDeMascota() {
        System.out.println("Mascota no definida");
        return "";
    }

    public ArrayList<String> getListaFechas() {
        return listaFechas;
    }

    public void setListaFechas(ArrayList<String> listaFechas) {
        this.listaFechas = listaFechas;
    }
    public boolean cumplioConLasVisitasAnuales(String anio){
        System.out.println("No se sabe que tipo de mascota es");
        return false;
    }


    public boolean visitasAnualesPerfectas(){
        int anio=Integer.parseInt(getFechaDeNacimineto().substring(6));
        for (int i = anio; i <2020 ; i++) {
            if(!cumplioConLasVisitasAnuales(String.valueOf(i))) {
                return false;
            }
        }
        return true;
    }
}

