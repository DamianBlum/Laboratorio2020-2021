package matematicas;

public class Instruccion {
    private String operacion;



    public Instruccion(String operacion) {
        this.operacion=operacion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

}
