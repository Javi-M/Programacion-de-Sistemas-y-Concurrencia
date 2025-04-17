package ejercicio2;

public class Main {

    public static void main(String[] args){
        VariableCompartida v = new VariableCompartida(0);

        MiHebra hebra1 = new MiHebra(v);
        MiHebra hebra2 = new MiHebra(v);

        hebra1.start();
        hebra2.start();

        System.out.println(v.get());
    }
}
