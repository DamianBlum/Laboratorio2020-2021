package matematicas;

public class InstruccionConVariable extends Instruccion {
    private String nombreVariable;

    public InstruccionConVariable(String operacion, String nombreVariable){
        super(operacion);
        this.nombreVariable=nombreVariable;
    }
    public String getNombreVariable() {
        return nombreVariable;
    }
    public void setNombreVariable(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }
}
