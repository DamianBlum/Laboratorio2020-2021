package matematicas;

import matematicas.*;

import java.util.ArrayList;

public class Calculadora {

    private Programa programa;
    private ArrayList<Integer> pila;
    private ArrayList<Variable> memoria;


    public ArrayList<Integer> getPila() {
        return pila;
    }

    public ArrayList<Variable> getMemoria() {
        return memoria;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setMemoria(ArrayList<Variable> memoria) {
        this.memoria = memoria;
    }

    public void setPila(ArrayList<Integer> pila) {
        this.pila = pila;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public void add() {
        if (pila.size() == 0) pila.add(0);
        else if (pila.size() >1) {
            pila.add(pila.get(0) + pila.get(1));
            pila.remove(0);
            pila.remove(0);
        }
    }

    public void mul() {
        if (pila.size() == 0) pila.add(0);
        else if (pila.size() >1) {
            pila.add(pila.get(0) * pila.get(1));
            pila.remove(0);
            pila.remove(0);
        }
    }

    public void sub() {
        if (pila.size() == 0) pila.add(0);
        else if (pila.size() >1) {
            pila.add(pila.get(0) - pila.get(1));
            pila.remove(0);
            pila.remove(0);
        }
    }

    public void push(Integer num) {
        pila.add(num);
    }

    public void write(Variable num) {
        num.setValor(pila.get(0));
        pila.remove(0);
    }

    public void read(Variable num) {
        pila.add(num.getValor());
    }

    public Variable buscarVariablePorSuNombre(String nombreVariable){

        for (Variable variable : memoria) {
            if (variable.getNombre().equals(nombreVariable)) {
                return variable;
            }
        }
        Variable nuevaVariable = new Variable(nombreVariable);
        memoria.add(nuevaVariable);
        return nuevaVariable;

    }

    public void cargarPrograma(Programa programaACargar){ this.programa=programaACargar; }

    public void ejecutar(String nombreRutina){
        Variable variable;
        memoria= new ArrayList<Variable>();
        pila= new ArrayList<Integer>();
        for (Rutina aux : programa.getRutinas()) {
            if ((aux.getNombre()).equals(nombreRutina)){
                for (Instruccion instruccion_aux : aux.getInstrucciones()) {
                    switch (instruccion_aux.getOperacion()){
                        case "add":
                            add();
                            break;
                        case "mul":
                            mul();
                            break;
                        case "sub":
                            sub();
                            break;
                        case "push":
                            InstruccionConNumero instruccionConNumero =(InstruccionConNumero) instruccion_aux;
                            push(instruccionConNumero.getValor());
                            break;
                        case "write":
                            InstruccionConVariable instruccionConVariable =(InstruccionConVariable) instruccion_aux;
                            variable = buscarVariablePorSuNombre(instruccionConVariable.getNombreVariable());
                            write(variable);
                            break;
                        default:
                            InstruccionConVariable instruccionConVariable2 =(InstruccionConVariable) instruccion_aux;
                            variable = buscarVariablePorSuNombre(instruccionConVariable2.getNombreVariable());
                            read(variable);
                            break;

                    }
                }
            }
        }
        pila.clear();
        memoria.clear();
    }

    public static void main(String[] args) {
        String PUSH="push";
        String WRITE="write";
        String READ="read";
        String ADD="add";
        String SUB="sub";
        String MUL="mul";

        Programa p = new Programa();
        Instruccion instrunccion1=new InstruccionConNumero(PUSH, 2);
        p.agregarInstruccion("rutina1",instrunccion1) ;
        p.agregarInstruccion("rutina1", new Instruccion(ADD));
        Instruccion instrunccion2=new InstruccionConVariable(WRITE, "y");
        p.agregarInstruccion("rutina1",instrunccion2) ;
        Instruccion instrunccion3=new InstruccionConVariable(READ, "x");
        p.agregarInstruccion("rutina1",instrunccion3);


        Instruccion instrunccion4=new InstruccionConVariable(READ, "x");
        p.agregarInstruccion("rutina2",instrunccion4);
        p.agregarInstruccion("rutina2",new Instruccion(MUL));
        Instruccion instrunccion5=new InstruccionConVariable(WRITE, "x");
        p.agregarInstruccion("rutina2",instrunccion5);
        Instruccion instrunccion6=new InstruccionConNumero(PUSH, 2);
        p.agregarInstruccion("rutina2",instrunccion6);

        Calculadora calc = new Calculadora();
        calc.cargarPrograma(p);
        calc.ejecutar("rutina2");
    }


}
