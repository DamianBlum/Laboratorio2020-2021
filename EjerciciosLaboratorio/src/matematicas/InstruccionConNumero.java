package matematicas;

public class InstruccionConNumero extends Instruccion {
    private int valor;

    public InstruccionConNumero(String operacion,int valor){
        super(operacion);
        this.valor=valor;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
}
