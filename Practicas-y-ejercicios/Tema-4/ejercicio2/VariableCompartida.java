package ejercicio2;

public class VariableCompartida {
    private int numero;

    public VariableCompartida(int numero){
        this.numero = numero;
    }

    public int get() {
        return numero;
    }
    
    public void set(int numero) {
        this.numero = numero;
    }

    public void inc(){
        this.numero++;
    }
}
