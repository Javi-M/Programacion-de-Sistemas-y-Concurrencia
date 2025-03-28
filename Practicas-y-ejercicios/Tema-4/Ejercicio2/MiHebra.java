package Ejercicio2;

public class MiHebra extends Thread {
    private VariableCompartida v;

    public MiHebra(VariableCompartida v) {
        this.v = v;
    }

    public void run() {
        for(int i = 0; i < 10; i++){
            v.inc();
        }
    }
}
