package ejercicio3;

public class MiHebraModificadora extends Thread {
	private VariableCompartida v;
	
	public MiHebraModificadora(VariableCompartida v) {
		this.v = v;
	}
	
	public void run() {
		while (v.get() <= 99 && !(v.acabado)) {
			if (v.puedeEscribir) {
				v.puedeEscribir = false;
				v.puedeImprimir = true;
				v.inc();
			}
			if (v.get()==99) {
				v.acabado = true;
			}
		}
	}
}
