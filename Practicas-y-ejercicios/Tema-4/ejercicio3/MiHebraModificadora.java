package ejercicio3;

public class MiHebraModificadora extends Thread {
	private VariableCompartida v;
	
	public MiHebraModificadora(VariableCompartida v) {
		this.v = v;
	}
	
	public void run() {
		for(int i = 0; i<=99; i++) {
			v.set(i);
		}
	}
}
