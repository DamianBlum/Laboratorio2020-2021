package sistemas.administracion;
import java.util.ArrayList;
import seresVivos.Persona;

public class Hospital {
    //Atributos:lista de pacientes por atender
    //,nombre del hospital,lista de pacientes atendidos, lista de doctores, numero de camas disponibles
    private String nombreDelHospital;
    private ArrayList<Persona> listaPacientesPorAtender;
    private ArrayList<Persona> listaPacientesAtendidos ;
    private ArrayList<Persona> listaDoctoresAtendiendo ;
    private int camasDisponibles;

    public Hospital (ArrayList<Persona> PacientesPorAtender, ArrayList<Persona> PacientesAtendidos, ArrayList<Persona> DoctoresAtendiendo){
        nombreDelHospital="Berazategui";
        camasDisponibles=5;
        listaDoctoresAtendiendo= DoctoresAtendiendo;
        listaPacientesAtendidos= PacientesAtendidos;
        listaPacientesPorAtender=PacientesPorAtender;
    }

    public ArrayList<Persona> getListaDoctoresAtendiendo() {
        return this.listaDoctoresAtendiendo;
    }


    public ArrayList<Persona> getListaPacientesAtendidos() {
        return this.listaPacientesAtendidos;
    }

    public ArrayList<Persona> getListaPacientesPorAtender() {
        return this.listaPacientesPorAtender;
    }

    public int getCamasDisponibles() {
        return this.camasDisponibles;
    }

    public String getNombreDelHospital() {
        return this.nombreDelHospital;
    }

    public void setCamasDisponibles(int camasDisponibles) {
        this.camasDisponibles = camasDisponibles;
    }

    public void setListaDoctoresAtendiendo(ArrayList<Persona> listaDoctoresAtendiendo) {
        this.listaDoctoresAtendiendo = listaDoctoresAtendiendo;
    }

    public void setListaPacientesAtendidos(ArrayList<Persona> listaPacientesAtendidos) {
        this.listaPacientesAtendidos = listaPacientesAtendidos;
    }

    public void setListaPacientesPorAtender(ArrayList<Persona> listaPacientesPorAtender) {
        this.listaPacientesPorAtender = listaPacientesPorAtender;
    }

    public void setNombreDelHospital(String nombreDelHospital) {
        this.nombreDelHospital = nombreDelHospital;
    }
    public int cantidadDePacientesAtendidos() {
        return this.listaPacientesAtendidos.size();
    }
    public void informacionPacientes(){
        //muestra la información de cada pacientes atendidos
        for (int i=0;i<this.listaPacientesAtendidos.size();i++) {
            Persona Roberto=listaPacientesAtendidos.get(i);
            System.out.println(Roberto.getApellido());
            System.out.println(Roberto.getEdad());
            System.out.println(Roberto.getNombre());
        }
    }
    public void agregarPacientesPorAtender(ArrayList<Persona> nuevasPersonaPorAtender) {
        //agrega un conjunto de persona a la lista por atender
        this.listaPacientesPorAtender.addAll(nuevasPersonaPorAtender);
    }
    public boolean eliminarPacientesPorAtender(int pacienteDNI ) {
        //busca en pacientes por atender a una persona por su dni y si lo encuentra devuelve true
        for (Persona Jorge : listaPacientesPorAtender) {
            if (pacienteDNI == Jorge.getDNI()) {
                return true;
            }
        }
        return false;
    }
    public  void agregarPacientesAtendidos(ArrayList<Persona> personasAtendidas) {
        //agrega un conjunto de persona a la lista de atendidos
        this.listaPacientesAtendidos.addAll(personasAtendidas);
    }
    public int camasDisponibles() {
        //Muestra cuantas camas hay
        return this.camasDisponibles;
    }

}
