package matematicas;

public class InstruccionConNumero extends Instruccion {
    private Integer valor;

    public InstruccionConNumero(String operacion,Integer valor){
        super(operacion);
        this.valor=valor;
    }

    public Integer getValor() {
        return valor;
    }
    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
