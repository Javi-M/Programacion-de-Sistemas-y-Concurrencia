package ejercicio3;

public class Main {

	public static void main(String[] args) {
		VariableCompartida v = new VariableCompartida(0);
		MiHebraModificadora hebraModificadora = new MiHebraModificadora(v);
		MiHebraImpresora hebraImpresora = new MiHebraImpresora(v);
		
		hebraModificadora.start();
		hebraImpresora.start();
		
		try {
			hebraModificadora.join();
			hebraImpresora.join();
		} catch (InterruptedException e) {}
		
		
	}

}
