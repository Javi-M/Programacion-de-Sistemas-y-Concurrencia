package ejercicio3;

public class MiHebraImpresora extends Thread {
	private VariableCompartida v;
	
	public MiHebraImpresora(VariableCompartida v) {
		this.v = v;
	}
	
	@Override
	public void run() {
		while(v.get() <= 99 && !(v.acabado)) {
			if (v.puedeImprimir) {
				System.out.println(v.get());
				v.puedeEscribir = true;
				v.puedeImprimir = false;
			}
		}
	}

}
