/*package seresVivos;
import java.util.HashSet;
public class Madre extends Persona {
    private String NombreEmpresa;
    private HashSet<Hijo> Hijos;

    public Madre(String Nombre, int Edad, String Apellido, int dni, String NombreEmpresa, HashSet<Hijo> hijos){
        super(Nombre, Edad, Apellido, dni);
        this.NombreEmpresa=NombreEmpresa;
        this.Hijos=hijos;
    }
    public Madre(){
        super("Eugenia",40,"Bellini",44655302);
        this.NombreEmpresa="Hospital Aleman";
        this.Hijos=new HashSet<>();
    }

    public HashSet<Hijo> getHijos() {
        return Hijos;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        NombreEmpresa = nombreEmpresa;
    }

    public void setHijos(HashSet<Hijo> hijos) {
        Hijos = hijos;
    }


    public HashSet<Hijo> getHijosMenoresDeEdad() {
        HashSet<Hijo> hijosMenoresDeEdad= new HashSet<Hijo>();
        System.out.println(Hijos.size());
        for (Hijo hijoAuxiliar:Hijos) {
            if (hijoAuxiliar.getEdad()<18) {
                hijosMenoresDeEdad.add(hijoAuxiliar);
            }
        }
        System.out.println(hijosMenoresDeEdad.size());
        return hijosMenoresDeEdad;
    }
}
*/